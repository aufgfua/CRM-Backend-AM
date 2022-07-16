package com.guxo.crm_backend.customer;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/customer")
public class CustomerController {

    private final CustomerService customerService; // Passed to the constructor with Dependency Injection

    // Return all customers
    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    // Create new customer
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }

    // Delete customer by id
    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
    }

    // Update customer by id
    @PutMapping(path = "{customerId}")
    public void updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer){
//        customerService.updateCustomer(id, customer);
    }


}
