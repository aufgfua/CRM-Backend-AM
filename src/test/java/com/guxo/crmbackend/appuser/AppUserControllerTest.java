package com.guxo.crmbackend.appuser;

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

@ContextConfiguration(classes = {AppUserController.class})
@ExtendWith(SpringExtension.class)
class AppUserControllerTest {
    @Autowired
    private AppUserController appUserController;

    @MockBean
    private AppUserService appUserService;

    @MockBean
    private ModelMapper modelMapper;

    /**
     * Method under test: {@link AppUserController#addNewAppUser(AppUserDTO)}
     */
    @Test
    void testAddNewAppUser() throws Exception {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(appUserDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(appUserController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link AppUserController#deleteUser(Long)}
     */
    @Test
    void testDeleteUser() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/{appUserId}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(appUserController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link AppUserController#getExistingRoles()}
     */
    @Test
    void testGetExistingRoles() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/roles");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(appUserController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link AppUserController#getUser(Long)}
     */
    @Test
    void testGetUser() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{appUserId}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(appUserController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link AppUserController#getUserByUsername(String)}
     */
    @Test
    void testGetUserByUsername() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getByUsername/{appUserUsername}",
                "janedoe");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(appUserController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link AppUserController#getUsers()}
     */
    @Test
    void testGetUsers() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(appUserController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link AppUserController#updateUser(Long, AppUserDTO)}
     */
    @Test
    void testUpdateUser() throws Exception {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmail("jane.doe@example.org");
        appUserDTO.setId(123L);
        appUserDTO.setName("Name");
        appUserDTO.setPassword("iloveyou");
        appUserDTO.setRole(AppUserRole.USER);
        appUserDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(appUserDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/{appUserId}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(appUserController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

