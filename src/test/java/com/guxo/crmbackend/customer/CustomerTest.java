package com.guxo.crmbackend.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.guxo.crmbackend.appuser.AppUser;
import com.guxo.crmbackend.appuser.AppUserRole;
import com.guxo.crmbackend.files.Image;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class CustomerTest {
    /**
     * Method under test: {@link Customer#getPhotoUrl()}
     */
    @Test
    void testGetPhotoUrl() {
        assertNull((new Customer()).getPhotoUrl());
    }

    /**
     * Method under test: {@link Customer#getPhotoUrl()}
     */
    @Test
    void testGetPhotoUrl2() {
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

        AppUser appUser2 = new AppUser();
        appUser2.setEmail("jane.doe@example.org");
        appUser2.setId(123L);
        appUser2.setName("Name");
        appUser2.setPassword("iloveyou");
        appUser2.setRole(AppUserRole.USER);
        appUser2.setUsername("janedoe");

        AppUser appUser3 = new AppUser();
        appUser3.setEmail("jane.doe@example.org");
        appUser3.setId(123L);
        appUser3.setName("Name");
        appUser3.setPassword("iloveyou");
        appUser3.setRole(AppUserRole.USER);
        appUser3.setUsername("janedoe");

        Image image = new Image();
        image.setId(123L);
        image.setOwner(new Customer());
        image.setUrl("https://example.org/example");

        Customer customer = new Customer();
        customer.setCreationAppUser(appUser2);
        customer.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setLastUpdateAppUser(appUser3);
        customer.setName("Name");
        customer.setNote("Note");
        customer.setPhoto(image);
        customer.setSurname("Doe");

        Image image1 = new Image();
        image1.setId(123L);
        image1.setOwner(customer);
        image1.setUrl("https://example.org/example");

        Customer customer1 = new Customer();
        customer1.setCreationAppUser(appUser);
        customer1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setLastUpdateAppUser(appUser1);
        customer1.setName("Name");
        customer1.setNote("Note");
        customer1.setPhoto(image1);
        customer1.setSurname("Doe");
        assertEquals("https://example.org/example", customer1.getPhotoUrl());
    }

    /**
     * Method under test: {@link Customer#getCreationUser()}
     */
    @Test
    void testGetCreationUser() {
        assertNull((new Customer()).getCreationUser());
    }

    /**
     * Method under test: {@link Customer#getCreationUser()}
     */
    @Test
    void testGetCreationUser2() {
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

        AppUser appUser2 = new AppUser();
        appUser2.setEmail("jane.doe@example.org");
        appUser2.setId(123L);
        appUser2.setName("Name");
        appUser2.setPassword("iloveyou");
        appUser2.setRole(AppUserRole.USER);
        appUser2.setUsername("janedoe");

        AppUser appUser3 = new AppUser();
        appUser3.setEmail("jane.doe@example.org");
        appUser3.setId(123L);
        appUser3.setName("Name");
        appUser3.setPassword("iloveyou");
        appUser3.setRole(AppUserRole.USER);
        appUser3.setUsername("janedoe");

        Image image = new Image();
        image.setId(123L);
        image.setOwner(new Customer());
        image.setUrl("https://example.org/example");

        Customer customer = new Customer();
        customer.setCreationAppUser(appUser2);
        customer.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setLastUpdateAppUser(appUser3);
        customer.setName("Name");
        customer.setNote("Note");
        customer.setPhoto(image);
        customer.setSurname("Doe");

        Image image1 = new Image();
        image1.setId(123L);
        image1.setOwner(customer);
        image1.setUrl("https://example.org/example");

        Customer customer1 = new Customer();
        customer1.setCreationAppUser(appUser);
        customer1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setLastUpdateAppUser(appUser1);
        customer1.setName("Name");
        customer1.setNote("Note");
        customer1.setPhoto(image1);
        customer1.setSurname("Doe");
        assertEquals("janedoe", customer1.getCreationUser());
    }

    /**
     * Method under test: {@link Customer#getLastUpdateUser()}
     */
    @Test
    void testGetLastUpdateUser() {
        assertNull((new Customer()).getLastUpdateUser());
    }

    /**
     * Method under test: {@link Customer#getLastUpdateUser()}
     */
    @Test
    void testGetLastUpdateUser2() {
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

        AppUser appUser2 = new AppUser();
        appUser2.setEmail("jane.doe@example.org");
        appUser2.setId(123L);
        appUser2.setName("Name");
        appUser2.setPassword("iloveyou");
        appUser2.setRole(AppUserRole.USER);
        appUser2.setUsername("janedoe");

        AppUser appUser3 = new AppUser();
        appUser3.setEmail("jane.doe@example.org");
        appUser3.setId(123L);
        appUser3.setName("Name");
        appUser3.setPassword("iloveyou");
        appUser3.setRole(AppUserRole.USER);
        appUser3.setUsername("janedoe");

        Image image = new Image();
        image.setId(123L);
        image.setOwner(new Customer());
        image.setUrl("https://example.org/example");

        Customer customer = new Customer();
        customer.setCreationAppUser(appUser2);
        customer.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setLastUpdateAppUser(appUser3);
        customer.setName("Name");
        customer.setNote("Note");
        customer.setPhoto(image);
        customer.setSurname("Doe");

        Image image1 = new Image();
        image1.setId(123L);
        image1.setOwner(customer);
        image1.setUrl("https://example.org/example");

        Customer customer1 = new Customer();
        customer1.setCreationAppUser(appUser);
        customer1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setLastUpdateAppUser(appUser1);
        customer1.setName("Name");
        customer1.setNote("Note");
        customer1.setPhoto(image1);
        customer1.setSurname("Doe");
        assertEquals("janedoe", customer1.getLastUpdateUser());
    }
}

