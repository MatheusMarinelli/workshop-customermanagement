package br.com.workshop.framework.adapter.out.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private LocalDate birthdate;
    private String documentNumber;
    private String documentType;
    private LocalDateTime creation;
    private LocalDateTime lastUpdate;
    private LocalDate inactive;

    @OneToMany(mappedBy = "customer")
    private List<AddressEntity> addressEntities;

    @OneToMany(mappedBy = "customer")
    private List<ContactMediumEntity> contacts;

}
