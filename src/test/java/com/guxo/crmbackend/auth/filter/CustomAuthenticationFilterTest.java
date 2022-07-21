package com.guxo.crmbackend.auth.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.access.intercept.RunAsImplAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.jaas.DefaultJaasAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.NullRememberMeServices;

class CustomAuthenticationFilterTest {
    /**
     * Method under test: {@link CustomAuthenticationFilter#CustomAuthenticationFilter(AuthenticationManager)}
     */
    @Test
    void testConstructor() {
        ArrayList<AuthenticationProvider> authenticationProviderList = new ArrayList<>();
        authenticationProviderList.add(new RunAsImplAuthenticationProvider());
        CustomAuthenticationFilter actualCustomAuthenticationFilter = new CustomAuthenticationFilter(
                new ProviderManager(authenticationProviderList));
        assertEquals("username", actualCustomAuthenticationFilter.getUsernameParameter());
        assertTrue(actualCustomAuthenticationFilter.getRememberMeServices() instanceof NullRememberMeServices);
        assertEquals("password", actualCustomAuthenticationFilter.getPasswordParameter());
    }

    /**
     * Method under test: {@link CustomAuthenticationFilter#setJwtSecret(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSetJwtSecret() {
        // TODO: Complete this test.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of CustomAuthenticationFilter.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        // Arrange
        // TODO: Populate arranged inputs
        CustomAuthenticationFilter customAuthenticationFilter = null;
        String jwtSecret = "";

        // Act
        customAuthenticationFilter.setJwtSecret(jwtSecret);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link CustomAuthenticationFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAttemptAuthentication() throws AuthenticationException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.security.authentication.ProviderNotFoundException: No AuthenticationProvider found for org.springframework.security.authentication.UsernamePasswordAuthenticationToken
        //       at org.springframework.security.authentication.ProviderManager.authenticate(ProviderManager.java:234)
        //       at com.guxo.crmbackend.auth.filter.CustomAuthenticationFilter.attemptAuthentication(CustomAuthenticationFilter.java:59)
        //   In order to prevent attemptAuthentication(HttpServletRequest, HttpServletResponse)
        //   from throwing ProviderNotFoundException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   attemptAuthentication(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuthenticationProvider> authenticationProviderList = new ArrayList<>();
        authenticationProviderList.add(new RunAsImplAuthenticationProvider());
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(
                new ProviderManager(authenticationProviderList));
        MockHttpServletRequest request = new MockHttpServletRequest();
        customAuthenticationFilter.attemptAuthentication(request, new Response());
    }

    /**
     * Method under test: {@link CustomAuthenticationFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAttemptAuthentication2() throws AuthenticationException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.security.authentication.AuthenticationServiceException: No LoginModules configured for SPRINGSECURITY
        //       at org.springframework.security.authentication.jaas.DefaultLoginExceptionResolver.resolveException(DefaultLoginExceptionResolver.java:34)
        //       at org.springframework.security.authentication.jaas.AbstractJaasAuthenticationProvider.authenticate(AbstractJaasAuthenticationProvider.java:189)
        //       at org.springframework.security.authentication.ProviderManager.authenticate(ProviderManager.java:182)
        //       at com.guxo.crmbackend.auth.filter.CustomAuthenticationFilter.attemptAuthentication(CustomAuthenticationFilter.java:59)
        //   In order to prevent attemptAuthentication(HttpServletRequest, HttpServletResponse)
        //   from throwing AuthenticationServiceException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   attemptAuthentication(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuthenticationProvider> authenticationProviderList = new ArrayList<>();
        authenticationProviderList.add(new DefaultJaasAuthenticationProvider());
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(
                new ProviderManager(authenticationProviderList));
        MockHttpServletRequest request = new MockHttpServletRequest();
        customAuthenticationFilter.attemptAuthentication(request, new Response());
    }

    /**
     * Method under test: {@link CustomAuthenticationFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAttemptAuthentication3() throws AuthenticationException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "javax.servlet.http.HttpServletRequest.getParameter(String)" because "request" is null
        //       at com.guxo.crmbackend.auth.filter.CustomAuthenticationFilter.attemptAuthentication(CustomAuthenticationFilter.java:54)
        //   In order to prevent attemptAuthentication(HttpServletRequest, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   attemptAuthentication(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuthenticationProvider> authenticationProviderList = new ArrayList<>();
        authenticationProviderList.add(new RunAsImplAuthenticationProvider());
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(
                new ProviderManager(authenticationProviderList));
        customAuthenticationFilter.attemptAuthentication(null, new Response());
    }

    /**
     * Method under test: {@link CustomAuthenticationFilter#successfulAuthentication(HttpServletRequest, HttpServletResponse, FilterChain, Authentication)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSuccessfulAuthentication() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ClassCastException: class java.lang.String cannot be cast to class org.springframework.security.core.userdetails.User (java.lang.String is in module java.base of loader 'bootstrap'; org.springframework.security.core.userdetails.User is in unnamed module of loader com.diffblue.cover.d.f @1cd22549)
        //       at com.guxo.crmbackend.auth.filter.CustomAuthenticationFilter.successfulAuthentication(CustomAuthenticationFilter.java:65)
        //   In order to prevent successfulAuthentication(HttpServletRequest, HttpServletResponse, FilterChain, Authentication)
        //   from throwing ClassCastException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   successfulAuthentication(HttpServletRequest, HttpServletResponse, FilterChain, Authentication).
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        CustomAuthenticationFilter customAuthenticationFilter = null;
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        FilterChain chain = null;
        Authentication authResult = null;

        // Act
        customAuthenticationFilter.successfulAuthentication(request, response, chain, authResult);

        // Assert
        // TODO: Add assertions on result
    }
}

