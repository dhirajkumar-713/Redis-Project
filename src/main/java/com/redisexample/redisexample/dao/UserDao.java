package com.redisexample.redisexample.dao;

import com.redisexample.redisexample.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    public static final String KEY = "USER";

    public User saveUser(User user) {
        redisTemplate.opsForHash().put(KEY, user.getUserId(), user);
        return user;
    }

    public User getUser(String userId) {
        return (User) redisTemplate.opsForHash().get(KEY, userId);
    }

    public Map<Object, Object> getAllUser() {
        return redisTemplate.opsForHash().entries(KEY);
    }

    public boolean deleteUser(String userId) {
        redisTemplate.opsForHash().delete(KEY, userId);
        return true;
    }
}
