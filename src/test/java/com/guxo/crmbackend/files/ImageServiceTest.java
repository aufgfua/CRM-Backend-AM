package com.guxo.crmbackend.files;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.guxo.crmbackend.appuser.AppUser;
import com.guxo.crmbackend.appuser.AppUserRole;
import com.guxo.crmbackend.customer.Customer;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {ImageService.class, String.class})
@ExtendWith(SpringExtension.class)
class ImageServiceTest {
    @MockBean
    private FilesService filesService;

    @MockBean
    private ImageRepository imageRepository;

    @Autowired
    private ImageService imageService;

    /**
     * Method under test: {@link ImageService#savePhoto(MultipartFile, Customer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSavePhoto() throws UnsupportedEncodingException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.split(String)" because "contentType" is null
        //       at com.guxo.crmbackend.files.ImageService.savePhoto(ImageService.java:35)
        //   In order to prevent savePhoto(MultipartFile, Customer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   savePhoto(MultipartFile, Customer).
        //   See https://diff.blue/R013 to resolve this issue.

        MockMultipartFile imageFile = new MockMultipartFile("Name", "AAAAAAAA".getBytes("UTF-8"));

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
        imageService.savePhoto(imageFile, customer1);
    }

    /**
     * Method under test: {@link ImageService#savePhoto(MultipartFile, Customer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSavePhoto2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.multipart.MultipartFile.getContentType()" because "imageFile" is null
        //       at com.guxo.crmbackend.files.ImageService.savePhoto(ImageService.java:34)
        //   In order to prevent savePhoto(MultipartFile, Customer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   savePhoto(MultipartFile, Customer).
        //   See https://diff.blue/R013 to resolve this issue.

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
        imageService.savePhoto(null, customer1);
    }

    /**
     * Method under test: {@link ImageService#savePhoto(MultipartFile, Customer)}
     */
    @Test
    void testSavePhoto3() throws IOException {
        MockMultipartFile imageFile = new MockMultipartFile("/", "foo.txt", "text/plain",
                new ByteArrayInputStream("AAAAAAAA".getBytes("UTF-8")));

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
        assertThrows(IllegalStateException.class, () -> imageService.savePhoto(imageFile, customer1));
    }

    /**
     * Method under test: {@link ImageService#savePhoto(MultipartFile, Customer)}
     */
    @Test
    void testSavePhoto4() {
        MockMultipartFile mockMultipartFile = mock(MockMultipartFile.class);
        when(mockMultipartFile.getContentType()).thenReturn("text/plain");

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
        assertThrows(IllegalStateException.class, () -> imageService.savePhoto(mockMultipartFile, customer1));
        verify(mockMultipartFile).getContentType();
    }

    /**
     * Method under test: {@link ImageService#savePhoto(MultipartFile, Customer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSavePhoto5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at com.guxo.crmbackend.files.ImageService.savePhoto(ImageService.java:35)
        //   In order to prevent savePhoto(MultipartFile, Customer)
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   savePhoto(MultipartFile, Customer).
        //   See https://diff.blue/R013 to resolve this issue.

        MockMultipartFile mockMultipartFile = mock(MockMultipartFile.class);
        when(mockMultipartFile.getContentType()).thenReturn("/");

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
        imageService.savePhoto(mockMultipartFile, customer1);
    }

    /**
     * Method under test: {@link ImageService#savePhoto(MultipartFile, Customer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSavePhoto6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Long.toString()" because the return value of "com.guxo.crmbackend.files.Image.getId()" is null
        //       at com.guxo.crmbackend.files.ImageService.savePhoto(ImageService.java:44)
        //   In order to prevent savePhoto(MultipartFile, Customer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   savePhoto(MultipartFile, Customer).
        //   See https://diff.blue/R013 to resolve this issue.

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

        Image image2 = new Image();
        image2.setId(123L);
        image2.setOwner(customer1);
        image2.setUrl("https://example.org/example");
        when(imageRepository.save((Image) any())).thenReturn(image2);
        MockMultipartFile mockMultipartFile = mock(MockMultipartFile.class);
        when(mockMultipartFile.getContentType()).thenReturn("image");

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

        Image image3 = new Image();
        image3.setId(123L);
        image3.setOwner(new Customer());
        image3.setUrl("https://example.org/example");

        Customer customer2 = new Customer();
        customer2.setCreationAppUser(appUser6);
        customer2.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer2.setEmail("jane.doe@example.org");
        customer2.setId(123L);
        customer2.setLastUpdateAppUser(appUser7);
        customer2.setName("Name");
        customer2.setNote("Note");
        customer2.setPhoto(image3);
        customer2.setSurname("Doe");

        Image image4 = new Image();
        image4.setId(123L);
        image4.setOwner(customer2);
        image4.setUrl("https://example.org/example");

        Customer customer3 = new Customer();
        customer3.setCreationAppUser(appUser4);
        customer3.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer3.setEmail("jane.doe@example.org");
        customer3.setId(123L);
        customer3.setLastUpdateAppUser(appUser5);
        customer3.setName("Name");
        customer3.setNote("Note");
        customer3.setPhoto(image4);
        customer3.setSurname("Doe");
        imageService.savePhoto(mockMultipartFile, customer3);
    }

    /**
     * Method under test: {@link ImageService#savePhoto(MultipartFile, Customer)}
     */
    @Test
    void testSavePhoto7() {
        when(imageRepository.save((Image) any())).thenThrow(new IllegalStateException("/"));
        MockMultipartFile mockMultipartFile = mock(MockMultipartFile.class);
        when(mockMultipartFile.getContentType()).thenReturn("image");

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
        assertThrows(IllegalStateException.class, () -> imageService.savePhoto(mockMultipartFile, customer1));
        verify(imageRepository).save((Image) any());
        verify(mockMultipartFile).getContentType();
    }
}

