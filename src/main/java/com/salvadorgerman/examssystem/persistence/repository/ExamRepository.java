package com.salvadorgerman.examssystem.persistence.repository;

import com.salvadorgerman.examssystem.persistence.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
