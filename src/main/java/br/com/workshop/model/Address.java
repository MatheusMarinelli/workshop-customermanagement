package br.com.workshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String city;
    private String country;
    private String state;
    private String neighborhood;
    private String street;
    private String streetNumber;
}
