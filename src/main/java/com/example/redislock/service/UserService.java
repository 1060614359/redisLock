package com.example.redislock.service;

import com.example.redislock.dao.User;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @date 2021/12/9 15:16
 */

public interface UserService {
    /**
     * 创建用户信息
     * @return User
     */
    User createUser(User user);
}
