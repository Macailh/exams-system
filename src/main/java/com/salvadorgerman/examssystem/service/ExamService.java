package com.salvadorgerman.examssystem.service;

import com.salvadorgerman.examssystem.persistence.entity.Category;
import com.salvadorgerman.examssystem.persistence.entity.Exam;

import java.util.List;
import java.util.Set;

public interface ExamService {

    Exam addExam(Exam exam);

    Exam updateExam(Exam exam);

    Set<Exam> getAllExams();

    Exam getExam(Long id);

    void deleteExam(Long id);

    List<Exam> getExamnsFromCategory(Category category);

    List<Exam> getActiveExams();

    List<Exam> getActiveExamsFromCategory(Category category);
}
