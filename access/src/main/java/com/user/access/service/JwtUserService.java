package com.user.access.service;

import com.user.access.entity.UserLogin;
import com.user.access.repo.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserService implements UserDetailsService {

    @Autowired
    UserLoginRepository userLoginRepository;

    @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           Optional<UserLogin> userLogin= userLoginRepository.findById(username);
           if(userLogin.isPresent()){
               return new User(userLogin.get().getUserName(), userLogin.get().getPassword(),
                       new ArrayList<>());
           }
         else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
