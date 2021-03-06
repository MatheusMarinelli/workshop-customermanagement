package br.com.workshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer id;
    private String name;
    private LocalDate birthdate;
    private String documentNumber;
    private String documentType;
    private LocalDate inactive;
    private List<Address> addresses;
    private List<ContactMedium> contacts;
}
