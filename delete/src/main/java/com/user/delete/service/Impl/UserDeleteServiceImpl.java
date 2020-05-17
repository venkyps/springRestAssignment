package com.user.delete.service.Impl;

import com.user.delete.repo.UserDeleteRepository;
import com.user.delete.service.UserDeleteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDeleteServiceImpl implements UserDeleteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDeleteServiceImpl.class);
    private static final String SUCCESS="SuccessFully deleted";
    private static final String FAILURE="Deleted failed";

    @Autowired
    private UserDeleteRepository userDeleteRepository;

    @Override
    public String deleteUser(String empID) {
        try{
            LOGGER.info("Inside deleteUser in service impl");
            userDeleteRepository.deleteById(empID);
            return SUCCESS;
        }catch (Exception ex){
            LOGGER.error("Exception while deleting user details ",ex);
        }
        return FAILURE;
    }
}
