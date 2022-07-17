package com.guxo.crmbackend.customer;


import com.guxo.crmbackend.exceptions.CustomerNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    // Autowired - Config -> nullableModelMapper()
    @Qualifier("nullableModelMapper")
    private final ModelMapper nullableModelMapper; // configured to skip null fields

    // Autowired - Config -> modelMapper()
    @Qualifier("modelMapper")
    private final ModelMapper modelMapper; // configured to convert all fields


    // Autowired - CustomerService.class
    private final CustomerService customerService; // Passed to the constructor with Dependency Injection



    // GET /api/customer
    // Return all customers
    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }



    // GET /api/customer/{id}
    // Get customer by id
    @GetMapping(path = "{customerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer getCustomer(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if(customer == null){
            throw new CustomerNotFoundException();
        }
        return customer;
    }





    // GET /api/customer/getByEmail/{customerEmail}
    // Get customer by id
    @GetMapping(path = "getByEmail/{customerEmail}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer getCustomerByEmail(@PathVariable String customerEmail) {
        Customer customer = customerService.getCustomerByEmail(customerEmail);
        if(customer == null){
            throw new CustomerNotFoundException();
        }
        return customer;
    }




    // POST /api/customer
    // Create new customer
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addNewCustomer(@RequestBody CustomerDTO customerDto){
        Customer customer = convertDtoToEntity(customerDto);
        return customerService.addNewCustomer(customer);
    }



    // DELETE /api/customer/{id}
    // Delete customer by id
    @DeleteMapping(path = "{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
    }



    // PUT /api/customer/{id}
    // Update customer by id
    @PutMapping(path = "{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDto){

        boolean idsMatch = Objects.equals(customerId, customerDto.getId());
        if(!idsMatch) {
            throw new IllegalArgumentException("IDs don't match");
        }

        Customer customer = convertPartialDtoToEntity(customerDto);
        customerService.updateCustomer(customerId, customer);
    }


    // Receives DTO and convert to Entity - skips null fields
    private Customer convertPartialDtoToEntity(CustomerDTO customerDTO){
        Customer customer = nullableModelMapper.map(customerDTO, Customer.class);
        return customer;
    }


    // Receives DTO and convert to Entity - Tries to convert every field
    private Customer convertDtoToEntity(CustomerDTO customerDTO){
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        return customer;
    }




}
