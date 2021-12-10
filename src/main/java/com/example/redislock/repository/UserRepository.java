package com.example.redislock.repository;

import com.example.redislock.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author admin
 * @date 2021/12/9 14:21
 */
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 根据name查询数据
     * @param name 姓名
     * @return user
     */
    Optional<User> findByName(String name);
}
