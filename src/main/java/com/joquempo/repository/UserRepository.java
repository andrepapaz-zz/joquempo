package com.joquempo.repository;

import com.joquempo.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by andrepapazoglu on 22/11/16.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByName(String name);
}
