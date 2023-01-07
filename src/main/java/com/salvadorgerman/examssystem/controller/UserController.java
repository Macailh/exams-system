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
        Set<UserRol> rols = new HashSet<>();

        Rol rol = new Rol();
        rol.setId(1L);
        rol.setRolName("STUDENT");

        UserRol userRol = new UserRol();
        userRol.setUser(user);
        userRol.setRol(rol);

        return userService.saveUser(user, rols);
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
