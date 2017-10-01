package com.ggs.controller;

import com.ggs.model.User;
import com.ggs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/ggs/currentuser")
    public ResponseEntity<User> getLoggedInUser() {
        User user = this.userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        if (user == null) {
            throw new BadCredentialsException("Invalid credentials");
        }
        return ResponseEntity.ok(user);
    }


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleReportException(BadCredentialsException exc) {
        return new ResponseEntity<String>(exc.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}
