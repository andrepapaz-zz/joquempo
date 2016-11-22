package com.joquempo.service;

import com.joquempo.entity.User;
import com.joquempo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by andrepapazoglu on 20/11/16.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByName(String name) {
        User byName = userRepository.findByName(name);

        return byName;
    }

    public User save(User user) {
        User save = userRepository.save(user);
        return save;
    }
}
