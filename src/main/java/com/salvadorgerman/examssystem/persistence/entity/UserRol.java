package com.salvadorgerman.examssystem.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
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
