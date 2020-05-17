package com.user.delete.repo;

import com.user.delete.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDeleteRepository extends CrudRepository<User, String> {
}
