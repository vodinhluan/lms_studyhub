package com.studyhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studyhub.model.AuthenticationRequest;
import com.studyhub.model.AuthenticationResponse;
import com.studyhub.model.User;
import com.studyhub.security.JWTUtil;
import com.studyhub.service.CustomUserDetailsService;
import com.studyhub.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

       
        User user = userService.findByUsername(authenticationRequest.getUsername());
        String role = user.getRole().name();
        String fullName = user.getFullName();

        return ResponseEntity.ok(new AuthenticationResponse(jwt, role, fullName));

    }
}
