//package EmployeeManagement.example.filter;
//
//import EmployeeManagement.example.model.User;
//import EmployeeManagement.example.security.AuthenticationConfigConstants;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//
//import static org.springframework.security.config.Elements.JWT;
//@RequiredArgsConstructor
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//   // public static Object AuthenticationConfigConstants;
//    private final AuthenticationManager authenticationManager;
//    //private final AuthenticationUserDetailService;
//
////    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
////        this.authenticationManager = authenticationManager;
////    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        try {
//            User creds = new ObjectMapper()
//                    .readValue(request.getInputStream(), User.class);
//
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            creds.getEmployeeId(),
//                            creds.getPassword(),
//                            new ArrayList<>())
//            );
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
//        String token = JWT.User()
//                .withSubject(((User) auth.getPrincipal()).getId())
//                .withExpiresAt(new Date(System.currentTimeMillis() + AuthenticationConfigConstants.EXPIRATION_TIME))
//                .sign(Algorithm.HMAC512(AuthenticationConfigConstants.SECRET.getBytes()));
//                response.setContentType("application/json");
//                response.setCharacterEncoding("UTF-8");
//                response.getWriter().write(
//                "{\"" + AuthenticationConfigConstants.HEADER_STRING + "\":\"" + AuthenticationConfigConstants.TOKEN_PREFIX + token + "\"}"
//        );
//    }
//
//
//    }
