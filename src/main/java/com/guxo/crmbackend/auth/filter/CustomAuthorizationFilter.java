package com.guxo.crmbackend.auth.filter;

import com.guxo.crmbackend.auth.token.TokenUtility;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CustomAuthorizationFilter extends OncePerRequestFilter {

    private String jwtSecret = "1234";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String path = request.getServletPath();


        // TODO create a better mapping format to these paths
        if(path.startsWith("/login") || path.startsWith("/token/refresh") || path.startsWith("/api-docs") || path.startsWith("/swagger")) {
            System.out.println(path.toString());

            filterChain.doFilter(request, response); // skip /login requests

        } else {

            String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION); // get Authorization header

            if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) { // Authorization token starts with Bearer

                String token = authorizationHeader.substring("Bearer ".length()); // get string after "Bearer ".length chars

                String jwtSecret = getJwtSecret();

                String username = TokenUtility.getUsernameFromToken(token, jwtSecret); // get from utility
                String[] roles = TokenUtility.getRolesFromToken(token, jwtSecret); // get from utility

                if(roles.length == 0) {
                    throw new IllegalStateException("Invalid Token Format");
                }


                Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                Arrays.stream(roles).forEach(role -> {
                    authorities.add(new SimpleGrantedAuthority(role)); // transform each role string to a SimpleGrantedAuthority for authorisation
                });
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);

                SecurityContextHolder.getContext().setAuthentication(authenticationToken); // pass to SpringSecurity what are the roles set for the user


            }
            filterChain.doFilter(request, response); // go on
        }

    }


    // Receives jwtSecret from WebSecurityConfig
    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    private String getJwtSecret() {
        return this.jwtSecret;
    }
}
