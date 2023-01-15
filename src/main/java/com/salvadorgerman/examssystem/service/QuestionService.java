package com.salvadorgerman.examssystem.service;

import com.salvadorgerman.examssystem.persistence.entity.Exam;
import com.salvadorgerman.examssystem.persistence.entity.Question;

import java.util.List;
import java.util.Set;

public interface QuestionService {
    Question addQuestion(Question question);

    Question updateQuestion(Question question);

    Question getQuestion(Long id);

    List<Question> getAllQuestions();

    Set<Question> getQuestionsFromExam(Exam exam);

    void deleteQuestion(Long id);
}
