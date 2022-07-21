package com.guxo.crmbackend.auth.token;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class TokenUtilityTest {
    /**
     * Method under test: {@link TokenUtility#createAccessToken(String, List, String, Date, String)}
     */
    @Test
    void testCreateAccessToken() {
        ArrayList<String> roles = new ArrayList<>();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        assertEquals(
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5lZG9lIiwicm9sZXMiOltdLCJpc3MiOiJJc3N1ZXIiLCJleHAiOjB9"
                        + ".sOE5UnxZkqbY9O2isH510s_z4ICeiuKJa8S6tZQ7pvc",
                TokenUtility.createAccessToken("janedoe", roles, "Issuer",
                        Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), "Jwt Secret"));
    }

    /**
     * Method under test: {@link TokenUtility#createAccessToken(String, List, String, Date, String)}
     */
    @Test
    void testCreateAccessToken2() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("roles");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        assertEquals(
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5lZG9lIiwicm9sZXMiOlsicm9sZXMiXSwiaXNzIjoiSXNzdWV"
                        + "yIiwiZXhwIjowfQ.6eb911Rjf1l9QIqwHxQxdHTgBGTcxHji-tlcKcNRgJ0",
                TokenUtility.createAccessToken("janedoe", stringList, "Issuer",
                        Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), "Jwt Secret"));
    }

    /**
     * Method under test: {@link TokenUtility#createAccessToken(String, List, String, Date, String)}
     */
    @Test
    void testCreateAccessToken3() {
        assertEquals(
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5lZG9lIiwicm9sZXMiOltdLCJpc3MiOiJJc3N1ZXIifQ"
                        + ".La6fA1wH6Y_69WFy-mJadwqOGaMmxD01duB_tAtd_X4",
                TokenUtility.createAccessToken("janedoe", new ArrayList<>(), "Issuer", null, "Jwt Secret"));
    }

    /**
     * Method under test: {@link TokenUtility#createAccessToken(String, List, String, Date, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAccessToken4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Empty key
        //       at javax.crypto.spec.SecretKeySpec.<init>(SecretKeySpec.java:110)
        //       at com.auth0.jwt.algorithms.CryptoHelper.createSignatureFor(CryptoHelper.java:65)
        //       at com.auth0.jwt.algorithms.HMACAlgorithm.sign(HMACAlgorithm.java:65)
        //       at com.auth0.jwt.JWTCreator.sign(JWTCreator.java:497)
        //       at com.auth0.jwt.JWTCreator.access$100(JWTCreator.java:24)
        //       at com.auth0.jwt.JWTCreator$Builder.sign(JWTCreator.java:475)
        //       at com.guxo.crmbackend.auth.token.TokenUtility.createAccessToken(TokenUtility.java:31)
        //   In order to prevent createAccessToken(String, List, String, Date, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAccessToken(String, List, String, Date, String).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<String> roles = new ArrayList<>();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        TokenUtility.createAccessToken("janedoe", roles, "Issuer",
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), "");
    }

    /**
     * Method under test: {@link TokenUtility#createRefreshToken(String, String, Date, String)}
     */
    @Test
    void testCreateRefreshToken() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        assertEquals(
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5lZG9lIiwiaXNzIjoiSXNzdWVyIiwiZXhwIjowfQ.D_dz7"
                        + "_Sn1X30gkStPWLbd-t9kZPIrNat8ZsHXfaWsQo",
                TokenUtility.createRefreshToken("janedoe", "Issuer",
                        Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), "Jwt Secret"));
    }

    /**
     * Method under test: {@link TokenUtility#createRefreshToken(String, String, Date, String)}
     */
    @Test
    void testCreateRefreshToken2() {
        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getTime()).thenReturn(10L);
        assertEquals(
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5lZG9lIiwiaXNzIjoiSXNzdWVyIiwiZXhwIjowfQ.D_dz7"
                        + "_Sn1X30gkStPWLbd-t9kZPIrNat8ZsHXfaWsQo",
                TokenUtility.createRefreshToken("janedoe", "Issuer", timestamp, "Jwt Secret"));
        verify(timestamp).getTime();
    }

    /**
     * Method under test: {@link TokenUtility#createRefreshToken(String, String, Date, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateRefreshToken3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Empty key
        //       at javax.crypto.spec.SecretKeySpec.<init>(SecretKeySpec.java:110)
        //       at com.auth0.jwt.algorithms.CryptoHelper.createSignatureFor(CryptoHelper.java:65)
        //       at com.auth0.jwt.algorithms.HMACAlgorithm.sign(HMACAlgorithm.java:65)
        //       at com.auth0.jwt.JWTCreator.sign(JWTCreator.java:497)
        //       at com.auth0.jwt.JWTCreator.access$100(JWTCreator.java:24)
        //       at com.auth0.jwt.JWTCreator$Builder.sign(JWTCreator.java:475)
        //       at com.guxo.crmbackend.auth.token.TokenUtility.createRefreshToken(TokenUtility.java:48)
        //   In order to prevent createRefreshToken(String, String, Date, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createRefreshToken(String, String, Date, String).
        //   See https://diff.blue/R013 to resolve this issue.

        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getTime()).thenReturn(10L);
        TokenUtility.createRefreshToken("janedoe", "Issuer", timestamp, "");
    }

    /**
     * Method under test: {@link TokenUtility#createRefreshToken(String, String, Date, String)}
     */
    @Test
    void testCreateRefreshToken4() {
        assertEquals("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5lZG9lIiwiaXNzIjoiSXNzdWVyIn0.3_B-K-RohbcMNF4q2U5"
                + "VM0lgZPkBtyBDdyUG37f_TLo", TokenUtility.createRefreshToken("janedoe", "Issuer", null, "Jwt Secret"));
    }

    /**
     * Method under test: {@link TokenUtility#getUsernameFromToken(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUsernameFromToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.auth0.jwt.exceptions.JWTDecodeException: The token was expected to have 3 parts, but got 1.
        //       at com.auth0.jwt.TokenUtils.splitToken(TokenUtils.java:21)
        //       at com.auth0.jwt.JWTDecoder.<init>(JWTDecoder.java:36)
        //       at com.auth0.jwt.JWTVerifier.verify(JWTVerifier.java:282)
        //       at com.guxo.crmbackend.auth.token.TokenUtility.decodeJWT(TokenUtility.java:97)
        //       at com.guxo.crmbackend.auth.token.TokenUtility.getUsernameFromToken(TokenUtility.java:58)
        //   In order to prevent getUsernameFromToken(String, String)
        //   from throwing JWTDecodeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getUsernameFromToken(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        TokenUtility.getUsernameFromToken("ABC123", "Jwt Secret");
    }

    /**
     * Method under test: {@link TokenUtility#getUsernameFromToken(String, String)}
     */
    @Test
    void testGetUsernameFromToken2() {
        assertEquals("", TokenUtility.getUsernameFromToken("ABC123", ""));
    }

    /**
     * Method under test: {@link TokenUtility#getRolesFromToken(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetRolesFromToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.auth0.jwt.exceptions.JWTDecodeException: The token was expected to have 3 parts, but got 1.
        //       at com.auth0.jwt.TokenUtils.splitToken(TokenUtils.java:21)
        //       at com.auth0.jwt.JWTDecoder.<init>(JWTDecoder.java:36)
        //       at com.auth0.jwt.JWTVerifier.verify(JWTVerifier.java:282)
        //       at com.guxo.crmbackend.auth.token.TokenUtility.decodeJWT(TokenUtility.java:97)
        //       at com.guxo.crmbackend.auth.token.TokenUtility.getRolesFromToken(TokenUtility.java:69)
        //   In order to prevent getRolesFromToken(String, String)
        //   from throwing JWTDecodeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getRolesFromToken(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        TokenUtility.getRolesFromToken("ABC123", "Jwt Secret");
    }

    /**
     * Method under test: {@link TokenUtility#getRolesFromToken(String, String)}
     */
    @Test
    void testGetRolesFromToken2() {
        assertEquals(0, TokenUtility.getRolesFromToken("ABC123", "").length);
    }

    /**
     * Method under test: {@link TokenUtility#isRefreshToken(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsRefreshToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.auth0.jwt.exceptions.JWTDecodeException: The token was expected to have 3 parts, but got 1.
        //       at com.auth0.jwt.TokenUtils.splitToken(TokenUtils.java:21)
        //       at com.auth0.jwt.JWTDecoder.<init>(JWTDecoder.java:36)
        //       at com.auth0.jwt.JWTVerifier.verify(JWTVerifier.java:282)
        //       at com.guxo.crmbackend.auth.token.TokenUtility.decodeJWT(TokenUtility.java:97)
        //       at com.guxo.crmbackend.auth.token.TokenUtility.isRefreshToken(TokenUtility.java:80)
        //   In order to prevent isRefreshToken(String, String)
        //   from throwing JWTDecodeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   isRefreshToken(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        TokenUtility.isRefreshToken("ABC123", "Jwt Secret");
    }

    /**
     * Method under test: {@link TokenUtility#isRefreshToken(String, String)}
     */
    @Test
    void testIsRefreshToken2() {
        assertFalse(TokenUtility.isRefreshToken("ABC123", ""));
    }
}

