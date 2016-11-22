package com.joquempo.service;

import com.joquempo.dao.UserDao;
import com.joquempo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by andrepapazoglu on 20/11/16.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findByName(String name) {
        User byName = userDao.findByName(name);

        return byName;
    }

    public User save(User user) {
        User save = userDao.save(user);
        return save;
    }
}
