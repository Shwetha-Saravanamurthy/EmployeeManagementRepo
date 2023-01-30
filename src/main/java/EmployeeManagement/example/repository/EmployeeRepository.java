package EmployeeManagement.example.repository;

import EmployeeManagement.example.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//interface extending crud repository
@Repository
public interface EmployeeRepository extends JpaRepository<UserDetails,Integer> {
}
