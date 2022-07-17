package com.guxo.crmbackend.auth;

import com.guxo.crmbackend.auth.filter.CustomAuthenticationFilter;
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

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // TODO search and ask for non-deprecated ways of configuring Spring Security

    // Autowired - AppUserService
    private final UserDetailsService userDetailsService;

    // Autowired - PasswordEncoder Bean - CrmBackendApplication class
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Qualifier("jwtSecret")
    private final String jwtSecret;



    // configure authentication manager
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // passes userDetailsService (with loadByUsername -> (username, password, roles))
        // passes password encoder
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter((authenticationManagerBean()));
        customAuthenticationFilter.setJwtSecret(jwtSecret);

        http.csrf().disable(); // disable cross site requests (?)
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().anyRequest().permitAll();
        http.addFilter(customAuthenticationFilter);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
