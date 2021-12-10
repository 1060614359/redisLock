package com.example.redislock.service.impl;

import com.example.redislock.annotation.RedisLock;
import com.example.redislock.dao.User;
import com.example.redislock.repository.UserRepository;
import com.example.redislock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author admin
 * @date 2021/12/9 15:55
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @RedisLock(bindType = RedisLock.BindType.OBJECT_PROPERTIES,properties = "User.name")
    public User createUser(User user) {
        Optional<User> userOptional = userRepository.findByName(user.getName());
        if (userOptional.isPresent()){
            throw new RuntimeException("已有改用户");
        }
        User save = userRepository.save(user);
        return save;
    }
}
