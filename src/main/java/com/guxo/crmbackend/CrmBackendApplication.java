package com.guxo.crmbackend;

import com.guxo.crmbackend.appuser.AppUser;
import com.guxo.crmbackend.appuser.AppUserRole;
import com.guxo.crmbackend.appuser.AppUserService;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CrmBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmBackendApplication.class, args);
	}

	@Value("${base-admin-password}")
	private String baseAdminPassword;


	@Value("${jwt-encryption-secret}")
	private String jwtSecret;


	@Bean
	CommandLineRunner run(AppUserService appUserService) {
		return args -> {
			String baseUserPassword = baseAdminPassword;
			try {
				AppUser appUserAdmin = new AppUser(0L, "admin", "augustofalcaoflach@gmail.com", "admin", baseUserPassword, AppUserRole.ADMIN);
				appUserService.addNewAppUser(appUserAdmin);
				AppUser appNormalUser = new AppUser(0L, "Normal User", "aufgfua@gmail.com", "user", "1234", AppUserRole.USER);
				appUserService.addNewAppUser(appNormalUser);
			} catch(Exception e) {
				// usuario já existe
			}
		};
	}


	@Bean("jwtSecret")
	String getJwtSecret(){
		return jwtSecret;
	}



	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	// Model Mapper that skips setting null values
	@Bean(name="nullableModelMapper")
	public ModelMapper nullableModelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		return modelMapper;
	}


	// Model Mapper that sets all fields
	@Bean(name="modelMapper")
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

}