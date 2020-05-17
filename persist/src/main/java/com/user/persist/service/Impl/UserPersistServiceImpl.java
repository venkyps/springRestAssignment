package com.user.persist.service.Impl;

import com.user.persist.entity.User;
import com.user.persist.model.UserVO;
import com.user.persist.repo.UserPersistRepository;
import com.user.persist.service.UserPersistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPersistServiceImpl implements UserPersistService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPersistServiceImpl.class);
    private static final String SUCCESS="SuccessFully persisted";
    private static final String FAILURE="Persistence failed";

    @Autowired
    private UserPersistRepository userPersistRepository;

    @Override
    public String persistUser(UserVO userVO) {
        try{
            LOGGER.info("Inside persistUser in service impl");
            User user = new User();
            user.setCountry(userVO.getCountry());
            user.setEmpID(userVO.getEmpID());
            user.setSalary(userVO.getSalary());
            user.setUserName(userVO.getUserName());
            userPersistRepository.save(user);
            return SUCCESS;

        }catch (Exception ex){
            LOGGER.error("Exception while persisting user details ",ex);
        }
        return FAILURE;
    }
}
