package com.salvadorgerman.examssystem.controller;

import com.salvadorgerman.examssystem.config.JwtUtils;
import com.salvadorgerman.examssystem.exception.UserFoundException;
import com.salvadorgerman.examssystem.exception.UserNotFoundException;
import com.salvadorgerman.examssystem.persistence.entity.JwtRequest;
import com.salvadorgerman.examssystem.persistence.entity.JwtResponse;
import com.salvadorgerman.examssystem.persistence.entity.User;
import com.salvadorgerman.examssystem.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtils jwtUtils;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        }catch (UserNotFoundException e) {
            e.printStackTrace();
            throw new UserFoundException("User not found");
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate (String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch(DisabledException disabledException) {
            throw new Exception("User disabled " + disabledException.getMessage());
        } catch(BadCredentialsException badCredentialsException) {
            throw new Exception("Invalid credentials " + badCredentialsException.getMessage());
        }
    }

    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal) {
        return (User) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}
