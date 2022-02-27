package br.com.workshop.framework.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    BAD_REQUEST("Client specified an invalid argument, request body o query param"),
    RESOURCE_NOT_FOUND("A specified resource is not found");

    private String message;
}
