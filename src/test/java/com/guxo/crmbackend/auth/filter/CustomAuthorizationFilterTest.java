package com.guxo.crmbackend.auth.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.connector.Request;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.mock.web.DelegatingServletInputStream;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.support.StandardServletEnvironment;

class CustomAuthorizationFilterTest {
    /**
     * Method under test: {@link CustomAuthorizationFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal() throws IOException, ServletException {
        CustomAuthorizationFilter customAuthorizationFilter = new CustomAuthorizationFilter();
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        customAuthorizationFilter.doFilterInternal(mockHttpServletRequest, response, filterChain);
        verify(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        assertFalse(mockHttpServletRequest.isRequestedSessionIdFromURL());
        assertTrue(mockHttpServletRequest.isRequestedSessionIdFromCookie());
        assertFalse(mockHttpServletRequest.isAsyncSupported());
        assertFalse(mockHttpServletRequest.isAsyncStarted());
        assertTrue(mockHttpServletRequest.isActive());
        assertTrue(mockHttpServletRequest.getSession() instanceof MockHttpSession);
        assertEquals("", mockHttpServletRequest.getServletPath());
        assertEquals(80, mockHttpServletRequest.getServerPort());
        assertEquals("localhost", mockHttpServletRequest.getServerName());
        assertEquals("http", mockHttpServletRequest.getScheme());
        assertEquals("", mockHttpServletRequest.getRequestURI());
        assertEquals(80, mockHttpServletRequest.getRemotePort());
        assertEquals("localhost", mockHttpServletRequest.getRemoteHost());
        assertEquals("HTTP/1.1", mockHttpServletRequest.getProtocol());
        assertEquals("", mockHttpServletRequest.getMethod());
        assertEquals(80, mockHttpServletRequest.getLocalPort());
        assertEquals("localhost", mockHttpServletRequest.getLocalName());
        assertTrue(mockHttpServletRequest.getInputStream() instanceof DelegatingServletInputStream);
        assertEquals(DispatcherType.REQUEST, mockHttpServletRequest.getDispatcherType());
        assertEquals("", mockHttpServletRequest.getContextPath());
        assertEquals(-1L, mockHttpServletRequest.getContentLengthLong());
    }

    /**
     * Method under test: {@link CustomAuthorizationFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilterInternal2() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "javax.servlet.http.HttpServletRequest.getServletPath()" because "request" is null
        //       at com.guxo.crmbackend.auth.filter.CustomAuthorizationFilter.doFilterInternal(CustomAuthorizationFilter.java:26)
        //   In order to prevent doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        CustomAuthorizationFilter customAuthorizationFilter = new CustomAuthorizationFilter();
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        customAuthorizationFilter.doFilterInternal(null, response, filterChain);
    }

    /**
     * Method under test: {@link CustomAuthorizationFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoFilterInternal3() throws IOException, ServletException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.startsWith(String)" because "path" is null
        //       at com.guxo.crmbackend.auth.filter.CustomAuthorizationFilter.doFilterInternal(CustomAuthorizationFilter.java:30)
        //   In order to prevent doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain).
        //   See https://diff.blue/R013 to resolve this issue.

        CustomAuthorizationFilter customAuthorizationFilter = new CustomAuthorizationFilter();
        Request request = new Request(new Connector());
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        customAuthorizationFilter.doFilterInternal(request, response, filterChain);
    }

    /**
     * Method under test: {@link CustomAuthorizationFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal4() throws IOException, ServletException {
        CustomAuthorizationFilter customAuthorizationFilter = new CustomAuthorizationFilter();
        MockHttpServletRequest request = new MockHttpServletRequest();
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doThrow(new IllegalStateException("/login")).when(filterChain)
                .doFilter((ServletRequest) any(), (ServletResponse) any());
        assertThrows(IllegalStateException.class,
                () -> customAuthorizationFilter.doFilterInternal(request, response, filterChain));
        verify(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
    }

}

