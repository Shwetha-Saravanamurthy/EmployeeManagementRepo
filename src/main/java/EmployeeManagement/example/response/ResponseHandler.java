package EmployeeManagement.example.response;

import EmployeeManagement.example.ErrorHandling.ApiError;
import EmployeeManagement.example.model.UserDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ResponseHandler {
   // public static ResponseEntity<Object> responseBuilder(String s, HttpStatus ok, UserDetails employee) {
        @ExceptionHandler({ Exception.class })
        public static ResponseEntity<Object> handleAll(Exception ex, UserDetails request) {
            ApiError apiError = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred");
            return new ResponseEntity<Object>(
                    apiError, new HttpHeaders(), apiError.getStatus());
        }
}

