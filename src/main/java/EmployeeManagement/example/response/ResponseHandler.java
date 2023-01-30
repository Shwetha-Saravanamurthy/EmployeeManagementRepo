package EmployeeManagement.example.response;

import EmployeeManagement.example.model.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(
            String message, HttpStatus httpStatus, Object responseObject) {
        Map<String, Object> response = new HashMap<>();
        response.put("invalid request api", message);
        response.put("httpStatus", httpStatus);
        response.put("data", responseObject);
        return new ResponseEntity<>(response, httpStatus);
    }

}
