package com.guxo.crmbackend.appuser;

import com.guxo.crmbackend.exceptions.AppUserNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/user")
public class AppUserController {

    // Autowired - Config -> nullableModelMapper()
    @Qualifier("nullableModelMapper")
    private final ModelMapper nullableModelMapper; // configured to skip null fields (used for DTO -> AppUser mapping)

    // Autowired - Config -> modelMapper()
    @Qualifier("modelMapper")
    private final ModelMapper modelMapper; // configured to try to convert all fields (used for DTO -> AppUser mapping)


    // Autowired - AppUserService.class
    private final AppUserService appUserService; // Handles CRUD business logic



    // GET /api/user
    // Return all appUsers
    @GetMapping
    public List<AppUser> getUsers(){
        return appUserService.getAppUsers();
    }


    // GET /api/user/{id}
    // Get appUser by id
    @GetMapping(path = "{customerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AppUser getUser(@PathVariable Long customerId) {
        AppUser appUser = appUserService.getAppUser(customerId);
        if(appUser == null){
            throw new AppUserNotFoundException();
        }
        return appUser;
    }



    // POST /api/user
    // Create new appUser
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppUser addNewAppUser(@RequestBody AppUserDTO appUserDto){
        AppUser appUser = convertDtoToEntity(appUserDto);
        return appUserService.addNewAppUser(appUser);
    }



    // DELETE /api/user/{id}
    // Delete appUser by id
    @DeleteMapping(path = "{appUserId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long appUserId) {
        appUserService.deleteAppUser(appUserId);
    }



    // PUT /api/user/{id}
    // Update appUser by id
    @PutMapping(path = "{appUserId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable Long appUserId, @RequestBody AppUserDTO appUserDto){

        boolean idsMatch = Objects.equals(appUserId, appUserDto.getId());
        if(!idsMatch) {
            throw new IllegalArgumentException("IDs don't match");
        }

        AppUser appUser = convertPartialDtoToEntity(appUserDto);
        appUserService.updateAppUser(appUserId, appUser);
    }


    // Receives DTO and convert to Entity - skips null fields
    private AppUser convertPartialDtoToEntity(AppUserDTO appUserDTO){
        AppUser appUser = nullableModelMapper.map(appUserDTO, AppUser.class);
        return appUser;
    }


    // Receives DTO and convert to Entity - Tries to convert every field
    private AppUser convertDtoToEntity(AppUserDTO appUserDTO){
        AppUser appUser = modelMapper.map(appUserDTO, AppUser.class);
        return appUser;
    }




}
