package br.com.workshop.framework.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOutDTO {

    private String id;
    private String name;
    private LocalDate birthdate;
    private String documentNumber;
    private String documentType;
    private LocalDate inactive;

}
