package br.com.workshop.framework.adapter.out.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String city;
    private String country;
    private String state;
    private String neighborhood;
    private String street;
    private String streetNumber;
    private LocalDateTime creation;
    private LocalDateTime lastUpdate;

    @ManyToOne
    private CustomerEntity customer;

}
