package com.guxo.crmbackend.auth.token;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
public class TokenUtility {

    // The point of this class is to avoid typing the same token creation code in many places
    // so that if any changes must be done, they can all be centered here


    // given all the information below, creates a JWT access token
    public static String createAccessToken(String username, List<String> roles, String issuer, Date accessExpirationDate, String jwtSecret){

        Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes()); // Token encryption algorithm
        String accessToken = JWT.create()
                .withSubject(username) // JWT content
                .withClaim("roles", roles) // user role(s)
                .withIssuer(issuer)  // URL from where the token was generated
                .withExpiresAt(accessExpirationDate) // token expiration date
                .sign(algorithm);

        return accessToken;

    }



    // given all the information below, creates a JWT refresh token
    public static String createRefreshToken(String username, String issuer, Date refreshExpirationDate, String jwtSecret){

        Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes()); // Token encryption algorithm

        String refreshToken = JWT.create()
                .withSubject(username) // JWT content
                .withIssuer(issuer)  // URL from where the token was generated
                .withExpiresAt(refreshExpirationDate) // token expiration date
                .sign(algorithm);

        return refreshToken;
    }

    public static String getUsernameFromToken(String token, String jwtSecret) {
        if(jwtSecret.isEmpty()){
            return ""; // leave if jwt is empty
        }

        String username = decodeJWT(token, jwtSecret).getSubject(); // get username

        return username;
    }


    public static String[] getRolesFromToken(String token, String jwtSecret) {
        if(jwtSecret.isEmpty()){
            return new String[] {}; // leave if jwt is empty
        }

        String[] roles = decodeJWT(token, jwtSecret).getClaim("roles").asArray(String.class); // get username

        return roles;
    }


    public static boolean isRefreshToken(String token, String jwtSecret){
        if(jwtSecret.isEmpty()){
            return false; // leave if jwt is empty
        }

        String[] roles = decodeJWT(token, jwtSecret).getClaim("roles").asArray(String.class); // get username

        if(roles == null) {
            return true;
        } else {
            return false;
        }

    }


    // Decode JWT for internal use (avoid writing decode code multiple times)
    private static DecodedJWT decodeJWT(String token, String jwtSecret) {
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes()); // Use secret key got from environment

        JWTVerifier verifier = JWT.require(algorithm).build(); // Create verifier from set algorithm

        DecodedJWT decodedJWT = verifier.verify(token); // verify token integrity

        return decodedJWT;
    }

}
