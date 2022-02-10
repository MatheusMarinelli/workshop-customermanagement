package br.com.workshop.framework.exceptions.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorPattern {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;

}
