package com.guxo.crmbackend.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {CustomerController.class})
@ExtendWith(SpringExtension.class)
class CustomerControllerTest {
    @Autowired
    private CustomerController customerController;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private ModelMapper modelMapper;

    /**
     * Method under test: {@link CustomerController#addNewCustomer(CustomerDTO)}
     */
    @Test
    void testAddNewCustomer() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(null);
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");
        String content = (new ObjectMapper()).writeValueAsString(customerDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link CustomerController#deleteCustomer(Long)}
     */
    @Test
    void testDeleteCustomer() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/{customerId}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link CustomerController#getCustomer(Long)}
     */
    @Test
    void testGetCustomer() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{customerId}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link CustomerController#getCustomerByEmail(String)}
     */
    @Test
    void testGetCustomerByEmail() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getByEmail/{customerEmail}",
                "jane.doe@example.org");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link CustomerController#getCustomers()}
     */
    @Test
    void testGetCustomers() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link CustomerController#updateCustomer(Long, CustomerDTO)}
     */
    @Test
    void testUpdateCustomer() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setDateOfBirth(null);
        customerDTO.setEmail("jane.doe@example.org");
        customerDTO.setId(123L);
        customerDTO.setName("Name");
        customerDTO.setNote("Note");
        customerDTO.setSurname("Doe");
        String content = (new ObjectMapper()).writeValueAsString(customerDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/{customerId}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link CustomerController#uploadNewPhoto(Long, MultipartFile)}
     */
    @Test
    void testUploadNewPhoto() throws Exception {
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/{customerId}/photo", 123L);
        MockHttpServletRequestBuilder requestBuilder = postResult.param("photo", String.valueOf((Object) null));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

