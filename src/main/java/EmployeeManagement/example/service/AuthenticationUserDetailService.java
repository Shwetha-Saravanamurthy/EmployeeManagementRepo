//package EmployeeManagement.example.service;
//
//import EmployeeManagement.example.model.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//public class AuthenticationUserDetailService implements UserDetailsService {
////
////    private final UserDetailsService userDetailsService;
////
////    public AuthenticationUserDetailService(UserDetailsService userDetailsService) {
////        this.userDetailsService = userDetailsService;
////    }
////
////
////
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        User user = UserDetailsService.readUserByUsername(username);
////        if (user == null) {
////            throw new UsernameNotFoundException(username);
////        }
////        return new org.springframework.security.core.userdetails.User(user.getEmployeeId(),
////                user.getPassword(), getAuthorities(user.getRole()));
////    }
//
//    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
//        return Arrays.asList(new SimpleGrantedAuthority(role));
//    }
//}
