package com.salvadorgerman.examssystem.persistence.repository;

import com.salvadorgerman.examssystem.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository // Para usar JpaRepository se crea una interfaz que extienda de la interfaz
        extends JpaRepository<User, Long> { // Tipo de entidad y el tipo de la llave primaria

    public User findByUsername(String username);
}

//        JpaRepository proporciona métodos de acceso a datos básicos como save(), findOne(), findAll(), delete(), etc.
//        También proporciona algunas opciones de personalización a través de la
//        definición de métodos de consulta personalizados o la utilización de palabras clave de consulta de JPA.