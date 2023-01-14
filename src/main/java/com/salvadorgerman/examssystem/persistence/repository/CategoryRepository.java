package com.salvadorgerman.examssystem.persistence.repository;

import com.salvadorgerman.examssystem.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
