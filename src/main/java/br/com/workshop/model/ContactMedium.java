package br.com.workshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactMedium {
    private String emailAddress;
    private String phoneNumber;
    private Boolean preferred;
}
