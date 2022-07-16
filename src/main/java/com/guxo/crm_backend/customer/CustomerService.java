package com.guxo.crm_backend.customer;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer){
        boolean customerExists = customerRepository.existsById(customer.getId());// Search for customer ID in database
        if(customerExists) { // check if no customer with that ID exists
            throw new IllegalStateException("Customer ID already created");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId){
        boolean customerExists = customerRepository.existsById(customerId);// Search for customer ID in database
        if(!customerExists) { // check if wanted customer ID exists
            throw new IllegalStateException("No customer has the given ID");
        }
        customerRepository.deleteById(customerId);
    }


}
