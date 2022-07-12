package br.com.workshop.framework.adapter.out.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity implements Serializable {

    @Id
    private String id;
    private String name;
    private LocalDate birthdate;
    private String documentNumber;
    private String documentType;
    private LocalDateTime creation;
    private LocalDateTime lastUpdate;
    private LocalDate inactive;
    private List<AddressEntity> addresses;
    private List<ContactMediumEntity> contacts;

}
