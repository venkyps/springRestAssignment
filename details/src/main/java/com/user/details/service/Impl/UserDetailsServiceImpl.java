package com.user.details.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.details.entity.User;
import com.user.details.repo.UserDetailsRepository;
import com.user.details.service.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public String getUserDetails() throws Exception {
        try{
            LOGGER.info("Inside getUserDetails method");
            Iterable<User> userIterable=userDetailsRepository.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            if(null!=userIterable){
                List<User> list = StreamSupport
                        .stream(userIterable.spliterator(), false)
                        .collect(Collectors.toList());
                return objectMapper.writeValueAsString(list);
            }
        }catch (Exception ex){
            LOGGER.error("Exception while fetching user details ",ex);
        }
        return "";
    }
}
