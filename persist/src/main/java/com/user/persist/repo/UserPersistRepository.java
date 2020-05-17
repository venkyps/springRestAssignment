package com.user.persist.repo;

import com.user.persist.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserPersistRepository extends CrudRepository<User, String> {
}
