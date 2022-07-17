package com.guxo.crmbackend.appuser;

import lombok.Data;

@Data
public class AppUserDTO {

    private Long id;

    private String name;
    private String email;

    private String username;
    private String password;

    private AppUserRole role;

}
