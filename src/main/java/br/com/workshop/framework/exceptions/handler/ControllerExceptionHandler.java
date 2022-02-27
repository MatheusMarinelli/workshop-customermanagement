package br.com.workshop.framework.exceptions.handler;

import br.com.workshop.framework.exceptions.CustomerNotFoundException;
import br.com.workshop.framework.exceptions.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorPattern> customerNotFound() {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorPattern err = new ErrorPattern(Instant.now(),status.value(), ErrorMessage.RESOURCE_NOT_FOUND.getMessage(),status.name());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorPattern> methodNotFound() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorPattern err = new ErrorPattern(Instant.now(),status.value(), ErrorMessage.BAD_REQUEST.getMessage(), status.name());
        return ResponseEntity.status(status).body(err);
    }

}
