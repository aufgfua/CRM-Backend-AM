package com.guxo.crmbackend.appuser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
//@DynamicUpdate
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;

    private String username;
    private String password;

    private AppUserRole role;


    public AppUser(String name, String email, String username, String password, AppUserRole role) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
