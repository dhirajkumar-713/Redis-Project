package com.redisexample.redisexample.controller;

import com.redisexample.redisexample.dao.UserDao;
import com.redisexample.redisexample.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserConroller {
    @Autowired
    private UserDao userDao;

    @PostMapping("posting")
    public User createUser(@RequestBody User user) {
        System.out.println("Hello");
        user.setUserId(UUID.randomUUID().toString());
        return userDao.saveUser(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        return userDao.getUser(userId);
    }

    @GetMapping("all")
    public Map<Object, Object> getAllUsers() {
        return userDao.getAllUser();
    }

    @DeleteMapping("/{userId}")
    public boolean deleteUser(@PathVariable("userId") String userId) {
        return userDao.deleteUser(userId);
    }
}
