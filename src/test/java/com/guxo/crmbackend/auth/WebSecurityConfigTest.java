package com.guxo.crmbackend.auth;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.accept.ContentNegotiationStrategy;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {WebSecurityConfig.class, String.class, BCryptPasswordEncoder.class,
        AuthenticationConfiguration.class})
@ExtendWith(SpringExtension.class)
class WebSecurityConfigTest {
    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private AuthenticationTrustResolver authenticationTrustResolver;

    @MockBean
    private ContentNegotiationStrategy contentNegotiationStrategy;

    @Autowired
    private ObjectPostProcessor<Object> objectPostProcessor;

    @MockBean
    private UserDetailsService userDetailsService;

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    /**
     * Method under test: {@link WebSecurityConfig#configure(AuthenticationManagerBuilder)}
     */
    @Test
    void testConfigure() throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
        webSecurityConfig.configure(authenticationManagerBuilder);
        assertTrue(((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                .get(0)).getUserCache() instanceof NullUserCache);
        assertTrue(((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                .get(0)).isHideUserNotFoundExceptions());
        assertFalse(
                ((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                        .get(0)).isForcePrincipalAsString());
    }

    /**
     * Method under test: {@link WebSecurityConfig#configure(AuthenticationManagerBuilder)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure2() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder.userDetailsService(org.springframework.security.core.userdetails.UserDetailsService)" because "auth" is null
        //       at com.guxo.crmbackend.auth.WebSecurityConfig.configure(WebSecurityConfig.java:53)
        //   In order to prevent configure(AuthenticationManagerBuilder)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   configure(AuthenticationManagerBuilder).
        //   See https://diff.blue/R013 to resolve this issue.

        webSecurityConfig.configure((AuthenticationManagerBuilder) null);
    }

    /**
     * Method under test: {@link WebSecurityConfig#configure(HttpSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure3() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.context.ApplicationContext.getBeanNamesForType(java.lang.Class)" because "context" is null
        //       at org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.<init>(ExpressionUrlAuthorizationConfigurer.java:109)
        //       at org.springframework.security.config.annotation.web.builders.HttpSecurity.authorizeRequests(HttpSecurity.java:1183)
        //       at com.guxo.crmbackend.auth.WebSecurityConfig.configure(WebSecurityConfig.java:82)
        //   In order to prevent configure(HttpSecurity)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   configure(HttpSecurity).
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationManagerBuilder authenticationBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
        webSecurityConfig.configure(new HttpSecurity(objectPostProcessor, authenticationBuilder, new HashMap<>()));
    }

    /**
     * Method under test: {@link WebSecurityConfig#configure(HttpSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure4() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.config.annotation.web.builders.HttpSecurity.csrf()" because "http" is null
        //       at com.guxo.crmbackend.auth.WebSecurityConfig.configure(WebSecurityConfig.java:65)
        //   In order to prevent configure(HttpSecurity)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   configure(HttpSecurity).
        //   See https://diff.blue/R013 to resolve this issue.

        webSecurityConfig.configure((HttpSecurity) null);
    }

    /**
     * Method under test: {@link WebSecurityConfig#authenticationManagerBean()}
     */
    @Test
    void testAuthenticationManagerBean() throws Exception {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by authenticationManagerBean()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        webSecurityConfig.authenticationManagerBean();
    }
}

