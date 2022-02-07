package br.com.workshop.framework.adapter.out.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Customer customer;

}
