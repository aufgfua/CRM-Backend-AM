package com.guxo.crmbackend.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guxo.crmbackend.auth.WebSecurityConfig;
import com.guxo.crmbackend.auth.token.TokenUtility;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.MimeTypeUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {



    private final AuthenticationManager authenticationManager;
    private String jwtSecret;


    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        // just a base value for it to be initialized
        this.jwtSecret = "1234";
    }


    // Receives jwtSecret from WebSecurityConfig
    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    private String getJwtSecret() {
        return this.jwtSecret;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // SpringSecurity User
        User user = (User) authResult.getPrincipal(); // get Spring Security User from authResult

        Date accessTokenExpiration = new Date(
                System.currentTimeMillis()
                        + TimeUnit.MINUTES.toMillis(WebSecurityConfig.ACCESS_TOKEN_DURATION)); // Current Time + ACCESS_TOKEN_DURATION (10 minutes) = 10 minutes from login

        Date refreshTokenExpiration = new Date(
                System.currentTimeMillis()
                        + TimeUnit.DAYS.toMillis(WebSecurityConfig.REFRESH_TOKEN_DURATION)); // Current Time + ACCESS_TOKEN_DURATION (30 days) = 30 days from login


        // for this API, currently using only one role at a time (appUser.role)
        List<String> roles = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList(); // Get user authorities -> map GrantedAuthorities to their names -> transform into list again

        String issuer = request.getRequestURL().toString();

        String accessToken = TokenUtility.createAccessToken(
                user.getUsername(),
                roles,
                issuer,
                accessTokenExpiration,
                getJwtSecret()
        );
        String refreshToken = TokenUtility.createRefreshToken(
                user.getUsername(),
                issuer,
                refreshTokenExpiration,
                getJwtSecret()
        );


        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", accessToken);
        tokens.put("refresh_token", refreshToken);

        response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);

        new ObjectMapper().writeValue(response.getOutputStream(), tokens);

    }
}

