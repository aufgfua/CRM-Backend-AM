package com.guxo.crm_backend.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
public class Customer {
    // TODO reference to User who created
    // TODO customer photo

    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;


}
