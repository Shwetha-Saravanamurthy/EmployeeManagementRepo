package EmployeeManagement.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;


@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int empId;
    @NotNull(message = "password is mandatory")
    private String password;

    @NotBlank(message = "firstName is mandatory")
//    @Size(min = 3, max = 50)
    private String firstName;


    @NotBlank(message = "lastName is mandatory")
    @Size(min = 3, max = 50)
    private String lastName;


    @NotNull(message = "age  is mandatory")
    private int age;


    //@NotNull(message = "DOB is mandatory")
   @DateTimeFormat(pattern = "dd-mm-yyyy")
    //@JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;

    @NotNull(message = "Email is mandatory")
    @Email(message = "Please enter a valid email address")
    @Column(name = "email", unique = true)
    private  String email;

    @NotNull(message = "mobileNumber is mandatory")
    private  String mobileNumber;
    @NotNull(message = "workDepartment is mandatory")
    private String workDepartment;



}


