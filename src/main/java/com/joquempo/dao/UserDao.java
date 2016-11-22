package com.joquempo.dao;

import com.joquempo.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by andrepapazoglu on 20/11/16.
 */
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
    public User findByName(String name);
}
