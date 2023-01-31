//package EmployeeManagement.example.filter;
//
//import EmployeeManagement.example.service.AuthenticationUserDetailService;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//
//import static org.springframework.security.config.Elements.JWT;
//
//public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
//    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String header = request.getHeader(JWTAuthenticationFilter.AuthenticationConfigConstants.HEADER_STRING);
//
//        if (header == null || !header.startsWith(JWTAuthenticationFilter.AuthenticationConfigConstants.TOKEN_PREFIX)) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        chain.doFilter(request, response);
//    }
//
//
//    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
//        String token = request.getHeader(JWTAuthenticationFilter.AuthenticationConfigConstants.HEADER_STRING);
//        if (token != null) {
//            // parse the token.
//            String user = JWT.require(Algorithm.HMAC512(JWTAuthenticationFilter.AuthenticationConfigConstants.SECRET.getBytes()))
//                    .build()
//                    .verify(token.replace(JWTAuthenticationFilter.AuthenticationConfigConstants.TOKEN_PREFIX, ""))
//                    .getSubject();
//
//            if (user != null) {
//                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//            }
//            return null;
//        }
//        return null;
//    }
//    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
//        return Arrays.asList(new SimpleGrantedAuthority(role));
//    }
//}
