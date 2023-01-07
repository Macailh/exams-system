package com.salvadorgerman.examssystem.controller;

import com.salvadorgerman.examssystem.persistence.entity.Rol;
import com.salvadorgerman.examssystem.persistence.entity.User;
import com.salvadorgerman.examssystem.persistence.entity.UserRol;
import com.salvadorgerman.examssystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User saveUser(@RequestBody User user) throws Exception {
        Set<UserRol> userRols = new HashSet<>(); // Colleccion de userRoles

        Rol rol = new Rol(); // Se crea un nuevo rol
        rol.setId(1L); // Se le define 1 como id para el nuevo rol creado
        rol.setRolName("STUDENT"); // Se le define el nombre al rol creado

        UserRol userRol = new UserRol(); // Se crea un nuevo userRol
        userRol.setUser(user); // se le define el user
        userRol.setRol(rol); // se le define el rol

        //userRols.add(userRol); // a la coleccion de roles se le agredar el
        return userService.saveUser(user, userRols);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
}
