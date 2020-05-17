package com.user.details.controller;

import com.user.details.service.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserDetailsRestEndpointController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsRestEndpointController.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping(path="/getUserDetails")
    @ResponseBody
    public String getUserDetails() throws Exception{
        LOGGER.info("Inside getUserDetails method");
       return  userDetailsService.getUserDetails();
    }
}
