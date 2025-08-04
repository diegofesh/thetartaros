package com.dfesh.co.thetartaros.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(

        String message,
        String statusCode,
        LocalDateTime timestamp,
        String path
        ) {
}
