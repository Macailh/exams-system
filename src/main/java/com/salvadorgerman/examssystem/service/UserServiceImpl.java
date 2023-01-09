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
    // Inyección mediante constructor
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
        // Se guarda en userLocal el resultado de buscar el nombre de usuario ingresado entre los usuario guardados
        User userLocal = userRepository.findByUsername(user.getUsername());
        // Si se ecuentra alguna coincidencia se lanza una excepción
        if(userLocal != null) {
            System.out.println("User already exist");
            throw new Exception("User already exist");
        } else {
            // Se recorre y guarda cada rol que se encuentre en userRols
            for (UserRol userRol : userRols) {
                rolRepository.save(userRol.getRol());
            }
            // Se añade todo lo que hay en userRols
            user.getUserRols().addAll(userRols);
            // Se guarda el usuario
            userLocal = userRepository.save(user);
        }
        return userLocal;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
