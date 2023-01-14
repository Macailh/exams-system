package com.salvadorgerman.examssystem.persistence.repository;

import com.salvadorgerman.examssystem.persistence.entity.Exam;
import com.salvadorgerman.examssystem.persistence.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Set<Question> findByExam(Exam exam);
}
