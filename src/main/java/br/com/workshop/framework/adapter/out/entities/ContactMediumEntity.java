package br.com.workshop.framework.adapter.out.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactMediumEntity implements Serializable {

    private String emailAddress;
    private String phoneNumber;
    private Boolean preferred;
    private LocalDateTime creation;
    private LocalDateTime lastUpdate;

}
