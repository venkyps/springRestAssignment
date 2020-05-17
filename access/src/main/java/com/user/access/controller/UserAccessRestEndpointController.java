package com.user.access.controller;

import com.user.access.config.JwtTokenUtil;
import com.user.access.model.JwtRequest;
import com.user.access.model.JwtResponse;
import com.user.access.service.JwtUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/userAccess")
public class UserAccessRestEndpointController {

    private static final Logger logger = LoggerFactory.getLogger(UserAccessRestEndpointController.class);

    @Autowired
    private JwtUserService jwtUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws Exception {

        final UserDetails userDetails = jwtUserService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

}
