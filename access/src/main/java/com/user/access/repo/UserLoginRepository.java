package com.user.access.repo;

import com.user.access.entity.UserLogin;
import org.springframework.data.repository.CrudRepository;

public interface UserLoginRepository extends CrudRepository<UserLogin, String> {
}
