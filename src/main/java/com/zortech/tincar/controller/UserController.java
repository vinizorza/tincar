package com.zortech.tincar.controller;

import com.zortech.tincar.model.User;
import com.zortech.tincar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id){
        return userService.getById(id);
    }

    @RequestMapping(value="/", method= RequestMethod.POST)
    public void saveUser(@RequestBody User user){
        userService.save(user);
    }

}
