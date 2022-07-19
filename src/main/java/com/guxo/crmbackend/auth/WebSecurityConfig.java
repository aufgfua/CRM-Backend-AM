package com.guxo.crmbackend.auth;

import com.guxo.crmbackend.appuser.AppUserRole;
import com.guxo.crmbackend.auth.filter.CustomAuthenticationFilter;
import com.guxo.crmbackend.auth.filter.CustomAuthorizationFilter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // TODO search and ask for non-deprecated ways of configuring Spring Security

    // Autowired - AppUserService
    private final UserDetailsService userDetailsService;

    // Autowired - PasswordEncoder Bean - CrmBackendApplication class
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // Autowired - Secret is loaded in CrmBackendApplication as Bean
    @Qualifier("jwtSecret")
    private final String jwtSecret;

    @Value("${files.user-uploaded}")
    private String filesRoot;


    public static final Integer ACCESS_TOKEN_DURATION = 10; // minutes
    public static final Integer REFRESH_TOKEN_DURATION = 15; // days



    // configure authentication manager
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // passes userDetailsService (with loadByUsername -> (username, password, roles))
        // passes password encoder
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CustomAuthorizationFilter customAuthorizationFilter = new CustomAuthorizationFilter();
        customAuthorizationFilter.setJwtSecret(jwtSecret);

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean()); // Filter for authentication
        customAuthenticationFilter.setJwtSecret(jwtSecret); // set secret to generate JWT

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        // XSS protection - Baeldung https://www.baeldung.com/spring-prevent-xss
        http    .headers()
                .xssProtection();
//                .and()
//                .contentSecurityPolicy("script-src 'self'");


        // TODO create a better mapping format to these paths
        // TODO discover the best way of allowing these paths access - no way this is the right way


        String filesRootAntMatcher = "/" + filesRoot + "/**";

        http.authorizeRequests().antMatchers("/login/**").permitAll();
        http.authorizeRequests().antMatchers(filesRootAntMatcher).permitAll();
        http.authorizeRequests().antMatchers("/swagger-ui.html").permitAll();
        http.authorizeRequests().antMatchers("/swagger-ui/**").permitAll();
        http.authorizeRequests().regexMatchers("^/swagger.*").permitAll();
        http.authorizeRequests().antMatchers("/swagger-resources/**").permitAll();
        http.authorizeRequests().antMatchers("/api-docs/**").permitAll();
        http.authorizeRequests().antMatchers("/token/refresh/**").permitAll();


        http.authorizeRequests().antMatchers("/api/customer/**").hasAnyAuthority(AppUserRole.USER.name(), AppUserRole.ADMIN.name());
        http.authorizeRequests().antMatchers("/api/user/**").hasAnyAuthority(AppUserRole.ADMIN.name());

        http.authorizeRequests().antMatchers("/api/**").authenticated();

        http.authorizeRequests().anyRequest().authenticated();

        http.addFilterBefore(customAuthorizationFilter, UsernamePasswordAuthenticationFilter.class); // the "Before" is for applying before any other filter (due to being for authorisation)
        http.addFilter(customAuthenticationFilter); // add created auth filter

    }



    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
