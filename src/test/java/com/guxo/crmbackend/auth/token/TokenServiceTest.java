package com.guxo.crmbackend.auth.token;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.guxo.crmbackend.appuser.AppUser;
import com.guxo.crmbackend.appuser.AppUserRole;
import com.guxo.crmbackend.appuser.AppUserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TokenService.class, String.class})
@ExtendWith(SpringExtension.class)
class TokenServiceTest {
    @MockBean
    private AppUserService appUserService;

    @Autowired
    private TokenService tokenService;

    /**
     * Method under test: {@link TokenService#getNewAccessToken(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetNewAccessToken() {
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
        //       at com.guxo.crmbackend.auth.token.TokenService.getNewAccessToken(TokenService.java:46)
        //   In order to prevent getNewAccessToken(String, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getNewAccessToken(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");
        when(appUserService.getAppUserByUsername((String) any())).thenReturn(appUser);
        tokenService.getNewAccessToken("ABC123", "Issuer");
    }

    /**
     * Method under test: {@link TokenService#getNewRefreshToken(String, String)}
     */
    @Test
    void testGetNewRefreshToken() {
        assertThrows(IllegalStateException.class, () -> tokenService.getNewRefreshToken("ABC123", "Issuer"));
    }

    /**
     * Method under test: {@link TokenService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");
        when(appUserService.getAppUserByUsername((String) any())).thenReturn(appUser);
        UserDetails actualLoadUserByUsernameResult = tokenService.loadUserByUsername("janedoe");
        assertEquals(1, actualLoadUserByUsernameResult.getAuthorities().size());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(appUserService).getAppUserByUsername((String) any());
    }

    /**
     * Method under test: {@link TokenService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        AppUser appUser = mock(AppUser.class);
        when(appUser.getPassword()).thenThrow(new UsernameNotFoundException("Msg"));
        when(appUser.getUsername()).thenThrow(new UsernameNotFoundException("Msg"));
        when(appUser.getRole()).thenReturn(AppUserRole.USER);
        doNothing().when(appUser).setEmail((String) any());
        doNothing().when(appUser).setId((Long) any());
        doNothing().when(appUser).setName((String) any());
        doNothing().when(appUser).setPassword((String) any());
        doNothing().when(appUser).setRole((AppUserRole) any());
        doNothing().when(appUser).setUsername((String) any());
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");
        when(appUserService.getAppUserByUsername((String) any())).thenReturn(appUser);
        assertThrows(UsernameNotFoundException.class, () -> tokenService.loadUserByUsername("janedoe"));
        verify(appUserService).getAppUserByUsername((String) any());
        verify(appUser).getRole();
        verify(appUser).getUsername();
        verify(appUser).setEmail((String) any());
        verify(appUser).setId((Long) any());
        verify(appUser).setName((String) any());
        verify(appUser).setPassword((String) any());
        verify(appUser).setRole((AppUserRole) any());
        verify(appUser).setUsername((String) any());
    }

    /**
     * Method under test: {@link TokenService#loadUserByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Cannot pass null or empty values to constructor
        //       at org.springframework.util.Assert.isTrue(Assert.java:121)
        //       at org.springframework.security.core.userdetails.User.<init>(User.java:110)
        //       at org.springframework.security.core.userdetails.User.<init>(User.java:87)
        //       at com.guxo.crmbackend.auth.token.TokenService.loadUserByUsername(TokenService.java:94)
        //   In order to prevent loadUserByUsername(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadUserByUsername(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AppUser appUser = mock(AppUser.class);
        when(appUser.getPassword()).thenReturn("iloveyou");
        when(appUser.getUsername()).thenReturn("");
        when(appUser.getRole()).thenReturn(AppUserRole.USER);
        doNothing().when(appUser).setEmail((String) any());
        doNothing().when(appUser).setId((Long) any());
        doNothing().when(appUser).setName((String) any());
        doNothing().when(appUser).setPassword((String) any());
        doNothing().when(appUser).setRole((AppUserRole) any());
        doNothing().when(appUser).setUsername((String) any());
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");
        when(appUserService.getAppUserByUsername((String) any())).thenReturn(appUser);
        tokenService.loadUserByUsername("janedoe");
    }
}

