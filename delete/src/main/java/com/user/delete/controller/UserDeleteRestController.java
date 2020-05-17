package com.user.delete.controller;

import com.user.delete.service.UserDeleteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserDeleteRestController {

    private static final Logger logger = LoggerFactory.getLogger(UserDeleteRestController.class);

    @Autowired
    UserDeleteService userDeleteService;

    @DeleteMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam  String empID){
        logger.info("Inside deleteUser in rest controller");
       return userDeleteService.deleteUser(empID);
    }

}
