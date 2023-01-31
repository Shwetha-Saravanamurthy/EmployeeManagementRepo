package EmployeeManagement.example.service;

import EmployeeManagement.example.exception.MyResourceNotFoundException;
import EmployeeManagement.example.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import EmployeeManagement.example.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
//    public List<Object> isUserPresent(UserDetails userDetails) {
//        return userDetails();
//    }

    @Autowired
    private  EmployeeRepository employeeRepository;

    //fetching all employees
    public List<UserDetails> getAllEmployees(){
        return (List<UserDetails>)employeeRepository.findAll();

//       // List<UserDetails> emps = (List<UserDetails>)employeeRepository.findAll();
        //return emps;
    }

    // fetching employee by id
    public UserDetails getEmployee(int id){
        if ((employeeRepository.findById(id).isEmpty()))
        throw new MyResourceNotFoundException("Employee does not exist");
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
    public void deleteAllEmployee()
    {
        employeeRepository.deleteAll();
    }

}
