package com.dfesh.co.thetartaros.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProductAlreadyExistsException extends ApiException {

    public ProductAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }

    public ProductAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
