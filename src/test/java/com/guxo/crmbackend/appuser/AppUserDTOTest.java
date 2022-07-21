package com.guxo.crmbackend.appuser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AppUserDTOTest {
    /**
     * Method under test: {@link AppUserDTO#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new AppUserDTO()).canEqual("Other"));
    }

    /**
     * Method under test: {@link AppUserDTO#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        AppUserDTO appUserDTO = new AppUserDTO();

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertTrue(appUserDTO.canEqual(appUserDTO1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link AppUserDTO}
     *   <li>{@link AppUserDTO#setEmail(String)}
     *   <li>{@link AppUserDTO#setId(Long)}
     *   <li>{@link AppUserDTO#setName(String)}
     *   <li>{@link AppUserDTO#setPassword(String)}
     *   <li>{@link AppUserDTO#setRole(AppUserRole)}
     *   <li>{@link AppUserDTO#setUsername(String)}
     *   <li>{@link AppUserDTO#toString()}
     *   <li>{@link AppUserDTO#getEmail()}
     *   <li>{@link AppUserDTO#getId()}
     *   <li>{@link AppUserDTO#getName()}
     *   <li>{@link AppUserDTO#getPassword()}
     *   <li>{@link AppUserDTO#getRole()}
     *   <li>{@link AppUserDTO#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AppUserDTO actualAppUserDTO = new AppUserDTO();
        actualAppUserDTO.setEmail("jane.doe@example.org");
        actualAppUserDTO.setId(123L);
        actualAppUserDTO.setName("Name");
        actualAppUserDTO.setPassword("iloveyou");
        actualAppUserDTO.setRole(AppUserRole.USER);
        actualAppUserDTO.setUsername("janedoe");
        String actualToStringResult = actualAppUserDTO.toString();
        assertEquals("jane.doe@example.org", actualAppUserDTO.getEmail());
        assertEquals(123L, actualAppUserDTO.getId().longValue());
        assertEquals("Name", actualAppUserDTO.getName());
        assertEquals("iloveyou", actualAppUserDTO.getPassword());
        assertEquals(AppUserRole.USER, actualAppUserDTO.getRole());
        assertEquals("janedoe", actualAppUserDTO.getUsername());
        assertEquals("AppUserDTO(id=123, name=Name, email=jane.doe@example.org, username=janedoe, password=iloveyou,"
                + " role=USER)", actualToStringResult);
    }

    /**
     * Method under test: {@link AppUserDTO#equals(Object)}
     */
    @Test
    void testEquals() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");
        assertNotEquals(appUserDTO, null);
    }

    /**
     * Method under test: {@link AppUserDTO#equals(Object)}
     */
    @Test
    void testEquals2() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");
        assertNotEquals(appUserDTO, "Different type to AppUserDTO");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AppUserDTO#equals(Object)}
     *   <li>{@link AppUserDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");
        assertEquals(appUserDTO, appUserDTO);
        int expectedHashCodeResult = appUserDTO.hashCode();
        assertEquals(expectedHashCodeResult, appUserDTO.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AppUserDTO#equals(Object)}
     *   <li>{@link AppUserDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertEquals(appUserDTO, appUserDTO1);
        int expectedHashCodeResult = appUserDTO.hashCode();
        assertEquals(expectedHashCodeResult, appUserDTO1.hashCode());
    }

    /**
     * Method under test: {@link AppUserDTO#equals(Object)}
     */
    @Test
    void testEquals5() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("Name");
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertNotEquals(appUserDTO, appUserDTO1);
    }

    /**
     * Method under test: {@link AppUserDTO#equals(Object)}
     */
    @Test
    void testEquals6() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail(null);
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertNotEquals(appUserDTO, appUserDTO1);
    }

    /**
     * Method under test: {@link AppUserDTO#equals(Object)}
     */
    @Test
    void testEquals7() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(1L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertNotEquals(appUserDTO, appUserDTO1);
    }

    /**
     * Method under test: {@link AppUserDTO#equals(Object)}
     */
    @Test
    void testEquals8() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(null);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertNotEquals(appUserDTO, appUserDTO1);
    }

    /**
     * Method under test: {@link AppUserDTO#equals(Object)}
     */
    @Test
    void testEquals9() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName("jane.doe@example.org");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertNotEquals(appUserDTO, appUserDTO1);
    }

    /**
     * Method under test: {@link AppUserDTO#equals(Object)}
     */
    @Test
    void testEquals10() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName(null);
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertNotEquals(appUserDTO, appUserDTO1);
    }

    /**
     * Method under test: {@link AppUserDTO#equals(Object)}
     */
    @Test
    void testEquals11() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("Name");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertNotEquals(appUserDTO, appUserDTO1);
    }

    /**
     * Method under test: {@link AppUserDTO#equals(Object)}
     */
    @Test
    void testEquals12() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword(null);
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertNotEquals(appUserDTO, appUserDTO1);
    }

    /**
     * Method under test: {@link AppUserDTO#equals(Object)}
     */
    @Test
    void testEquals13() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(null);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertNotEquals(appUserDTO, appUserDTO1);
    }

    /**
     * Method under test: {@link AppUserDTO#equals(Object)}
     */
    @Test
    void testEquals14() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.ADMIN);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertNotEquals(appUserDTO, appUserDTO1);
    }

    /**
     * Method under test: {@link AppUserDTO#equals(Object)}
     */
    @Test
    void testEquals15() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("Name");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertNotEquals(appUserDTO, appUserDTO1);
    }

    /**
     * Method under test: {@link AppUserDTO#equals(Object)}
     */
    @Test
    void testEquals16() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername(null);

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertNotEquals(appUserDTO, appUserDTO1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AppUserDTO#equals(Object)}
     *   <li>{@link AppUserDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals17() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail(null);
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail(null);
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertEquals(appUserDTO, appUserDTO1);
        int expectedHashCodeResult = appUserDTO.hashCode();
        assertEquals(expectedHashCodeResult, appUserDTO1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AppUserDTO#equals(Object)}
     *   <li>{@link AppUserDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals18() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(null);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(null);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertEquals(appUserDTO, appUserDTO1);
        int expectedHashCodeResult = appUserDTO.hashCode();
        assertEquals(expectedHashCodeResult, appUserDTO1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AppUserDTO#equals(Object)}
     *   <li>{@link AppUserDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals19() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName(null);
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName(null);
        appUserDTO1.setPassword("iloveyou");
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertEquals(appUserDTO, appUserDTO1);
        int expectedHashCodeResult = appUserDTO.hashCode();
        assertEquals(expectedHashCodeResult, appUserDTO1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AppUserDTO#equals(Object)}
     *   <li>{@link AppUserDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals20() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword(null);
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");

        AppUserDTO appUserDTO1 = new AppUserDTO();
        appUserDTO1.setEmail("jane.doe@example.org");
        appUserDTO1.setId(123L);
        appUserDTO1.setName("Name");
        appUserDTO1.setPassword(null);
        appUserDTO1.setRole(AppUserRole.USER);
        appUserDTO1.setUsername("janedoe");
        assertEquals(appUserDTO, appUserDTO1);
        int expectedHashCodeResult = appUserDTO.hashCode();
        assertEquals(expectedHashCodeResult, appUserDTO1.hashCode());
    }
}

