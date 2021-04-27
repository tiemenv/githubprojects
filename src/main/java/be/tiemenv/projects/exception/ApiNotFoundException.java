package be.tiemenv.projects.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalTime;

public class ApiNotFoundException {
    private final String message;
    private final HttpStatus httpStatus;
    private final LocalTime timestamp;

    public ApiNotFoundException(String message, HttpStatus httpStatus, LocalTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }
}
