package com.amigoscode.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Getter
@Builder
public class ApiException {

    private HttpStatus httpStatus;
    private String ErrorCode;
    private ZonedDateTime timestamp;
    private String message;

}
