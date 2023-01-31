//package EmployeeManagement.example.service;
//
//import EmployeeManagement.example.model.User;
//import EmployeeManagement.example.repository.EmployeeRepository;
//import EmployeeManagement.example.response.UserCreateRequest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.Optional;
//
//public class UserService {
//   // private final EmployeeRepository employeeRepository;
//
//
//    public static User readUserByUsername(String username) {
//        return employeeRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
//    }
//
//    public void createUser(UserCreateRequest userCreateRequest) {
//        User user = new User();
//        Optional<User> byUsername = employeeRepository.findByUsername(userCreateRequest.getUsername());
//        if (byUsername.isPresent()) {
//            throw new RuntimeException("User already registered. Please use different username.");
//        }
//        user.setUsername(userCreateRequest.getUsername());
//        user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
//        userRepository.save(user);
//    }
//}
