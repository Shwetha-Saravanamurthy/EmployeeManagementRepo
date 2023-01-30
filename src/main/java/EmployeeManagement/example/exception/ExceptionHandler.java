package EmployeeManagement.example.exception;

import EmployeeManagement.example.model.UserDetails;
import EmployeeManagement.example.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
//    @org.springframework.web.bind.annotation.ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException (NotFoundException notFoundException)
    {
        Exception exception = new Exception(notFoundException.getMessage(), notFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
