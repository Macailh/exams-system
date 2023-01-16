package com.salvadorgerman.examssystem.persistence.repository;

import com.salvadorgerman.examssystem.persistence.entity.Category;
import com.salvadorgerman.examssystem.persistence.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByCategory(Category category);

    List<Exam> findByActve(boolean active);

    List<Exam> findByCategoryAndActve(Category category, boolean active);

}
