package br.com.workshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String name;
    private LocalDate birthdate;
    private String documentNumber;
    private String documentType;
}
