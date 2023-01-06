package com.salvadorgerman.examssystem.persistence.entity;

import javax.persistence.*;

@Entity
public class UserRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRolId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne
    private Rol rol;

}
