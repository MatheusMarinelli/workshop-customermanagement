package br.com.workshop.framework.exceptions.handler;

import br.com.workshop.framework.exceptions.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorPattern> customerNotFound(CustomerNotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorPattern err = new ErrorPattern(Instant.now(),status.value(), exception.getMessage(),status.name());
        return ResponseEntity.status(status).body(err);
    }

}
