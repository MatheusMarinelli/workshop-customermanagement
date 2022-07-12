package br.com.workshop.framework.adapter.out.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity implements Serializable {

    private String city;
    private String country;
    private String state;
    private String neighborhood;
    private String street;
    private String streetNumber;
    private LocalDateTime creation;
    private LocalDateTime lastUpdate;

}
