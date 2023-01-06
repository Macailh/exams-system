package com.salvadorgerman.examssystem.persistence.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private boolean enabled;
    private String profile;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<UserRol> userRols = new HashSet<>();
}
