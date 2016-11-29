package com.joquempo.controller;

import com.joquempo.entity.User;
import com.joquempo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andrepapazoglu on 20/11/16.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/byName/{name}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String name) {
        User byName = userService.findByName(name);

        return byName;
    }
}
