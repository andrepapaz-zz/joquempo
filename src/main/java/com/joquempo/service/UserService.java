package com.joquempo.service;

import com.joquempo.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by andrepapazoglu on 20/11/16.
 */
@Service
@Component
public interface UserService {
    User findByName(String nome);
    User save(User user);
}
