package com.guxo.crmbackend.appuser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class AppUserTest {
    /**
     * Method under test: {@link AppUser#AppUser(String, String, String, String, AppUserRole)}
     */
    @Test
    void testConstructor() {
        AppUser actualAppUser = new AppUser("Name", "jane.doe@example.org", "janedoe", "iloveyou", AppUserRole.USER);

        assertEquals("jane.doe@example.org", actualAppUser.getEmail());
        assertEquals("janedoe", actualAppUser.getUsername());
        assertEquals(AppUserRole.USER, actualAppUser.getRole());
        assertEquals("iloveyou", actualAppUser.getPassword());
        assertEquals("Name", actualAppUser.getName());
        assertNull(actualAppUser.getId());
    }

    /**
     * Method under test: {@link AppUser#AppUser(String, String, String, String, AppUserRole)}
     */
    @Test
    void testConstructor2() {
        AppUser actualAppUser = new AppUser("Name", "jane.doe@example.org", "janedoe", "iloveyou", AppUserRole.USER);

        assertEquals("jane.doe@example.org", actualAppUser.getEmail());
        assertEquals("janedoe", actualAppUser.getUsername());
        assertEquals(AppUserRole.USER, actualAppUser.getRole());
        assertEquals("iloveyou", actualAppUser.getPassword());
        assertEquals("Name", actualAppUser.getName());
        assertNull(actualAppUser.getId());
    }
}

