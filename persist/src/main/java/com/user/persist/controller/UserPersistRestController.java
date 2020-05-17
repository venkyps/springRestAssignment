package com.user.persist.controller;

import com.user.persist.model.UserVO;
import com.user.persist.service.UserPersistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserPersistRestController {

    private static final Logger logger = LoggerFactory.getLogger(UserPersistRestController.class);

    @Autowired
    UserPersistService userPersistService;

    @PostMapping(value = "/persistUser")
    public String persistUser(@RequestBody UserVO userVO){
        logger.info("Inside persistUser in rest controller");
       return userPersistService.persistUser(userVO);
    }

}
