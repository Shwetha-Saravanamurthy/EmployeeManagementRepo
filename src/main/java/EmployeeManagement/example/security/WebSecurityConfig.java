package EmployeeManagement.example.security;
import EmployeeManagement.example.model.UserDetails;
import EmployeeManagement.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
    @Bean
    public UserDetails userDetails() {

        return userDetails();
    }

    @Autowired
    private CustomLoginSucessHandler sucessHandler;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetails());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                // URL matching for accessibility
                .antMatchers("/", "/login", "/register").permitAll()
                .antMatchers("/addEmployee").hasAnyAuthority("Register")
                .antMatchers("/addEmployee").hasAnyAuthority("Login")
                .anyRequest().authenticated()
                .and()
                //form login
                .cors()
                .and().
                csrf()
                .disable()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .usernameParameter("email")
                .passwordParameter("password")
                .and()

                //logout
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
        //.permitAll();


        httpSecurity.authenticationProvider(authenticationProvider());
        return httpSecurity.build();

    }
}


