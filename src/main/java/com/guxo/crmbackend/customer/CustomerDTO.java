package com.guxo.crmbackend.customer;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDTO {

    // Required
    private Long id;
    // Required
    private String name;
    // Required
    private String surname;

    private String email;
    private LocalDate dateOfBirth;
    private String note;

}
