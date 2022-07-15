package com.guxo.crm_backend.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class CustomerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Customer#Customer(Long, String, String, String, LocalDate)}
     *   <li>{@link Customer#setDateOfBirth(LocalDate)}
     *   <li>{@link Customer#setEmail(String)}
     *   <li>{@link Customer#setId(Long)}
     *   <li>{@link Customer#setName(String)}
     *   <li>{@link Customer#setSurname(String)}
     *   <li>{@link Customer#getDateOfBirth()}
     *   <li>{@link Customer#getEmail()}
     *   <li>{@link Customer#getId()}
     *   <li>{@link Customer#getName()}
     *   <li>{@link Customer#getSurname()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Customer actualCustomer = new Customer(123L, "Name", "Doe", "jane.doe@example.org", LocalDate.ofEpochDay(1L));
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualCustomer.setDateOfBirth(ofEpochDayResult);
        actualCustomer.setEmail("jane.doe@example.org");
        actualCustomer.setId(123L);
        actualCustomer.setName("Name");
        actualCustomer.setSurname("Doe");
        assertSame(ofEpochDayResult, actualCustomer.getDateOfBirth());
        assertEquals("jane.doe@example.org", actualCustomer.getEmail());
        assertEquals(123L, actualCustomer.getId().longValue());
        assertEquals("Name", actualCustomer.getName());
        assertEquals("Doe", actualCustomer.getSurname());
    }
}

