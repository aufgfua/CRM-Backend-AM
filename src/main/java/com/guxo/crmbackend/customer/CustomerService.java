package com.guxo.crmbackend.customer;


import com.guxo.crmbackend.appuser.AppUserService;
import com.guxo.crmbackend.files.Image;
import com.guxo.crmbackend.files.ImageService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerService {

    // Autowired - Config -> nullableModelMapper()
    @Qualifier("nullableModelMapper")
    private final ModelMapper nullableModelMapper;

    // Autowired - CustomerRepository
    private final CustomerRepository customerRepository;

    // Autowired
    private final AppUserService appUserService;

    // Autowired
    private final ImageService imageService;


    // getCustomers :    -> List<Customer>
    // returns List of all customers
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }



    // getCustomer :  Long  -> Customer
    // returns customer by ID
    public Customer getCustomer(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId); // gets customer from id
        if (customer.isEmpty()) {
            return null;
        }
        return customer.get(); // return wanted customer
    }


    // getCustomerByEmail :  String  -> Customer
    // returns customer by Email
    public Customer getCustomerByEmail(String customerEmail) {
        Optional<Customer> customer = customerRepository.findByEmail(customerEmail); // gets customer from email
        if (customer.isEmpty()) {
            return null;
        }
        return customer.get(); // return wanted customer
    }



    // addNewCustomer : Customer -> Customer
    // Creates customer in DB and then returns the customer
    public Customer addNewCustomer(Customer customer, String appUserUsername){
        boolean customerExists = customerRepository.existsById(customer.getId()); // Search for customer ID

        if(customerExists) { // check if customer ID was already used
            throw new IllegalStateException("Customer ID already created");
        }

        customer.setCreationAppUser(appUserService.getAppUserByUsername(appUserUsername));

        customerRepository.save(customer); // create customer
        return customer; // Return Customer to the client (possibly different from given DTO)
    }


    public String uploadNewPhoto(Long customerId, MultipartFile photoFile, String appUserUsername){
        Customer customer = getCustomer(customerId);

        if(customer == null) {
            throw new IllegalStateException("Customer ID does not exist");
        }

        Image image = imageService.savePhoto(photoFile, customer);

        customer.setPhoto(image);
        customer.setLastUpdateAppUser(appUserService.getAppUserByUsername(appUserUsername)); // changing image counts as update

        customerRepository.save(customer);

        return image.getUrl();
    }



    // deleteCustomer : Long -> Void
    // Deletes customer with given ID
    public void deleteCustomer(Long customerId){
        boolean customerExists = customerRepository.existsById(customerId); // Search for customer ID
        if(!customerExists) { // check if customer ID exists
            throw new IllegalStateException("No customer has the given ID");
        }
        customerRepository.deleteById(customerId); // delete customer
    }



    public void updateCustomer(Long customerId, Customer newCustomerValues, String appUserUsername){

        Customer customer = getCustomer(customerId);

        if(customer == null) {
            throw new IllegalStateException("Customer ID does not exist");
        }

        nullableModelMapper.map(newCustomerValues, customer); // map not-null values from newCustomerValues to the customer object

        customer.setLastUpdateAppUser(appUserService.getAppUserByUsername(appUserUsername));

        customerRepository.save(customer); // save customer object with updated fields

    }


}
