package com.guxo.crmbackend.auth.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guxo.crmbackend.appuser.AppUser;
import com.guxo.crmbackend.appuser.AppUserRole;
import com.guxo.crmbackend.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
@AllArgsConstructor
@RequestMapping("/token/")
public class TokenController {

    // Autowired
    private final TokenService tokenService;



    // GET /token/refresh/ -> { "access_token" : accessToken, "refresh_token": refreshToken } -- creates new AccessToken and RefreshToken
    @GetMapping("/refresh/")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION); // get Authorization header

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) { // Authorization token starts with Bearer

            String refreshToken = authorizationHeader.substring("Bearer ".length()); // get string after "Bearer ".length chars

            String issuer = request.getRequestURL().toString(); // gets request URL as issuer

            String newAccessToken = tokenService.getNewAccessToken(refreshToken, issuer); // creates new access token
            String newRefreshToken = tokenService.getNewRefreshToken(refreshToken, issuer); // creates new refresh token

            Map<String,String> tokens = new HashMap<>(); // map to return tokens as JSON
            tokens.put("access_token", newAccessToken);
            tokens.put("refresh_token", newRefreshToken);


            response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);

            new ObjectMapper().writeValue(response.getOutputStream(), tokens); // return tokens as JSON

        } else {
            throw new IllegalStateException("Invalid Refresh Token");
        }

    }

}
