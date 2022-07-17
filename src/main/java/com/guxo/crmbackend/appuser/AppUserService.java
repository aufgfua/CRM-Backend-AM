package com.guxo.crmbackend.appuser;

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
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AppUserService implements UserDetailsService {

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



    // getAppUsers :  Long  -> AppUser
    // returns appUser by ID
    public AppUser getAppUser(Long appUserId) {
        Optional<AppUser> appUser = appUserRepository.findById(appUserId); // gets appUser from id
        if (appUser.isEmpty()) {
            return null;
        }
        return appUser.get(); // return wanted appUser
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
        Optional<AppUser> existingAppUser = appUserRepository.findById(appUserId);
        if(existingAppUser.isEmpty()) { // check if there is a appUser with the given ID
            throw new IllegalStateException("AppUser ID does not exist");
        }

        AppUser appUser = existingAppUser.get(); // gets appUser from Optional

        nullableModelMapper.map(newAppUserValues, appUser); // map not-null values from newAppUserValues to the appUser object

        appUserRepository.save(appUser); // save appUser object with updated fields

    }



    // used for WebSecurityConfig - config
    // receives String for username and returns a new SpringSecurity User -> (username, password, roles).
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUserSearch = appUserRepository.findByUsername(username); // finds AppUser by username
        if(appUserSearch.isEmpty()) {
            throw new UsernameNotFoundException("Username not found");
        }
        AppUser appUser = appUserSearch.get(); // retrieves AppUser from Optional<AppUser>
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(appUser.getRole().name())); // create SimpleGrantedAuthority from AppUser.Role
        User springSecurityUser = new User(appUser.getUsername(), appUser.getPassword(), authorities); // create SpringSecurity User (username, password, authorities)
        return springSecurityUser;
    }

}
