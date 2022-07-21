package com.guxo.crmbackend.files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import com.guxo.crmbackend.appuser.AppUser;
import com.guxo.crmbackend.appuser.AppUserRole;
import com.guxo.crmbackend.customer.Customer;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ImageTest {
    /**
     * Method under test: {@link Image#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Image()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Image#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Image image = new Image();

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

        Image image1 = new Image();
        image1.setId(123L);
        image1.setOwner(new Customer());
        image1.setUrl("https://example.org/example");

        Customer customer = new Customer();
        customer.setCreationAppUser(appUser2);
        customer.setDateOfBirth(LocalDate.ofEpochDay(3L));
        customer.setEmail("jane.doe@example.org");
        customer.setId(123L);
        customer.setLastUpdateAppUser(appUser3);
        customer.setName("Name");
        customer.setNote("Note");
        customer.setPhoto(image1);
        customer.setSurname("Doe");

        Image image2 = new Image();
        image2.setId(123L);
        image2.setOwner(customer);
        image2.setUrl("https://example.org/example");

        Customer customer1 = new Customer();
        customer1.setCreationAppUser(appUser);
        customer1.setDateOfBirth(LocalDate.ofEpochDay(3L));
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(123L);
        customer1.setLastUpdateAppUser(appUser1);
        customer1.setName("Name");
        customer1.setNote("Note");
        customer1.setPhoto(image2);
        customer1.setSurname("Doe");

        Image image3 = new Image();
        image3.setId(123L);
        image3.setOwner(customer1);
        image3.setUrl("https://example.org/example");
        assertTrue(image.canEqual(image3));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Image#Image()}
     *   <li>{@link Image#setId(Long)}
     *   <li>{@link Image#setOwner(Customer)}
     *   <li>{@link Image#setUrl(String)}
     *   <li>{@link Image#toString()}
     *   <li>{@link Image#getId()}
     *   <li>{@link Image#getOwner()}
     *   <li>{@link Image#getUrl()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Image actualImage = new Image();
        actualImage.setId(123L);
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
        actualImage.setOwner(customer1);
        actualImage.setUrl("https://example.org/example");
        String actualToStringResult = actualImage.toString();
        assertEquals(123L, actualImage.getId().longValue());
        Customer owner = actualImage.getOwner();
        Image photo = owner.getPhoto();
        assertEquals(123L, photo.getId().longValue());
        Customer owner1 = photo.getOwner();
        assertEquals(123L, owner1.getPhoto().getId().longValue());
        assertSame(customer1, owner);
        assertSame(customer, owner1);
        assertEquals("https://example.org/example", actualImage.getUrl());
        assertEquals("https://example.org/example", photo.getUrl());
        assertEquals("Image(id=123, url=https://example.org/example, owner=Customer(id=123, name=Name, surname=Doe,"
                + " email=jane.doe@example.org, dateOfBirth=1970-01-02, note=Note, photo=Image(id=123, url=https://example"
                + ".org/example, owner=Customer(id=123, name=Name, surname=Doe, email=jane.doe@example.org, dateOfBirth"
                + "=1970-01-02, note=Note, photo=Image(id=123, url=https://example.org/example, owner=Customer(id=null,"
                + " name=null, surname=null, email=null, dateOfBirth=null, note=null, photo=null, creationAppUser=null,"
                + " lastUpdateAppUser=null)), creationAppUser=AppUser(id=123, name=Name, email=jane.doe@example.org,"
                + " username=janedoe, password=iloveyou, role=USER), lastUpdateAppUser=AppUser(id=123, name=Name,"
                + " email=jane.doe@example.org, username=janedoe, password=iloveyou, role=USER))), creationAppUser=AppUser"
                + "(id=123, name=Name, email=jane.doe@example.org, username=janedoe, password=iloveyou, role=USER),"
                + " lastUpdateAppUser=AppUser(id=123, name=Name, email=jane.doe@example.org, username=janedoe,"
                + " password=iloveyou, role=USER)))", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Image#Image(Long, String, Customer)}
     *   <li>{@link Image#Image()}
     *   <li>{@link Image#setId(Long)}
     *   <li>{@link Image#setOwner(Customer)}
     *   <li>{@link Image#setUrl(String)}
     *   <li>{@link Image#toString()}
     *   <li>{@link Image#getId()}
     *   <li>{@link Image#getOwner()}
     *   <li>{@link Image#getUrl()}
     * </ul>
     */
    @Test
    void testConstructor2() {
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
        Image actualImage = new Image(123L, "https://example.org/example", customer1);
        actualImage.setId(123L);
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
        Customer customer2 = new Customer();
        customer2.setCreationAppUser(appUser6);
        customer2.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer2.setEmail("jane.doe@example.org");
        customer2.setId(123L);
        customer2.setLastUpdateAppUser(appUser7);
        customer2.setName("Name");
        customer2.setNote("Note");
        customer2.setPhoto(image2);
        customer2.setSurname("Doe");
        Image image3 = new Image();
        image3.setId(123L);
        image3.setOwner(customer2);
        image3.setUrl("https://example.org/example");
        Customer customer3 = new Customer();
        customer3.setCreationAppUser(appUser4);
        customer3.setDateOfBirth(LocalDate.ofEpochDay(1L));
        customer3.setEmail("jane.doe@example.org");
        customer3.setId(123L);
        customer3.setLastUpdateAppUser(appUser5);
        customer3.setName("Name");
        customer3.setNote("Note");
        customer3.setPhoto(image3);
        customer3.setSurname("Doe");
        actualImage.setOwner(customer3);
        actualImage.setUrl("https://example.org/example");
        String actualToStringResult = actualImage.toString();
        assertEquals(123L, actualImage.getId().longValue());
        Customer owner = actualImage.getOwner();
        Image photo = owner.getPhoto();
        assertEquals(123L, photo.getId().longValue());
        Customer owner1 = photo.getOwner();
        assertEquals(123L, owner1.getPhoto().getId().longValue());
        assertSame(customer3, owner);
        assertEquals(customer1, owner);
        assertSame(customer2, owner1);
        assertEquals(customer, owner1);
        assertEquals("https://example.org/example", actualImage.getUrl());
        assertEquals("https://example.org/example", photo.getUrl());
        assertEquals("Image(id=123, url=https://example.org/example, owner=Customer(id=123, name=Name, surname=Doe,"
                + " email=jane.doe@example.org, dateOfBirth=1970-01-02, note=Note, photo=Image(id=123, url=https://example"
                + ".org/example, owner=Customer(id=123, name=Name, surname=Doe, email=jane.doe@example.org, dateOfBirth"
                + "=1970-01-02, note=Note, photo=Image(id=123, url=https://example.org/example, owner=Customer(id=null,"
                + " name=null, surname=null, email=null, dateOfBirth=null, note=null, photo=null, creationAppUser=null,"
                + " lastUpdateAppUser=null)), creationAppUser=AppUser(id=123, name=Name, email=jane.doe@example.org,"
                + " username=janedoe, password=iloveyou, role=USER), lastUpdateAppUser=AppUser(id=123, name=Name,"
                + " email=jane.doe@example.org, username=janedoe, password=iloveyou, role=USER))), creationAppUser=AppUser"
                + "(id=123, name=Name, email=jane.doe@example.org, username=janedoe, password=iloveyou, role=USER),"
                + " lastUpdateAppUser=AppUser(id=123, name=Name, email=jane.doe@example.org, username=janedoe,"
                + " password=iloveyou, role=USER)))", actualToStringResult);
    }

    /**
     * Method under test: {@link Image#equals(Object)}
     */
    @Test
    void testEquals() {
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
        assertNotEquals(image2, null);
    }

    /**
     * Method under test: {@link Image#equals(Object)}
     */
    @Test
    void testEquals2() {
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
        assertNotEquals(image2, "Different type to Image");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Image#equals(Object)}
     *   <li>{@link Image#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
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
        assertEquals(image2, image2);
        int expectedHashCodeResult = image2.hashCode();
        assertEquals(expectedHashCodeResult, image2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Image#equals(Object)}
     *   <li>{@link Image#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
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

        Image image5 = new Image();
        image5.setId(123L);
        image5.setOwner(customer3);
        image5.setUrl("https://example.org/example");
        assertEquals(image2, image5);
        int expectedHashCodeResult = image2.hashCode();
        assertEquals(expectedHashCodeResult, image5.hashCode());
    }

    /**
     * Method under test: {@link Image#equals(Object)}
     */
    @Test
    void testEquals5() {
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
        image2.setId(1L);
        image2.setOwner(customer1);
        image2.setUrl("https://example.org/example");

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

        Image image5 = new Image();
        image5.setId(123L);
        image5.setOwner(customer3);
        image5.setUrl("https://example.org/example");
        assertNotEquals(image2, image5);
    }

    /**
     * Method under test: {@link Image#equals(Object)}
     */
    @Test
    void testEquals6() {
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
        image2.setId(null);
        image2.setOwner(customer1);
        image2.setUrl("https://example.org/example");

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

        Image image5 = new Image();
        image5.setId(123L);
        image5.setOwner(customer3);
        image5.setUrl("https://example.org/example");
        assertNotEquals(image2, image5);
    }

    /**
     * Method under test: {@link Image#equals(Object)}
     */
    @Test
    void testEquals7() {
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
        Customer customer1 = mock(Customer.class);
        doNothing().when(customer1).setCreationAppUser((AppUser) any());
        doNothing().when(customer1).setDateOfBirth((LocalDate) any());
        doNothing().when(customer1).setEmail((String) any());
        doNothing().when(customer1).setId((Long) any());
        doNothing().when(customer1).setLastUpdateAppUser((AppUser) any());
        doNothing().when(customer1).setName((String) any());
        doNothing().when(customer1).setNote((String) any());
        doNothing().when(customer1).setPhoto((Image) any());
        doNothing().when(customer1).setSurname((String) any());
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

        Image image5 = new Image();
        image5.setId(123L);
        image5.setOwner(customer3);
        image5.setUrl("https://example.org/example");
        assertNotEquals(image2, image5);
    }

    /**
     * Method under test: {@link Image#equals(Object)}
     */
    @Test
    void testEquals8() {
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
        Customer customer1 = mock(Customer.class);
        doNothing().when(customer1).setCreationAppUser((AppUser) any());
        doNothing().when(customer1).setDateOfBirth((LocalDate) any());
        doNothing().when(customer1).setEmail((String) any());
        doNothing().when(customer1).setId((Long) any());
        doNothing().when(customer1).setLastUpdateAppUser((AppUser) any());
        doNothing().when(customer1).setName((String) any());
        doNothing().when(customer1).setNote((String) any());
        doNothing().when(customer1).setPhoto((Image) any());
        doNothing().when(customer1).setSurname((String) any());
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
        image2.setUrl("Url");

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

        Image image5 = new Image();
        image5.setId(123L);
        image5.setOwner(customer3);
        image5.setUrl("https://example.org/example");
        assertNotEquals(image2, image5);
    }

    /**
     * Method under test: {@link Image#equals(Object)}
     */
    @Test
    void testEquals9() {
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
        Customer customer1 = mock(Customer.class);
        doNothing().when(customer1).setCreationAppUser((AppUser) any());
        doNothing().when(customer1).setDateOfBirth((LocalDate) any());
        doNothing().when(customer1).setEmail((String) any());
        doNothing().when(customer1).setId((Long) any());
        doNothing().when(customer1).setLastUpdateAppUser((AppUser) any());
        doNothing().when(customer1).setName((String) any());
        doNothing().when(customer1).setNote((String) any());
        doNothing().when(customer1).setPhoto((Image) any());
        doNothing().when(customer1).setSurname((String) any());
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
        image2.setUrl(null);

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

        Image image5 = new Image();
        image5.setId(123L);
        image5.setOwner(customer3);
        image5.setUrl("https://example.org/example");
        assertNotEquals(image2, image5);
    }
}

