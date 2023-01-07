package com.salvadorgerman.examssystem.service;

import com.salvadorgerman.examssystem.persistence.entity.User;
import com.salvadorgerman.examssystem.persistence.entity.UserRol;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserService {

    public User saveUser(User user, Set<UserRol> userRols) throws Exception;
    public User getUser(String username);
    public void deleteUser(Long userId);
}
