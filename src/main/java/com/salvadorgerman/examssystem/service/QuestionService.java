package com.salvadorgerman.examssystem.service;

import com.salvadorgerman.examssystem.persistence.entity.Exam;
import com.salvadorgerman.examssystem.persistence.entity.Question;

import java.util.List;
import java.util.Set;

public interface QuestionService {
    Question addQuestion(Question question);

    Question updateQuestion(Question question);

    Set<Question> getAllQuestions();

    Question getQuestion(Long id);

    Set<Question> getQuestionsFromExam(Exam exam);

    Question listQuestion(Long id);

    void deleteQuestion(Long id);
}
