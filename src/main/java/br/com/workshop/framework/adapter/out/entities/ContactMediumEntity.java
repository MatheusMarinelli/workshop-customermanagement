package br.com.workshop.framework.adapter.out.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contact_mediums")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactMediumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String emailAddress;
    private String phoneNumber;
    private Boolean preferred;
    private LocalDateTime creation;
    private LocalDateTime lastUpdate;

    @ManyToOne
    private CustomerEntity customer;

}
