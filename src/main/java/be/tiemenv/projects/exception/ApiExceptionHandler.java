package be.tiemenv.projects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;

//used to customize the way we throw the exception to the client

//tell spring this is our exception handler
@ControllerAdvice
public class ApiExceptionHandler {
    // tell spring that this method is responsible for handling exceptions
    @ExceptionHandler(value = {ApiRequestException.class})
    //handle the custom exception that we've created earlier
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        //1. Create payload containing exception details
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiNotFoundException apiNotFoundException = new ApiNotFoundException(
                e.getMessage(),
                notFound,
                LocalTime.now()
        );
        //2. Return the response entity
        return new ResponseEntity<>(apiNotFoundException, notFound);
    }
}


