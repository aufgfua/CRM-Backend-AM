package com.guxo.crmbackend.appuser;

import com.guxo.crmbackend.customer.Customer;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AppUserService{

    // Autowired - Config -> nullableModelMapper()
    @Qualifier("nullableModelMapper")
    private final ModelMapper nullableModelMapper; // skips null fields (used for update method)

    // Autowired - AppUserRepository
    private final AppUserRepository appUserRepository;

    private final PasswordEncoder passwordEncoder;


    // getAppUsers :    -> List<AppUser>
    // returns List of all appUsers
    public List<AppUser> getAppUsers(){
        return appUserRepository.findAll();
    }



    // getAppUser :  Long  -> AppUser
    // returns appUser by ID
    public AppUser getAppUser(Long appUserId) {
        Optional<AppUser> appUser = appUserRepository.findById(appUserId); // gets appUser from id
        if (appUser.isEmpty()) {
            return null;
        }
        return appUser.get(); // return wanted appUser
    }


    // getAppUserByUsername :  String  -> Customer
    // returns appUser by Email
    public AppUser getAppUserByUsername(String appUserUsername) {
        Optional<AppUser> appUser = appUserRepository.findByUsername(appUserUsername); // gets appUser from username
        if (appUser.isEmpty()) {
            return null;
        }
        return appUser.get();
    }





    // addNewAppUser : AppUser -> AppUser
    // Creates appUser in DB and then returns the appUser
    public AppUser addNewAppUser(AppUser appUser){
        boolean appUserExists = appUserRepository.existsById(appUser.getId()); // Search for appUser ID
        if(appUserExists) { // check if appUser ID was already used
            throw new IllegalStateException("AppUser ID already created");
        }
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword())); // encode user password
        appUserRepository.save(appUser); // create appUser
        return appUser; // Return AppUser to the client (possibly different from given DTO)
    }


    // Get list of available user roles
    public List<String> getExistingRoles(){
        AppUserRole[] roles = AppUserRole.values();
        String[] rolesNames = Arrays.stream(roles).map(role -> role.name()).toArray(String[]::new);
        List<String> existingRoles = List.of(rolesNames);
        return existingRoles;
    }



    // deleteAppUser : Long -> Void
    // Deletes appUser with given ID
    public void deleteAppUser(Long appUserId){
        boolean appUserExists = appUserRepository.existsById(appUserId); // Search for appUser ID
        if(!appUserExists) { // check if appUser ID exists
            throw new IllegalStateException("No appUser has the given ID");
        }
        appUserRepository.deleteById(appUserId); // delete appUser
    }



    public void updateAppUser(Long appUserId, AppUser newAppUserValues){
        AppUser appUser = getAppUser(appUserId);

        if(appUser == null) {
            throw new IllegalStateException("User ID does not exist");
        }

        nullableModelMapper.map(newAppUserValues, appUser); // map not-null values from newAppUserValues to the appUser object

        appUserRepository.save(appUser); // save appUser object with updated fields

    }


}
