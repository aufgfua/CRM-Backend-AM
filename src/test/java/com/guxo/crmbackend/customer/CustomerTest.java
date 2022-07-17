package com.guxo.crmbackend.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CustomerTest {
    /**
     * Method under test: {@link Customer#Customer(Long, String, String)}
     */
    @Test
    void testConstructor() {
        Customer actualCustomer = new Customer(123L, "Name", "Doe");

        assertNull(actualCustomer.getDateOfBirth());
        assertEquals("Doe", actualCustomer.getSurname());
        assertEquals("Name", actualCustomer.getName());
        assertNull(actualCustomer.getLastPurchase());
        assertEquals(123L, actualCustomer.getId().longValue());
        assertNull(actualCustomer.getEmail());
    }
}

