package com.guxo.crmbackend.appuser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AppUserService.class})
@ExtendWith(SpringExtension.class)
class AppUserServiceTest {
    @MockBean
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUserService appUserService;

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private PasswordEncoder passwordEncoder;

    /**
     * Method under test: {@link AppUserService#getAppUsers()}
     */
    @Test
    void testGetAppUsers() {
        ArrayList<AppUser> appUserList = new ArrayList<>();
        when(appUserRepository.findAll()).thenReturn(appUserList);
        List<AppUser> actualAppUsers = appUserService.getAppUsers();
        assertSame(appUserList, actualAppUsers);
        assertTrue(actualAppUsers.isEmpty());
        verify(appUserRepository).findAll();
    }

    /**
     * Method under test: {@link AppUserService#getAppUsers()}
     */
    @Test
    void testGetAppUsers2() {
        when(appUserRepository.findAll()).thenThrow(new IllegalStateException("foo"));
        assertThrows(IllegalStateException.class, () -> appUserService.getAppUsers());
        verify(appUserRepository).findAll();
    }

    /**
     * Method under test: {@link AppUserService#getAppUser(Long)}
     */
    @Test
    void testGetAppUser() {
        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");
        Optional<AppUser> ofResult = Optional.of(appUser);
        when(appUserRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(appUser, appUserService.getAppUser(123L));
        verify(appUserRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link AppUserService#getAppUser(Long)}
     */
    @Test
    void testGetAppUser2() {
        when(appUserRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertNull(appUserService.getAppUser(123L));
        verify(appUserRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link AppUserService#getAppUser(Long)}
     */
    @Test
    void testGetAppUser3() {
        when(appUserRepository.findById((Long) any())).thenThrow(new IllegalStateException("foo"));
        assertThrows(IllegalStateException.class, () -> appUserService.getAppUser(123L));
        verify(appUserRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link AppUserService#getAppUserByUsername(String)}
     */
    @Test
    void testGetAppUserByUsername() {
        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");
        Optional<AppUser> ofResult = Optional.of(appUser);
        when(appUserRepository.findByUsername((String) any())).thenReturn(ofResult);
        assertSame(appUser, appUserService.getAppUserByUsername("janedoe"));
        verify(appUserRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link AppUserService#getAppUserByUsername(String)}
     */
    @Test
    void testGetAppUserByUsername2() {
        when(appUserRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        assertNull(appUserService.getAppUserByUsername("janedoe"));
        verify(appUserRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link AppUserService#getAppUserByUsername(String)}
     */
    @Test
    void testGetAppUserByUsername3() {
        when(appUserRepository.findByUsername((String) any())).thenThrow(new IllegalStateException("foo"));
        assertThrows(IllegalStateException.class, () -> appUserService.getAppUserByUsername("janedoe"));
        verify(appUserRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link AppUserService#addNewAppUser(AppUser)}
     */
    @Test
    void testAddNewAppUser() {
        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");

        AppUser appUser1 = new AppUser();
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setId(123L);
        appUser1.setName("Name");
        appUser1.setPassword("iloveyou");
        appUser1.setRole(AppUserRole.USER);
        appUser1.setUsername("janedoe");
        Optional<AppUser> ofResult = Optional.of(appUser1);
        when(appUserRepository.existsById((Long) any())).thenReturn(true);
        when(appUserRepository.save((AppUser) any())).thenReturn(appUser);
        when(appUserRepository.findByUsername((String) any())).thenReturn(ofResult);

        AppUser appUser2 = new AppUser();
        appUser2.setEmail("jane.doe@example.org");
        appUser2.setId(123L);
        appUser2.setName("Name");
        appUser2.setPassword("iloveyou");
        appUser2.setRole(AppUserRole.USER);
        appUser2.setUsername("janedoe");
        assertThrows(IllegalStateException.class, () -> appUserService.addNewAppUser(appUser2));
        verify(appUserRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link AppUserService#addNewAppUser(AppUser)}
     */
    @Test
    void testAddNewAppUser2() {
        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");

        AppUser appUser1 = new AppUser();
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setId(123L);
        appUser1.setName("Name");
        appUser1.setPassword("iloveyou");
        appUser1.setRole(AppUserRole.USER);
        appUser1.setUsername("janedoe");
        Optional<AppUser> ofResult = Optional.of(appUser1);
        when(appUserRepository.existsById((Long) any())).thenReturn(false);
        when(appUserRepository.save((AppUser) any())).thenReturn(appUser);
        when(appUserRepository.findByUsername((String) any())).thenReturn(ofResult);

        AppUser appUser2 = new AppUser();
        appUser2.setEmail("jane.doe@example.org");
        appUser2.setId(123L);
        appUser2.setName("Name");
        appUser2.setPassword("iloveyou");
        appUser2.setRole(AppUserRole.USER);
        appUser2.setUsername("janedoe");
        assertThrows(IllegalStateException.class, () -> appUserService.addNewAppUser(appUser2));
        verify(appUserRepository).existsById((Long) any());
        verify(appUserRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link AppUserService#addNewAppUser(AppUser)}
     */
    @Test
    void testAddNewAppUser3() {
        when(appUserRepository.existsById((Long) any())).thenThrow(new IllegalStateException("foo"));
        when(appUserRepository.save((AppUser) any())).thenThrow(new IllegalStateException("foo"));
        when(appUserRepository.findByUsername((String) any())).thenThrow(new IllegalStateException("foo"));

        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");
        assertThrows(IllegalStateException.class, () -> appUserService.addNewAppUser(appUser));
        verify(appUserRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link AppUserService#getExistingRoles()}
     */
    @Test
    void testGetExistingRoles() {
        List<String> actualExistingRoles = appUserService.getExistingRoles();
        assertEquals(2, actualExistingRoles.size());
        assertEquals("USER", actualExistingRoles.get(0));
        assertEquals("ADMIN", actualExistingRoles.get(1));
    }

    /**
     * Method under test: {@link AppUserService#deleteAppUser(Long)}
     */
    @Test
    void testDeleteAppUser() {
        doNothing().when(appUserRepository).deleteById((Long) any());
        when(appUserRepository.existsById((Long) any())).thenReturn(true);
        appUserService.deleteAppUser(123L);
        verify(appUserRepository).existsById((Long) any());
        verify(appUserRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link AppUserService#deleteAppUser(Long)}
     */
    @Test
    void testDeleteAppUser2() {
        doThrow(new IllegalStateException("foo")).when(appUserRepository).deleteById((Long) any());
        when(appUserRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(IllegalStateException.class, () -> appUserService.deleteAppUser(123L));
        verify(appUserRepository).existsById((Long) any());
        verify(appUserRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link AppUserService#deleteAppUser(Long)}
     */
    @Test
    void testDeleteAppUser3() {
        doNothing().when(appUserRepository).deleteById((Long) any());
        when(appUserRepository.existsById((Long) any())).thenReturn(false);
        assertThrows(IllegalStateException.class, () -> appUserService.deleteAppUser(123L));
        verify(appUserRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link AppUserService#updateAppUser(Long, AppUser)}
     */
    @Test
    void testUpdateAppUser() {
        doNothing().when(modelMapper).map((Object) any(), (Object) any());

        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");
        Optional<AppUser> ofResult = Optional.of(appUser);

        AppUser appUser1 = new AppUser();
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setId(123L);
        appUser1.setName("Name");
        appUser1.setPassword("iloveyou");
        appUser1.setRole(AppUserRole.USER);
        appUser1.setUsername("janedoe");
        when(appUserRepository.save((AppUser) any())).thenReturn(appUser1);
        when(appUserRepository.findById((Long) any())).thenReturn(ofResult);

        AppUser appUser2 = new AppUser();
        appUser2.setEmail("jane.doe@example.org");
        appUser2.setId(123L);
        appUser2.setName("Name");
        appUser2.setPassword("iloveyou");
        appUser2.setRole(AppUserRole.USER);
        appUser2.setUsername("janedoe");
        appUserService.updateAppUser(123L, appUser2);
        verify(modelMapper).map((Object) any(), (Object) any());
        verify(appUserRepository).save((AppUser) any());
        verify(appUserRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link AppUserService#updateAppUser(Long, AppUser)}
     */
    @Test
    void testUpdateAppUser2() {
        doNothing().when(modelMapper).map((Object) any(), (Object) any());

        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");
        Optional<AppUser> ofResult = Optional.of(appUser);
        when(appUserRepository.save((AppUser) any())).thenThrow(new IllegalStateException("foo"));
        when(appUserRepository.findById((Long) any())).thenReturn(ofResult);

        AppUser appUser1 = new AppUser();
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setId(123L);
        appUser1.setName("Name");
        appUser1.setPassword("iloveyou");
        appUser1.setRole(AppUserRole.USER);
        appUser1.setUsername("janedoe");
        assertThrows(IllegalStateException.class, () -> appUserService.updateAppUser(123L, appUser1));
        verify(modelMapper).map((Object) any(), (Object) any());
        verify(appUserRepository).save((AppUser) any());
        verify(appUserRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link AppUserService#updateAppUser(Long, AppUser)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateAppUser3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.isEmpty()" because "appUser" is null
        //       at com.guxo.crmbackend.appuser.AppUserService.getAppUser(AppUserService.java:39)
        //       at com.guxo.crmbackend.appuser.AppUserService.updateAppUser(AppUserService.java:100)
        //   In order to prevent updateAppUser(Long, AppUser)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateAppUser(Long, AppUser).
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(modelMapper).map((Object) any(), (Object) any());

        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");
        when(appUserRepository.save((AppUser) any())).thenReturn(appUser);
        when(appUserRepository.findById((Long) any())).thenReturn(null);

        AppUser appUser1 = new AppUser();
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setId(123L);
        appUser1.setName("Name");
        appUser1.setPassword("iloveyou");
        appUser1.setRole(AppUserRole.USER);
        appUser1.setUsername("janedoe");
        appUserService.updateAppUser(123L, appUser1);
    }

    /**
     * Method under test: {@link AppUserService#updateAppUser(Long, AppUser)}
     */
    @Test
    void testUpdateAppUser4() {
        doNothing().when(modelMapper).map((Object) any(), (Object) any());

        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");
        when(appUserRepository.save((AppUser) any())).thenReturn(appUser);
        when(appUserRepository.findById((Long) any())).thenReturn(Optional.empty());

        AppUser appUser1 = new AppUser();
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setId(123L);
        appUser1.setName("Name");
        appUser1.setPassword("iloveyou");
        appUser1.setRole(AppUserRole.USER);
        appUser1.setUsername("janedoe");
        assertThrows(IllegalStateException.class, () -> appUserService.updateAppUser(123L, appUser1));
        verify(appUserRepository).findById((Long) any());
    }
}

