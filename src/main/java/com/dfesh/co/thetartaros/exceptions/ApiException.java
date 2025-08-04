package com.dfesh.co.thetartaros.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {

    private final HttpStatus httpStatus;

    /**
     * Instantiates a new Api exception.
     * @param message description
     * @param httpStatus the status code
     */
    public ApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    /**
     * Generic exception with message and cause only.
     * @param message description
     * @param cause cause
     */
    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
