package com.guxo.crm_backend.customer;

import com.sun.istack.NotNull;
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
