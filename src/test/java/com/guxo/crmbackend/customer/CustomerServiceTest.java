package com.guxo.crmbackend.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.guxo.crmbackend.appuser.AppUser;
import com.guxo.crmbackend.appuser.AppUserRole;
import com.guxo.crmbackend.appuser.AppUserService;
import com.guxo.crmbackend.files.Image;
import com.guxo.crmbackend.files.ImageService;

import java.io.UnsupportedEncodingException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {CustomerService.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceTest {
    @MockBean
    private AppUserService appUserService;

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @MockBean
    private ImageService imageService;

    @MockBean
    private ModelMapper modelMapper;

    /**
     * Method under test: {@link CustomerService#getCustomers()}
     */
    @Test
    void testGetCustomers() {
        ArrayList<Customer> customerList = new ArrayList<>();
        when(customerRepository.findAll()).thenReturn(customerList);
        List<Customer> actualCustomers = customerService.getCustomers();
        assertSame(customerList, actualCustomers);
        assertTrue(actualCustomers.isEmpty());
        verify(customerRepository).findAll();
    }

    /**
     * Method under test: {@link CustomerService#getCustomers()}
     */
    @Test
    void testGetCustomers2() {
        when(customerRepository.findAll()).thenThrow(new IllegalStateException("foo"));
        assertThrows(IllegalStateException.class, () -> customerService.getCustomers());
        verify(customerRepository).findAll();
    }

    /**
     * Method under test: {@link CustomerService#getCustomer(Long)}
     */
    @Test
    void testGetCustomer() {
        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");

        AppUser appUser1 = new AppUser();
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setId(123L);
        appUser1.setName("Name");
        appUser1.setPassword("iloveyou");
        appUser1.setRole(AppUserRole.USER);
        appUser1.setUsername("janedoe");

        AppUser appUser2 = new AppUser();
        appUser2.setEmail("jane.doe@example.org");
        appUser2.setId(123L);
        appUser2.setName("Name");
        appUser2.setPassword("iloveyou");
        appUser2.setRole(AppUserRole.USER);
        appUser2.setUsername("janedoe");

        AppUser appUser3 = new AppUser();
        appUser3.setEmail("jane.doe@example.org");
        appUser3.setId(123L);
        appUser3.setName("Name");
        appUser3.setPassword("iloveyou");
        appUser3.setRole(AppUserRole.USER);
        appUser3.setUsername("janedoe");

        Image image = new Image();
        image.setId(123L);
        image.setOwner(new Customer());
        image.setUrl("https://example.org/example");

        Customer customer = new Customer();
        customer.setCreationAppUser(appUser2);
        customer.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setLastUpdateAppUser(appUser3);
        customer.setName("Name");
        customer.setNote("Note");
        customer.setPhoto(image);
        customer.setSurname("Doe");

        Image image1 = new Image();
        image1.setId(123L);
        image1.setOwner(customer);
        image1.setUrl("https://example.org/example");

        Customer customer1 = new Customer();
        customer1.setCreationAppUser(appUser);
        customer1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setLastUpdateAppUser(appUser1);
        customer1.setName("Name");
        customer1.setNote("Note");
        customer1.setPhoto(image1);
        customer1.setSurname("Doe");
        Optional<Customer> ofResult = Optional.of(customer1);
        when(customerRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(customer1, customerService.getCustomer(123L));
        verify(customerRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link CustomerService#getCustomerByEmail(String)}
     */
    @Test
    void testGetCustomerByEmail() {
        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");

        AppUser appUser1 = new AppUser();
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setId(123L);
        appUser1.setName("Name");
        appUser1.setPassword("iloveyou");
        appUser1.setRole(AppUserRole.USER);
        appUser1.setUsername("janedoe");

        AppUser appUser2 = new AppUser();
        appUser2.setEmail("jane.doe@example.org");
        appUser2.setId(123L);
        appUser2.setName("Name");
        appUser2.setPassword("iloveyou");
        appUser2.setRole(AppUserRole.USER);
        appUser2.setUsername("janedoe");

        AppUser appUser3 = new AppUser();
        appUser3.setEmail("jane.doe@example.org");
        appUser3.setId(123L);
        appUser3.setName("Name");
        appUser3.setPassword("iloveyou");
        appUser3.setRole(AppUserRole.USER);
        appUser3.setUsername("janedoe");

        Image image = new Image();
        image.setId(123L);
        image.setOwner(new Customer());
        image.setUrl("https://example.org/example");

        Customer customer = new Customer();
        customer.setCreationAppUser(appUser2);
        customer.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setLastUpdateAppUser(appUser3);
        customer.setName("Name");
        customer.setNote("Note");
        customer.setPhoto(image);
        customer.setSurname("Doe");

        Image image1 = new Image();
        image1.setId(123L);
        image1.setOwner(customer);
        image1.setUrl("https://example.org/example");

        Customer customer1 = new Customer();
        customer1.setCreationAppUser(appUser);
        customer1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setLastUpdateAppUser(appUser1);
        customer1.setName("Name");
        customer1.setNote("Note");
        customer1.setPhoto(image1);
        customer1.setSurname("Doe");
        Optional<Customer> ofResult = Optional.of(customer1);
        when(customerRepository.findByEmail((String) any())).thenReturn(ofResult);
        assertSame(customer1, customerService.getCustomerByEmail("jane.doe@example.org"));
        verify(customerRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link CustomerService#addNewCustomer(Customer, String)}
     */
    @Test
    void testAddNewCustomer() {
        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");

        AppUser appUser1 = new AppUser();
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setId(123L);
        appUser1.setName("Name");
        appUser1.setPassword("iloveyou");
        appUser1.setRole(AppUserRole.USER);
        appUser1.setUsername("janedoe");

        AppUser appUser2 = new AppUser();
        appUser2.setEmail("jane.doe@example.org");
        appUser2.setId(123L);
        appUser2.setName("Name");
        appUser2.setPassword("iloveyou");
        appUser2.setRole(AppUserRole.USER);
        appUser2.setUsername("janedoe");

        AppUser appUser3 = new AppUser();
        appUser3.setEmail("jane.doe@example.org");
        appUser3.setId(123L);
        appUser3.setName("Name");
        appUser3.setPassword("iloveyou");
        appUser3.setRole(AppUserRole.USER);
        appUser3.setUsername("janedoe");

        Customer customer = new Customer();
        customer.setCreationAppUser(new AppUser());
        customer.setDateOfBirth(null);
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setLastUpdateAppUser(new AppUser());
        customer.setName("Name");
        customer.setNote("Note");
        customer.setPhoto(new Image());
        customer.setSurname("Doe");

        Image image = new Image();
        image.setId(123L);
        image.setOwner(customer);
        image.setUrl("https://example.org/example");

        Customer customer1 = new Customer();
        customer1.setCreationAppUser(appUser2);
        customer1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setLastUpdateAppUser(appUser3);
        customer1.setName("Name");
        customer1.setNote("Note");
        customer1.setPhoto(image);
        customer1.setSurname("Doe");

        Image image1 = new Image();
        image1.setId(123L);
        image1.setOwner(customer1);
        image1.setUrl("https://example.org/example");

        Customer customer2 = new Customer();
        customer2.setCreationAppUser(appUser);
        customer2.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer2.setEmail("jane.doe@example.org");
        customer2.setId(123L);
        customer2.setLastUpdateAppUser(appUser1);
        customer2.setName("Name");
        customer2.setNote("Note");
        customer2.setPhoto(image1);
        customer2.setSurname("Doe");
        when(customerRepository.existsById((Long) any())).thenReturn(true);
        when(customerRepository.save((Customer) any())).thenReturn(customer2);

        AppUser appUser4 = new AppUser();
        appUser4.setEmail("jane.doe@example.org");
        appUser4.setId(123L);
        appUser4.setName("Name");
        appUser4.setPassword("iloveyou");
        appUser4.setRole(AppUserRole.USER);
        appUser4.setUsername("janedoe");

        AppUser appUser5 = new AppUser();
        appUser5.setEmail("jane.doe@example.org");
        appUser5.setId(123L);
        appUser5.setName("Name");
        appUser5.setPassword("iloveyou");
        appUser5.setRole(AppUserRole.USER);
        appUser5.setUsername("janedoe");

        AppUser appUser6 = new AppUser();
        appUser6.setEmail("jane.doe@example.org");
        appUser6.setId(123L);
        appUser6.setName("Name");
        appUser6.setPassword("iloveyou");
        appUser6.setRole(AppUserRole.USER);
        appUser6.setUsername("janedoe");

        AppUser appUser7 = new AppUser();
        appUser7.setEmail("jane.doe@example.org");
        appUser7.setId(123L);
        appUser7.setName("Name");
        appUser7.setPassword("iloveyou");
        appUser7.setRole(AppUserRole.USER);
        appUser7.setUsername("janedoe");

        Image image2 = new Image();
        image2.setId(123L);
        image2.setOwner(new Customer());
        image2.setUrl("https://example.org/example");

        Customer customer3 = new Customer();
        customer3.setCreationAppUser(appUser6);
        customer3.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer3.setEmail("jane.doe@example.org");
        customer3.setId(123L);
        customer3.setLastUpdateAppUser(appUser7);
        customer3.setName("Name");
        customer3.setNote("Note");
        customer3.setPhoto(image2);
        customer3.setSurname("Doe");

        Image image3 = new Image();
        image3.setId(123L);
        image3.setOwner(customer3);
        image3.setUrl("https://example.org/example");

        Customer customer4 = new Customer();
        customer4.setCreationAppUser(appUser4);
        customer4.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer4.setEmail("jane.doe@example.org");
        customer4.setId(123L);
        customer4.setLastUpdateAppUser(appUser5);
        customer4.setName("Name");
        customer4.setNote("Note");
        customer4.setPhoto(image3);
        customer4.setSurname("Doe");
        assertThrows(IllegalStateException.class, () -> customerService.addNewCustomer(customer4, "janedoe"));
        verify(customerRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link CustomerService#addNewCustomer(Customer, String)}
     */
    @Test
    void testAddNewCustomer2() {
        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");

        AppUser appUser1 = new AppUser();
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setId(123L);
        appUser1.setName("Name");
        appUser1.setPassword("iloveyou");
        appUser1.setRole(AppUserRole.USER);
        appUser1.setUsername("janedoe");

        AppUser appUser2 = new AppUser();
        appUser2.setEmail("jane.doe@example.org");
        appUser2.setId(123L);
        appUser2.setName("Name");
        appUser2.setPassword("iloveyou");
        appUser2.setRole(AppUserRole.USER);
        appUser2.setUsername("janedoe");

        AppUser appUser3 = new AppUser();
        appUser3.setEmail("jane.doe@example.org");
        appUser3.setId(123L);
        appUser3.setName("Name");
        appUser3.setPassword("iloveyou");
        appUser3.setRole(AppUserRole.USER);
        appUser3.setUsername("janedoe");

        Customer customer = new Customer();
        customer.setCreationAppUser(new AppUser());
        customer.setDateOfBirth(null);
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setLastUpdateAppUser(new AppUser());
        customer.setName("Name");
        customer.setNote("Note");
        customer.setPhoto(new Image());
        customer.setSurname("Doe");

        Image image = new Image();
        image.setId(123L);
        image.setOwner(customer);
        image.setUrl("https://example.org/example");

        Customer customer1 = new Customer();
        customer1.setCreationAppUser(appUser2);
        customer1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setLastUpdateAppUser(appUser3);
        customer1.setName("Name");
        customer1.setNote("Note");
        customer1.setPhoto(image);
        customer1.setSurname("Doe");

        Image image1 = new Image();
        image1.setId(123L);
        image1.setOwner(customer1);
        image1.setUrl("https://example.org/example");

        Customer customer2 = new Customer();
        customer2.setCreationAppUser(appUser);
        customer2.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer2.setEmail("jane.doe@example.org");
        customer2.setId(123L);
        customer2.setLastUpdateAppUser(appUser1);
        customer2.setName("Name");
        customer2.setNote("Note");
        customer2.setPhoto(image1);
        customer2.setSurname("Doe");
        when(customerRepository.existsById((Long) any())).thenReturn(false);
        when(customerRepository.save((Customer) any())).thenReturn(customer2);

        AppUser appUser4 = new AppUser();
        appUser4.setEmail("jane.doe@example.org");
        appUser4.setId(123L);
        appUser4.setName("Name");
        appUser4.setPassword("iloveyou");
        appUser4.setRole(AppUserRole.USER);
        appUser4.setUsername("janedoe");
        when(appUserService.getAppUserByUsername((String) any())).thenReturn(appUser4);

        AppUser appUser5 = new AppUser();
        appUser5.setEmail("jane.doe@example.org");
        appUser5.setId(123L);
        appUser5.setName("Name");
        appUser5.setPassword("iloveyou");
        appUser5.setRole(AppUserRole.USER);
        appUser5.setUsername("janedoe");

        AppUser appUser6 = new AppUser();
        appUser6.setEmail("jane.doe@example.org");
        appUser6.setId(123L);
        appUser6.setName("Name");
        appUser6.setPassword("iloveyou");
        appUser6.setRole(AppUserRole.USER);
        appUser6.setUsername("janedoe");

        AppUser appUser7 = new AppUser();
        appUser7.setEmail("jane.doe@example.org");
        appUser7.setId(123L);
        appUser7.setName("Name");
        appUser7.setPassword("iloveyou");
        appUser7.setRole(AppUserRole.USER);
        appUser7.setUsername("janedoe");

        AppUser appUser8 = new AppUser();
        appUser8.setEmail("jane.doe@example.org");
        appUser8.setId(123L);
        appUser8.setName("Name");
        appUser8.setPassword("iloveyou");
        appUser8.setRole(AppUserRole.USER);
        appUser8.setUsername("janedoe");

        Image image2 = new Image();
        image2.setId(123L);
        image2.setOwner(new Customer());
        image2.setUrl("https://example.org/example");

        Customer customer3 = new Customer();
        customer3.setCreationAppUser(appUser7);
        customer3.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer3.setEmail("jane.doe@example.org");
        customer3.setId(123L);
        customer3.setLastUpdateAppUser(appUser8);
        customer3.setName("Name");
        customer3.setNote("Note");
        customer3.setPhoto(image2);
        customer3.setSurname("Doe");

        Image image3 = new Image();
        image3.setId(123L);
        image3.setOwner(customer3);
        image3.setUrl("https://example.org/example");

        Customer customer4 = new Customer();
        customer4.setCreationAppUser(appUser5);
        customer4.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer4.setEmail("jane.doe@example.org");
        customer4.setId(123L);
        customer4.setLastUpdateAppUser(appUser6);
        customer4.setName("Name");
        customer4.setNote("Note");
        customer4.setPhoto(image3);
        customer4.setSurname("Doe");
        Customer actualAddNewCustomerResult = customerService.addNewCustomer(customer4, "janedoe");
        assertSame(customer4, actualAddNewCustomerResult);
        assertEquals(appUser5, actualAddNewCustomerResult.getCreationAppUser());
        verify(customerRepository).existsById((Long) any());
        verify(customerRepository).save((Customer) any());
        verify(appUserService).getAppUserByUsername((String) any());
    }

    /**
     * Method under test: {@link CustomerService#uploadNewPhoto(Long, MultipartFile, String)}
     */
    @Test
    void testUploadNewPhoto() throws UnsupportedEncodingException {
        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");

        AppUser appUser1 = new AppUser();
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setId(123L);
        appUser1.setName("Name");
        appUser1.setPassword("iloveyou");
        appUser1.setRole(AppUserRole.USER);
        appUser1.setUsername("janedoe");

        AppUser appUser2 = new AppUser();
        appUser2.setEmail("jane.doe@example.org");
        appUser2.setId(123L);
        appUser2.setName("Name");
        appUser2.setPassword("iloveyou");
        appUser2.setRole(AppUserRole.USER);
        appUser2.setUsername("janedoe");

        AppUser appUser3 = new AppUser();
        appUser3.setEmail("jane.doe@example.org");
        appUser3.setId(123L);
        appUser3.setName("Name");
        appUser3.setPassword("iloveyou");
        appUser3.setRole(AppUserRole.USER);
        appUser3.setUsername("janedoe");

        Image image = new Image();
        image.setId(123L);
        image.setOwner(new Customer());
        image.setUrl("https://example.org/example");

        Customer customer = new Customer();
        customer.setCreationAppUser(appUser2);
        customer.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setLastUpdateAppUser(appUser3);
        customer.setName("Name");
        customer.setNote("Note");
        customer.setPhoto(image);
        customer.setSurname("Doe");

        Image image1 = new Image();
        image1.setId(123L);
        image1.setOwner(customer);
        image1.setUrl("https://example.org/example");

        Customer customer1 = new Customer();
        customer1.setCreationAppUser(appUser);
        customer1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setLastUpdateAppUser(appUser1);
        customer1.setName("Name");
        customer1.setNote("Note");
        customer1.setPhoto(image1);
        customer1.setSurname("Doe");
        Optional<Customer> ofResult = Optional.of(customer1);

        AppUser appUser4 = new AppUser();
        appUser4.setEmail("jane.doe@example.org");
        appUser4.setId(123L);
        appUser4.setName("Name");
        appUser4.setPassword("iloveyou");
        appUser4.setRole(AppUserRole.USER);
        appUser4.setUsername("janedoe");

        AppUser appUser5 = new AppUser();
        appUser5.setEmail("jane.doe@example.org");
        appUser5.setId(123L);
        appUser5.setName("Name");
        appUser5.setPassword("iloveyou");
        appUser5.setRole(AppUserRole.USER);
        appUser5.setUsername("janedoe");

        AppUser appUser6 = new AppUser();
        appUser6.setEmail("jane.doe@example.org");
        appUser6.setId(123L);
        appUser6.setName("Name");
        appUser6.setPassword("iloveyou");
        appUser6.setRole(AppUserRole.USER);
        appUser6.setUsername("janedoe");

        AppUser appUser7 = new AppUser();
        appUser7.setEmail("jane.doe@example.org");
        appUser7.setId(123L);
        appUser7.setName("Name");
        appUser7.setPassword("iloveyou");
        appUser7.setRole(AppUserRole.USER);
        appUser7.setUsername("janedoe");

        Customer customer2 = new Customer();
        customer2.setCreationAppUser(new AppUser());
        customer2.setDateOfBirth(null);
        customer2.setEmail("jane.doe@example.org");
        customer2.setId(123L);
        customer2.setLastUpdateAppUser(new AppUser());
        customer2.setName("Name");
        customer2.setNote("Note");
        customer2.setPhoto(new Image());
        customer2.setSurname("Doe");

        Image image2 = new Image();
        image2.setId(123L);
        image2.setOwner(customer2);
        image2.setUrl("https://example.org/example");

        Customer customer3 = new Customer();
        customer3.setCreationAppUser(appUser6);
        customer3.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer3.setEmail("jane.doe@example.org");
        customer3.setId(123L);
        customer3.setLastUpdateAppUser(appUser7);
        customer3.setName("Name");
        customer3.setNote("Note");
        customer3.setPhoto(image2);
        customer3.setSurname("Doe");

        Image image3 = new Image();
        image3.setId(123L);
        image3.setOwner(customer3);
        image3.setUrl("https://example.org/example");

        Customer customer4 = new Customer();
        customer4.setCreationAppUser(appUser4);
        customer4.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer4.setEmail("jane.doe@example.org");
        customer4.setId(123L);
        customer4.setLastUpdateAppUser(appUser5);
        customer4.setName("Name");
        customer4.setNote("Note");
        customer4.setPhoto(image3);
        customer4.setSurname("Doe");
        when(customerRepository.save((Customer) any())).thenReturn(customer4);
        when(customerRepository.findById((Long) any())).thenReturn(ofResult);

        AppUser appUser8 = new AppUser();
        appUser8.setEmail("jane.doe@example.org");
        appUser8.setId(123L);
        appUser8.setName("Name");
        appUser8.setPassword("iloveyou");
        appUser8.setRole(AppUserRole.USER);
        appUser8.setUsername("janedoe");
        when(appUserService.getAppUserByUsername((String) any())).thenReturn(appUser8);

        AppUser appUser9 = new AppUser();
        appUser9.setEmail("jane.doe@example.org");
        appUser9.setId(123L);
        appUser9.setName("Name");
        appUser9.setPassword("iloveyou");
        appUser9.setRole(AppUserRole.USER);
        appUser9.setUsername("janedoe");

        AppUser appUser10 = new AppUser();
        appUser10.setEmail("jane.doe@example.org");
        appUser10.setId(123L);
        appUser10.setName("Name");
        appUser10.setPassword("iloveyou");
        appUser10.setRole(AppUserRole.USER);
        appUser10.setUsername("janedoe");

        AppUser appUser11 = new AppUser();
        appUser11.setEmail("jane.doe@example.org");
        appUser11.setId(123L);
        appUser11.setName("Name");
        appUser11.setPassword("iloveyou");
        appUser11.setRole(AppUserRole.USER);
        appUser11.setUsername("janedoe");

        AppUser appUser12 = new AppUser();
        appUser12.setEmail("jane.doe@example.org");
        appUser12.setId(123L);
        appUser12.setName("Name");
        appUser12.setPassword("iloveyou");
        appUser12.setRole(AppUserRole.USER);
        appUser12.setUsername("janedoe");

        Image image4 = new Image();
        image4.setId(123L);
        image4.setOwner(new Customer());
        image4.setUrl("https://example.org/example");

        Customer customer5 = new Customer();
        customer5.setCreationAppUser(appUser11);
        customer5.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer5.setEmail("jane.doe@example.org");
        customer5.setId(123L);
        customer5.setLastUpdateAppUser(appUser12);
        customer5.setName("Name");
        customer5.setNote("Note");
        customer5.setPhoto(image4);
        customer5.setSurname("Doe");

        Image image5 = new Image();
        image5.setId(123L);
        image5.setOwner(customer5);
        image5.setUrl("https://example.org/example");

        Customer customer6 = new Customer();
        customer6.setCreationAppUser(appUser9);
        customer6.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer6.setEmail("jane.doe@example.org");
        customer6.setId(123L);
        customer6.setLastUpdateAppUser(appUser10);
        customer6.setName("Name");
        customer6.setNote("Note");
        customer6.setPhoto(image5);
        customer6.setSurname("Doe");

        Image image6 = new Image();
        image6.setId(123L);
        image6.setOwner(customer6);
        image6.setUrl("https://example.org/example");
        when(imageService.savePhoto((MultipartFile) any(), (Customer) any())).thenReturn(image6);
        assertEquals("https://example.org/example",
                customerService.uploadNewPhoto(123L, new MockMultipartFile("Name", "AAAAAAAA".getBytes("UTF-8")), "janedoe"));
        verify(customerRepository).save((Customer) any());
        verify(customerRepository).findById((Long) any());
        verify(appUserService).getAppUserByUsername((String) any());
        verify(imageService).savePhoto((MultipartFile) any(), (Customer) any());
    }

    /**
     * Method under test: {@link CustomerService#uploadNewPhoto(Long, MultipartFile, String)}
     */
    @Test
    void testUploadNewPhoto2() throws UnsupportedEncodingException {
        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");

        AppUser appUser1 = new AppUser();
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setId(123L);
        appUser1.setName("Name");
        appUser1.setPassword("iloveyou");
        appUser1.setRole(AppUserRole.USER);
        appUser1.setUsername("janedoe");

        AppUser appUser2 = new AppUser();
        appUser2.setEmail("jane.doe@example.org");
        appUser2.setId(123L);
        appUser2.setName("Name");
        appUser2.setPassword("iloveyou");
        appUser2.setRole(AppUserRole.USER);
        appUser2.setUsername("janedoe");

        AppUser appUser3 = new AppUser();
        appUser3.setEmail("jane.doe@example.org");
        appUser3.setId(123L);
        appUser3.setName("Name");
        appUser3.setPassword("iloveyou");
        appUser3.setRole(AppUserRole.USER);
        appUser3.setUsername("janedoe");

        Image image = new Image();
        image.setId(123L);
        image.setOwner(new Customer());
        image.setUrl("https://example.org/example");

        Customer customer = new Customer();
        customer.setCreationAppUser(appUser2);
        customer.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setLastUpdateAppUser(appUser3);
        customer.setName("Name");
        customer.setNote("Note");
        customer.setPhoto(image);
        customer.setSurname("Doe");

        Image image1 = new Image();
        image1.setId(123L);
        image1.setOwner(customer);
        image1.setUrl("https://example.org/example");

        Customer customer1 = new Customer();
        customer1.setCreationAppUser(appUser);
        customer1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setLastUpdateAppUser(appUser1);
        customer1.setName("Name");
        customer1.setNote("Note");
        customer1.setPhoto(image1);
        customer1.setSurname("Doe");
        Optional<Customer> ofResult = Optional.of(customer1);

        AppUser appUser4 = new AppUser();
        appUser4.setEmail("jane.doe@example.org");
        appUser4.setId(123L);
        appUser4.setName("Name");
        appUser4.setPassword("iloveyou");
        appUser4.setRole(AppUserRole.USER);
        appUser4.setUsername("janedoe");

        AppUser appUser5 = new AppUser();
        appUser5.setEmail("jane.doe@example.org");
        appUser5.setId(123L);
        appUser5.setName("Name");
        appUser5.setPassword("iloveyou");
        appUser5.setRole(AppUserRole.USER);
        appUser5.setUsername("janedoe");

        AppUser appUser6 = new AppUser();
        appUser6.setEmail("jane.doe@example.org");
        appUser6.setId(123L);
        appUser6.setName("Name");
        appUser6.setPassword("iloveyou");
        appUser6.setRole(AppUserRole.USER);
        appUser6.setUsername("janedoe");

        AppUser appUser7 = new AppUser();
        appUser7.setEmail("jane.doe@example.org");
        appUser7.setId(123L);
        appUser7.setName("Name");
        appUser7.setPassword("iloveyou");
        appUser7.setRole(AppUserRole.USER);
        appUser7.setUsername("janedoe");

        Customer customer2 = new Customer();
        customer2.setCreationAppUser(new AppUser());
        customer2.setDateOfBirth(null);
        customer2.setEmail("jane.doe@example.org");
        customer2.setId(123L);
        customer2.setLastUpdateAppUser(new AppUser());
        customer2.setName("Name");
        customer2.setNote("Note");
        customer2.setPhoto(new Image());
        customer2.setSurname("Doe");

        Image image2 = new Image();
        image2.setId(123L);
        image2.setOwner(customer2);
        image2.setUrl("https://example.org/example");

        Customer customer3 = new Customer();
        customer3.setCreationAppUser(appUser6);
        customer3.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer3.setEmail("jane.doe@example.org");
        customer3.setId(123L);
        customer3.setLastUpdateAppUser(appUser7);
        customer3.setName("Name");
        customer3.setNote("Note");
        customer3.setPhoto(image2);
        customer3.setSurname("Doe");

        Image image3 = new Image();
        image3.setId(123L);
        image3.setOwner(customer3);
        image3.setUrl("https://example.org/example");

        Customer customer4 = new Customer();
        customer4.setCreationAppUser(appUser4);
        customer4.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer4.setEmail("jane.doe@example.org");
        customer4.setId(123L);
        customer4.setLastUpdateAppUser(appUser5);
        customer4.setName("Name");
        customer4.setNote("Note");
        customer4.setPhoto(image3);
        customer4.setSurname("Doe");
        when(customerRepository.save((Customer) any())).thenReturn(customer4);
        when(customerRepository.findById((Long) any())).thenReturn(ofResult);

        AppUser appUser8 = new AppUser();
        appUser8.setEmail("jane.doe@example.org");
        appUser8.setId(123L);
        appUser8.setName("Name");
        appUser8.setPassword("iloveyou");
        appUser8.setRole(AppUserRole.USER);
        appUser8.setUsername("janedoe");
        when(appUserService.getAppUserByUsername((String) any())).thenReturn(appUser8);
        when(imageService.savePhoto((MultipartFile) any(), (Customer) any())).thenThrow(new IllegalStateException("foo"));
        assertThrows(IllegalStateException.class, () -> customerService.uploadNewPhoto(123L,
                new MockMultipartFile("Name", "AAAAAAAA".getBytes("UTF-8")), "janedoe"));
        verify(customerRepository).findById((Long) any());
        verify(imageService).savePhoto((MultipartFile) any(), (Customer) any());
    }

    /**
     * Method under test: {@link CustomerService#deleteCustomer(Long)}
     */
    @Test
    void testDeleteCustomer() {
        doNothing().when(customerRepository).deleteById((Long) any());
        when(customerRepository.existsById((Long) any())).thenReturn(true);
        customerService.deleteCustomer(123L);
        verify(customerRepository).existsById((Long) any());
        verify(customerRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link CustomerService#deleteCustomer(Long)}
     */
    @Test
    void testDeleteCustomer2() {
        doThrow(new IllegalStateException("foo")).when(customerRepository).deleteById((Long) any());
        when(customerRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(IllegalStateException.class, () -> customerService.deleteCustomer(123L));
        verify(customerRepository).existsById((Long) any());
        verify(customerRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link CustomerService#deleteCustomer(Long)}
     */
    @Test
    void testDeleteCustomer3() {
        doNothing().when(customerRepository).deleteById((Long) any());
        when(customerRepository.existsById((Long) any())).thenReturn(false);
        assertThrows(IllegalStateException.class, () -> customerService.deleteCustomer(123L));
        verify(customerRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link CustomerService#updateCustomer(Long, Customer, String)}
     */
    @Test
    void testUpdateCustomer() {
        doNothing().when(modelMapper).map((Object) any(), (Object) any());

        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");

        AppUser appUser1 = new AppUser();
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setId(123L);
        appUser1.setName("Name");
        appUser1.setPassword("iloveyou");
        appUser1.setRole(AppUserRole.USER);
        appUser1.setUsername("janedoe");

        AppUser appUser2 = new AppUser();
        appUser2.setEmail("jane.doe@example.org");
        appUser2.setId(123L);
        appUser2.setName("Name");
        appUser2.setPassword("iloveyou");
        appUser2.setRole(AppUserRole.USER);
        appUser2.setUsername("janedoe");

        AppUser appUser3 = new AppUser();
        appUser3.setEmail("jane.doe@example.org");
        appUser3.setId(123L);
        appUser3.setName("Name");
        appUser3.setPassword("iloveyou");
        appUser3.setRole(AppUserRole.USER);
        appUser3.setUsername("janedoe");

        Image image = new Image();
        image.setId(123L);
        image.setOwner(new Customer());
        image.setUrl("https://example.org/example");

        Customer customer = new Customer();
        customer.setCreationAppUser(appUser2);
        customer.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setLastUpdateAppUser(appUser3);
        customer.setName("Name");
        customer.setNote("Note");
        customer.setPhoto(image);
        customer.setSurname("Doe");

        Image image1 = new Image();
        image1.setId(123L);
        image1.setOwner(customer);
        image1.setUrl("https://example.org/example");

        Customer customer1 = new Customer();
        customer1.setCreationAppUser(appUser);
        customer1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setLastUpdateAppUser(appUser1);
        customer1.setName("Name");
        customer1.setNote("Note");
        customer1.setPhoto(image1);
        customer1.setSurname("Doe");
        Optional<Customer> ofResult = Optional.of(customer1);

        AppUser appUser4 = new AppUser();
        appUser4.setEmail("jane.doe@example.org");
        appUser4.setId(123L);
        appUser4.setName("Name");
        appUser4.setPassword("iloveyou");
        appUser4.setRole(AppUserRole.USER);
        appUser4.setUsername("janedoe");

        AppUser appUser5 = new AppUser();
        appUser5.setEmail("jane.doe@example.org");
        appUser5.setId(123L);
        appUser5.setName("Name");
        appUser5.setPassword("iloveyou");
        appUser5.setRole(AppUserRole.USER);
        appUser5.setUsername("janedoe");

        AppUser appUser6 = new AppUser();
        appUser6.setEmail("jane.doe@example.org");
        appUser6.setId(123L);
        appUser6.setName("Name");
        appUser6.setPassword("iloveyou");
        appUser6.setRole(AppUserRole.USER);
        appUser6.setUsername("janedoe");

        AppUser appUser7 = new AppUser();
        appUser7.setEmail("jane.doe@example.org");
        appUser7.setId(123L);
        appUser7.setName("Name");
        appUser7.setPassword("iloveyou");
        appUser7.setRole(AppUserRole.USER);
        appUser7.setUsername("janedoe");

        Customer customer2 = new Customer();
        customer2.setCreationAppUser(new AppUser());
        customer2.setDateOfBirth(null);
        customer2.setEmail("jane.doe@example.org");
        customer2.setId(123L);
        customer2.setLastUpdateAppUser(new AppUser());
        customer2.setName("Name");
        customer2.setNote("Note");
        customer2.setPhoto(new Image());
        customer2.setSurname("Doe");

        Image image2 = new Image();
        image2.setId(123L);
        image2.setOwner(customer2);
        image2.setUrl("https://example.org/example");

        Customer customer3 = new Customer();
        customer3.setCreationAppUser(appUser6);
        customer3.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer3.setEmail("jane.doe@example.org");
        customer3.setId(123L);
        customer3.setLastUpdateAppUser(appUser7);
        customer3.setName("Name");
        customer3.setNote("Note");
        customer3.setPhoto(image2);
        customer3.setSurname("Doe");

        Image image3 = new Image();
        image3.setId(123L);
        image3.setOwner(customer3);
        image3.setUrl("https://example.org/example");

        Customer customer4 = new Customer();
        customer4.setCreationAppUser(appUser4);
        customer4.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer4.setEmail("jane.doe@example.org");
        customer4.setId(123L);
        customer4.setLastUpdateAppUser(appUser5);
        customer4.setName("Name");
        customer4.setNote("Note");
        customer4.setPhoto(image3);
        customer4.setSurname("Doe");
        when(customerRepository.save((Customer) any())).thenReturn(customer4);
        when(customerRepository.findById((Long) any())).thenReturn(ofResult);

        AppUser appUser8 = new AppUser();
        appUser8.setEmail("jane.doe@example.org");
        appUser8.setId(123L);
        appUser8.setName("Name");
        appUser8.setPassword("iloveyou");
        appUser8.setRole(AppUserRole.USER);
        appUser8.setUsername("janedoe");
        when(appUserService.getAppUserByUsername((String) any())).thenReturn(appUser8);

        AppUser appUser9 = new AppUser();
        appUser9.setEmail("jane.doe@example.org");
        appUser9.setId(123L);
        appUser9.setName("Name");
        appUser9.setPassword("iloveyou");
        appUser9.setRole(AppUserRole.USER);
        appUser9.setUsername("janedoe");

        AppUser appUser10 = new AppUser();
        appUser10.setEmail("jane.doe@example.org");
        appUser10.setId(123L);
        appUser10.setName("Name");
        appUser10.setPassword("iloveyou");
        appUser10.setRole(AppUserRole.USER);
        appUser10.setUsername("janedoe");

        AppUser appUser11 = new AppUser();
        appUser11.setEmail("jane.doe@example.org");
        appUser11.setId(123L);
        appUser11.setName("Name");
        appUser11.setPassword("iloveyou");
        appUser11.setRole(AppUserRole.USER);
        appUser11.setUsername("janedoe");

        AppUser appUser12 = new AppUser();
        appUser12.setEmail("jane.doe@example.org");
        appUser12.setId(123L);
        appUser12.setName("Name");
        appUser12.setPassword("iloveyou");
        appUser12.setRole(AppUserRole.USER);
        appUser12.setUsername("janedoe");

        Image image4 = new Image();
        image4.setId(123L);
        image4.setOwner(new Customer());
        image4.setUrl("https://example.org/example");

        Customer customer5 = new Customer();
        customer5.setCreationAppUser(appUser11);
        customer5.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer5.setEmail("jane.doe@example.org");
        customer5.setId(123L);
        customer5.setLastUpdateAppUser(appUser12);
        customer5.setName("Name");
        customer5.setNote("Note");
        customer5.setPhoto(image4);
        customer5.setSurname("Doe");

        Image image5 = new Image();
        image5.setId(123L);
        image5.setOwner(customer5);
        image5.setUrl("https://example.org/example");

        Customer customer6 = new Customer();
        customer6.setCreationAppUser(appUser9);
        customer6.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer6.setEmail("jane.doe@example.org");
        customer6.setId(123L);
        customer6.setLastUpdateAppUser(appUser10);
        customer6.setName("Name");
        customer6.setNote("Note");
        customer6.setPhoto(image5);
        customer6.setSurname("Doe");
        customerService.updateCustomer(123L, customer6, "janedoe");
        verify(modelMapper).map((Object) any(), (Object) any());
        verify(customerRepository).save((Customer) any());
        verify(customerRepository).findById((Long) any());
        verify(appUserService).getAppUserByUsername((String) any());
    }

    /**
     * Method under test: {@link CustomerService#updateCustomer(Long, Customer, String)}
     */
    @Test
    void testUpdateCustomer2() {
        doNothing().when(modelMapper).map((Object) any(), (Object) any());

        AppUser appUser = new AppUser();
        appUser.setEmail("jane.doe@example.org");
        appUser.setId(123L);
        appUser.setName("Name");
        appUser.setPassword("iloveyou");
        appUser.setRole(AppUserRole.USER);
        appUser.setUsername("janedoe");

        AppUser appUser1 = new AppUser();
        appUser1.setEmail("jane.doe@example.org");
        appUser1.setId(123L);
        appUser1.setName("Name");
        appUser1.setPassword("iloveyou");
        appUser1.setRole(AppUserRole.USER);
        appUser1.setUsername("janedoe");

        AppUser appUser2 = new AppUser();
        appUser2.setEmail("jane.doe@example.org");
        appUser2.setId(123L);
        appUser2.setName("Name");
        appUser2.setPassword("iloveyou");
        appUser2.setRole(AppUserRole.USER);
        appUser2.setUsername("janedoe");

        AppUser appUser3 = new AppUser();
        appUser3.setEmail("jane.doe@example.org");
        appUser3.setId(123L);
        appUser3.setName("Name");
        appUser3.setPassword("iloveyou");
        appUser3.setRole(AppUserRole.USER);
        appUser3.setUsername("janedoe");

        Image image = new Image();
        image.setId(123L);
        image.setOwner(new Customer());
        image.setUrl("https://example.org/example");

        Customer customer = new Customer();
        customer.setCreationAppUser(appUser2);
        customer.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setLastUpdateAppUser(appUser3);
        customer.setName("Name");
        customer.setNote("Note");
        customer.setPhoto(image);
        customer.setSurname("Doe");

        Image image1 = new Image();
        image1.setId(123L);
        image1.setOwner(customer);
        image1.setUrl("https://example.org/example");

        Customer customer1 = new Customer();
        customer1.setCreationAppUser(appUser);
        customer1.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setLastUpdateAppUser(appUser1);
        customer1.setName("Name");
        customer1.setNote("Note");
        customer1.setPhoto(image1);
        customer1.setSurname("Doe");
        Optional<Customer> ofResult = Optional.of(customer1);

        AppUser appUser4 = new AppUser();
        appUser4.setEmail("jane.doe@example.org");
        appUser4.setId(123L);
        appUser4.setName("Name");
        appUser4.setPassword("iloveyou");
        appUser4.setRole(AppUserRole.USER);
        appUser4.setUsername("janedoe");

        AppUser appUser5 = new AppUser();
        appUser5.setEmail("jane.doe@example.org");
        appUser5.setId(123L);
        appUser5.setName("Name");
        appUser5.setPassword("iloveyou");
        appUser5.setRole(AppUserRole.USER);
        appUser5.setUsername("janedoe");

        AppUser appUser6 = new AppUser();
        appUser6.setEmail("jane.doe@example.org");
        appUser6.setId(123L);
        appUser6.setName("Name");
        appUser6.setPassword("iloveyou");
        appUser6.setRole(AppUserRole.USER);
        appUser6.setUsername("janedoe");

        AppUser appUser7 = new AppUser();
        appUser7.setEmail("jane.doe@example.org");
        appUser7.setId(123L);
        appUser7.setName("Name");
        appUser7.setPassword("iloveyou");
        appUser7.setRole(AppUserRole.USER);
        appUser7.setUsername("janedoe");

        Customer customer2 = new Customer();
        customer2.setCreationAppUser(new AppUser());
        customer2.setDateOfBirth(null);
        customer2.setEmail("jane.doe@example.org");
        customer2.setId(123L);
        customer2.setLastUpdateAppUser(new AppUser());
        customer2.setName("Name");
        customer2.setNote("Note");
        customer2.setPhoto(new Image());
        customer2.setSurname("Doe");

        Image image2 = new Image();
        image2.setId(123L);
        image2.setOwner(customer2);
        image2.setUrl("https://example.org/example");

        Customer customer3 = new Customer();
        customer3.setCreationAppUser(appUser6);
        customer3.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer3.setEmail("jane.doe@example.org");
        customer3.setId(123L);
        customer3.setLastUpdateAppUser(appUser7);
        customer3.setName("Name");
        customer3.setNote("Note");
        customer3.setPhoto(image2);
        customer3.setSurname("Doe");

        Image image3 = new Image();
        image3.setId(123L);
        image3.setOwner(customer3);
        image3.setUrl("https://example.org/example");

        Customer customer4 = new Customer();
        customer4.setCreationAppUser(appUser4);
        customer4.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer4.setEmail("jane.doe@example.org");
        customer4.setId(123L);
        customer4.setLastUpdateAppUser(appUser5);
        customer4.setName("Name");
        customer4.setNote("Note");
        customer4.setPhoto(image3);
        customer4.setSurname("Doe");
        when(customerRepository.save((Customer) any())).thenReturn(customer4);
        when(customerRepository.findById((Long) any())).thenReturn(ofResult);
        when(appUserService.getAppUserByUsername((String) any())).thenThrow(new IllegalStateException("foo"));

        AppUser appUser8 = new AppUser();
        appUser8.setEmail("jane.doe@example.org");
        appUser8.setId(123L);
        appUser8.setName("Name");
        appUser8.setPassword("iloveyou");
        appUser8.setRole(AppUserRole.USER);
        appUser8.setUsername("janedoe");

        AppUser appUser9 = new AppUser();
        appUser9.setEmail("jane.doe@example.org");
        appUser9.setId(123L);
        appUser9.setName("Name");
        appUser9.setPassword("iloveyou");
        appUser9.setRole(AppUserRole.USER);
        appUser9.setUsername("janedoe");

        AppUser appUser10 = new AppUser();
        appUser10.setEmail("jane.doe@example.org");
        appUser10.setId(123L);
        appUser10.setName("Name");
        appUser10.setPassword("iloveyou");
        appUser10.setRole(AppUserRole.USER);
        appUser10.setUsername("janedoe");

        AppUser appUser11 = new AppUser();
        appUser11.setEmail("jane.doe@example.org");
        appUser11.setId(123L);
        appUser11.setName("Name");
        appUser11.setPassword("iloveyou");
        appUser11.setRole(AppUserRole.USER);
        appUser11.setUsername("janedoe");

        Image image4 = new Image();
        image4.setId(123L);
        image4.setOwner(new Customer());
        image4.setUrl("https://example.org/example");

        Customer customer5 = new Customer();
        customer5.setCreationAppUser(appUser10);
        customer5.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer5.setEmail("jane.doe@example.org");
        customer5.setId(123L);
        customer5.setLastUpdateAppUser(appUser11);
        customer5.setName("Name");
        customer5.setNote("Note");
        customer5.setPhoto(image4);
        customer5.setSurname("Doe");

        Image image5 = new Image();
        image5.setId(123L);
        image5.setOwner(customer5);
        image5.setUrl("https://example.org/example");

        Customer customer6 = new Customer();
        customer6.setCreationAppUser(appUser8);
        customer6.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer6.setEmail("jane.doe@example.org");
        customer6.setId(123L);
        customer6.setLastUpdateAppUser(appUser9);
        customer6.setName("Name");
        customer6.setNote("Note");
        customer6.setPhoto(image5);
        customer6.setSurname("Doe");
        assertThrows(IllegalStateException.class, () -> customerService.updateCustomer(123L, customer6, "janedoe"));
        verify(modelMapper).map((Object) any(), (Object) any());
        verify(customerRepository).findById((Long) any());
        verify(appUserService).getAppUserByUsername((String) any());
    }
}

