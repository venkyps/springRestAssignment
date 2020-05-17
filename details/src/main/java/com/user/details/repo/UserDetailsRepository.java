package com.user.details.repo;

import com.user.details.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<User, String> {
}
