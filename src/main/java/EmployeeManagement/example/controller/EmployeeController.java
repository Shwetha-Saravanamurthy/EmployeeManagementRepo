package EmployeeManagement.example.controller;

import EmployeeManagement.example.model.UserDetails;
import EmployeeManagement.example.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import EmployeeManagement.example.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(UserDetails.class);
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder encoder;


    //inserting employee
    @PostMapping("/addEmployee")
    public String saveEmp(@Valid @RequestBody UserDetails userDetails){
        log.info("");
        userDetails.setPassword(encoder.encode(userDetails.getPassword()));
        employeeService.addEmployees(userDetails);
        return "User is valid";
    }

    // displaying list of all employees
    @GetMapping("/employee")
    public List<UserDetails> getAllEmployee(){
        log.info("");
        return employeeService.getAllEmployees();
    }

    //displaying employee by id
    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable int id)
    {
        return ResponseHandler.responseBuilder("Requested employee Details are  here",
                HttpStatus.OK, employeeService.getEmployee(id));
    }

//    public UserDetails getEmployee(@PathVariable int id){
//
//        return employeeService.getEmployee(id);
//    }

    //updating employee by id
    @PutMapping("/employee/{id}")
    public void updateEmployee(@RequestBody UserDetails e, @PathVariable int id){
        employeeService.updateEmployee(e, id);
    }

    // deleting all employees
    @DeleteMapping("/employee")
    public void deleteAllEmployee()
    {
         employeeService.deleteAllEmployee();
    }
}
