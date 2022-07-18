package com.guxo.crmbackend.auth;

import com.guxo.crmbackend.appuser.AppUserRole;
import com.guxo.crmbackend.auth.filter.CustomAuthenticationFilter;
import com.guxo.crmbackend.auth.filter.CustomAuthorizationFilter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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




    public static final Integer ACCESS_TOKEN_DURATION = 50; // minutes
    public static final Integer REFRESH_TOKEN_DURATION = 30; // days



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

        http.csrf().disable(); // disable cross site requests (?)
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests().antMatchers("/login/**").permitAll();
        http.authorizeRequests().antMatchers("/swagger-ui.html").permitAll();
        http.authorizeRequests().antMatchers("/swagger-ui/**").permitAll();
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
