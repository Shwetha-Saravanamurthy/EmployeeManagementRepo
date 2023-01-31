package EmployeeManagement.example.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotNull(message = "employeeId is mandatory")
    private int employeeId;
    @NotNull(message = "password is mandatory")
    private String password;
    @NotNull(message = "role is mandatory")
    private String role;

}
