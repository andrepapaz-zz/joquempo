package com.joquempo.controller;

import com.joquempo.entity.User;
import com.joquempo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andrepapazoglu on 20/11/16.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public User getUserByName(@RequestBody User user) {
        User byName = userService.findByName(user.getName());

        if (byName == null) {
            User newUser = userService.save(user);

            byName = newUser;
        }

        return byName;
    }
}
