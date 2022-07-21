package com.guxo.crmbackend.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class CustomerDTOTest {
    /**
     * Method under test: {@link CustomerDTO#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new CustomerDTO()).canEqual("Other"));
    }

    /**
     * Method under test: {@link CustomerDTO#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        CustomerDTO customerDTO = new CustomerDTO();

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(3L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertTrue(customerDTO.canEqual(customerDTO1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link CustomerDTO}
     *   <li>{@link CustomerDTO#setDateOfBirth(LocalDate)}
     *   <li>{@link CustomerDTO#setEmail(String)}
     *   <li>{@link CustomerDTO#setId(Long)}
     *   <li>{@link CustomerDTO#setName(String)}
     *   <li>{@link CustomerDTO#setNote(String)}
     *   <li>{@link CustomerDTO#setSurname(String)}
     *   <li>{@link CustomerDTO#toString()}
     *   <li>{@link CustomerDTO#getDateOfBirth()}
     *   <li>{@link CustomerDTO#getEmail()}
     *   <li>{@link CustomerDTO#getId()}
     *   <li>{@link CustomerDTO#getName()}
     *   <li>{@link CustomerDTO#getNote()}
     *   <li>{@link CustomerDTO#getSurname()}
     * </ul>
     */
    @Test
    void testConstructor() {
        CustomerDTO actualCustomerDTO = new CustomerDTO();
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualCustomerDTO.setDateOfBirth(ofEpochDayResult);
        actualCustomerDTO.setEmail("jane.doe@example.org");
        actualCustomerDTO.setId(123L);
        actualCustomerDTO.setName("Name");
        actualCustomerDTO.setNote("Note");
        actualCustomerDTO.setSurname("Doe");
        String actualToStringResult = actualCustomerDTO.toString();
        assertSame(ofEpochDayResult, actualCustomerDTO.getDateOfBirth());
        assertEquals("jane.doe@example.org", actualCustomerDTO.getEmail());
        assertEquals(123L, actualCustomerDTO.getId().longValue());
        assertEquals("Name", actualCustomerDTO.getName());
        assertEquals("Note", actualCustomerDTO.getNote());
        assertEquals("Doe", actualCustomerDTO.getSurname());
        assertEquals("CustomerDTO(id=123, name=Name, surname=Doe, email=jane.doe@example.org, dateOfBirth=1970-01-02,"
                + " note=Note)", actualToStringResult);
    }

    /**
     * Method under test: {@link CustomerDTO#equals(Object)}
     */
    @Test
    void testEquals() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");
        assertNotEquals(customerDTO, null);
    }

    /**
     * Method under test: {@link CustomerDTO#equals(Object)}
     */
    @Test
    void testEquals2() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");
        assertNotEquals(customerDTO, "Different type to CustomerDTO");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CustomerDTO#equals(Object)}
     *   <li>{@link CustomerDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");
        assertEquals(customerDTO, customerDTO);
        int expectedHashCodeResult = customerDTO.hashCode();
        assertEquals(expectedHashCodeResult, customerDTO.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CustomerDTO#equals(Object)}
     *   <li>{@link CustomerDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertEquals(customerDTO, customerDTO1);
        int expectedHashCodeResult = customerDTO.hashCode();
        assertEquals(expectedHashCodeResult, customerDTO1.hashCode());
    }

    /**
     * Method under test: {@link CustomerDTO#equals(Object)}
     */
    @Test
    void testEquals5() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(3L));
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertNotEquals(customerDTO, customerDTO1);
    }

    /**
     * Method under test: {@link CustomerDTO#equals(Object)}
     */
    @Test
    void testEquals6() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(null);
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertNotEquals(customerDTO, customerDTO1);
    }

    /**
     * Method under test: {@link CustomerDTO#equals(Object)}
     */
    @Test
    void testEquals7() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail("Name");
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertNotEquals(customerDTO, customerDTO1);
    }

    /**
     * Method under test: {@link CustomerDTO#equals(Object)}
     */
    @Test
    void testEquals8() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail(null);
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertNotEquals(customerDTO, customerDTO1);
    }

    /**
     * Method under test: {@link CustomerDTO#equals(Object)}
     */
    @Test
    void testEquals9() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(1L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertNotEquals(customerDTO, customerDTO1);
    }

    /**
     * Method under test: {@link CustomerDTO#equals(Object)}
     */
    @Test
    void testEquals10() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(null);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertNotEquals(customerDTO, customerDTO1);
    }

    /**
     * Method under test: {@link CustomerDTO#equals(Object)}
     */
    @Test
    void testEquals11() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName("Doe");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertNotEquals(customerDTO, customerDTO1);
    }

    /**
     * Method under test: {@link CustomerDTO#equals(Object)}
     */
    @Test
    void testEquals12() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName(null);
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertNotEquals(customerDTO, customerDTO1);
    }

    /**
     * Method under test: {@link CustomerDTO#equals(Object)}
     */
    @Test
    void testEquals13() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Name");
        customerDTO.setSurname("Doe");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertNotEquals(customerDTO, customerDTO1);
    }

    /**
     * Method under test: {@link CustomerDTO#equals(Object)}
     */
    @Test
    void testEquals14() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote(null);
        customerDTO.setSurname("Doe");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertNotEquals(customerDTO, customerDTO1);
    }

    /**
     * Method under test: {@link CustomerDTO#equals(Object)}
     */
    @Test
    void testEquals15() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Name");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertNotEquals(customerDTO, customerDTO1);
    }

    /**
     * Method under test: {@link CustomerDTO#equals(Object)}
     */
    @Test
    void testEquals16() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname(null);

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertNotEquals(customerDTO, customerDTO1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CustomerDTO#equals(Object)}
     *   <li>{@link CustomerDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals17() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(null);
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(null);
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertEquals(customerDTO, customerDTO1);
        int expectedHashCodeResult = customerDTO.hashCode();
        assertEquals(expectedHashCodeResult, customerDTO1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CustomerDTO#equals(Object)}
     *   <li>{@link CustomerDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals18() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail(null);
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail(null);
        customerDTO1.setId(123L);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertEquals(customerDTO, customerDTO1);
        int expectedHashCodeResult = customerDTO.hashCode();
        assertEquals(expectedHashCodeResult, customerDTO1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CustomerDTO#equals(Object)}
     *   <li>{@link CustomerDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals19() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(null);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");

        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customerDTO1.setEmail("jane.doe@example.org");
        customerDTO1.setId(null);
        customerDTO1.setName("Name");
        customerDTO1.setNote("Note");
        customerDTO1.setSurname("Doe");
        assertEquals(customerDTO, customerDTO1);
        int expectedHashCodeResult = customerDTO.hashCode();
        assertEquals(expectedHashCodeResult, customerDTO1.hashCode());
    }
}

