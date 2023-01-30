package EmployeeManagement.example.service;

import EmployeeManagement.example.exception.NotFoundException;
import EmployeeManagement.example.model.User;
import EmployeeManagement.example.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import EmployeeManagement.example.repository.EmployeeRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
//    public List<Object> isUserPresent(UserDetails userDetails) {
//        return userDetails();
//    }

    @Autowired
    private EmployeeRepository employeeRepository;

    //fetching all employees
    public List<UserDetails> getAllEmployees(){
        return (List<UserDetails>)employeeRepository.findAll();

//       // List<UserDetails> emps = (List<UserDetails>)employeeRepository.findAll();
        //return emps;
    }

    // fetching employee by id
    public UserDetails getEmployee(int id){
        if ((employeeRepository.findById(id).isEmpty()))
        throw new NotFoundException("Employee does not exist");
        return employeeRepository.findById(id).get();
               // orElseThrow();
    }

    // inserting employee
    public String  addEmployees(UserDetails userDetails) {
        employeeRepository.save(userDetails);
        return "Successfully added";
    }

    // updating employee by id
    public void updateEmployee(UserDetails emp, int id){
        if(id == emp.getEmpId()) {
             employeeRepository.save(emp);
        }
    }

    // deleting all employees
    public void deleteAllEmployee(){
        employeeRepository.deleteAll();
    }

//    @Override
//    public List<Object> isUserPresent(UserDetails userDetails) {
//        boolean userExists = false;
//        String message = null;
//        Optional<User> existingUserEmail = employeeRepository.()(userDetails.getEmail());
//        if(existingUserEmail.isPresent()){
//            userExists = true;
//            message = "Email Already Present!";
//        }
//        Optional<User> existingUserMobile = employeeRepository.findByMobile(userDetails.getMobile());
//        if(existingUserMobile.isPresent()){
//            userExists = true;
//            message = "Mobile Number Already Present!";
//        }
//        if (existingUserEmail.isPresent() && existingUserMobile.isPresent()) {
//            message = "Email and Mobile Number Both Already Present!";
//        }

//        if (existingUserEmail.isPresent())
//        {
//            message = "Email Already Present!";
//        }
//       // System.out.println("existingUserEmail.isPresent() - "+existingUserEmail.isPresent()+"existingUserMobile.isPresent() - "+existingUserMobile.isPresent());
//        System.out.println("existingUserEmail.isPresent() - "+existingUserEmail.isPresent());
//        return Arrays.asList(userExists, message);
//    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        return employeeRepository.findByEmail(email).orElseThrow(
//                ()-> new UsernameNotFoundException(
//                        String.format("USER_NOT_FOUND", email)
//                ));
//    }
}
