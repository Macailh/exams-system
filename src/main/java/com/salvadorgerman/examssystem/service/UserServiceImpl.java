package com.salvadorgerman.examssystem.service;

import com.salvadorgerman.examssystem.persistence.entity.User;
import com.salvadorgerman.examssystem.persistence.entity.UserRol;
import com.salvadorgerman.examssystem.persistence.repository.RolRepository;
import com.salvadorgerman.examssystem.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    private final RolRepository rolRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(RolRepository rolRepository,
                           UserRepository userRepository) {
        this.rolRepository = rolRepository;
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user, Set<UserRol> userRols) throws Exception {
        User userLocal = userRepository.findByUsername(user.getUsername());
        if(userLocal != null) {
            System.out.println("User already exist");
            throw new Exception("User already exist");
        } else {
            for (UserRol userRol : userRols) {
                rolRepository.save(userRol.getRol());
            }
            user.getUserRols().addAll(userRols);
            userLocal = userRepository.save(user);
        }
        return userLocal;
    }
}
