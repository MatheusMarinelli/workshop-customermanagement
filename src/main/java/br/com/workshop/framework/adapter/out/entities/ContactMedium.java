package br.com.workshop.framework.adapter.out.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contact_mediums")
public class ContactMedium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String emailAddress;
    private String phoneNumber;
    private Boolean preferred;
    private LocalDateTime creation;
    private LocalDateTime lastUpdate;

    @ManyToOne
    private Customer customer;

}
