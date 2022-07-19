package com.guxo.crmbackend.auth.token;

import com.guxo.crmbackend.appuser.AppUser;
import com.guxo.crmbackend.appuser.AppUserService;
import com.guxo.crmbackend.auth.WebSecurityConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Service
public class TokenService implements UserDetailsService {

    // Autowired - AppUserService
    private final AppUserService appUserService;


    // Autowired - Secret is loaded in CrmBackendApplication as Bean
    @Qualifier("jwtSecret")
    private final String jwtSecret;


    // given refreshToken and issuer, creates access token
    public String getNewAccessToken(String refreshToken, String issuer){

        String username = TokenUtility.getUsernameFromToken(refreshToken, jwtSecret); // get from utility

        List<String> roles = List.of(
                appUserService.getAppUserByUsername(username).getRole().name()
        ); // get user role name and transform to string list

        Date accessTokenExpiration = new Date(
                System.currentTimeMillis()
                        + TimeUnit.MINUTES.toMillis(WebSecurityConfig.ACCESS_TOKEN_DURATION)); // Current Time + ACCESS_TOKEN_DURATION (10 minutes) = 10 minutes from login

        String accessToken = TokenUtility.createAccessToken(
                username,
                roles,
                issuer,
                accessTokenExpiration,
                jwtSecret
        );

        return accessToken;

    }


    // given refreshToken and issuer, recreates refresh token
    public String getNewRefreshToken(String refreshToken, String issuer){

        String username = TokenUtility.getUsernameFromToken(refreshToken, jwtSecret); // get from utility

        boolean isRefreshToken = TokenUtility.isRefreshToken(refreshToken, jwtSecret);

        if(!isRefreshToken) {
            throw new IllegalStateException("Given token is not a refresh token");
        }

        Date refreshTokenExpiration = new Date(
                System.currentTimeMillis()
                        + TimeUnit.DAYS.toMillis(WebSecurityConfig.REFRESH_TOKEN_DURATION)); // Current Time + ACCESS_TOKEN_DURATION (10 minutes) = 10 minutes from login

        String newRefreshToken = TokenUtility.createRefreshToken(
                username,
                issuer,
                refreshTokenExpiration,
                jwtSecret
        );

        return newRefreshToken;

    }



    // used for WebSecurityConfig - config
    // receives String for username and returns a new SpringSecurity User -> (username, password, roles).
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserService.getAppUserByUsername(username); // retrieves AppUser from AppUserService
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(appUser.getRole().name())); // create SimpleGrantedAuthority from AppUser.Role
        User springSecurityUser = new User(appUser.getUsername(), appUser.getPassword(), authorities); // create SpringSecurity User (username, password, authorities)
        return springSecurityUser;
    }
}
