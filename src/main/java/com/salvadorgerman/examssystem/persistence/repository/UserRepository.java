package com.salvadorgerman.examssystem.persistence.repository;

import com.salvadorgerman.examssystem.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
