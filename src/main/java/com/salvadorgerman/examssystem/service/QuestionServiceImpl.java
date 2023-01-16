package com.salvadorgerman.examssystem.service;

import com.salvadorgerman.examssystem.persistence.entity.Exam;
import com.salvadorgerman.examssystem.persistence.entity.Question;
import com.salvadorgerman.examssystem.persistence.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question getQuestion(Long id) {
        return questionRepository.findById(id).get();
    }

    @Override
    public Set<Question> getAllQuestions() {
        return (Set<Question>)questionRepository.findAll();
    }

    @Override
    public Set<Question> getQuestionsFromExam(Exam exam) {
        return questionRepository.findByExam(exam);
    }

    @Override
    public Question listQuestion(Long id) {
        return questionRepository.getOne(id);
    }

    @Override
    public void deleteQuestion(Long id) {
        Question question = new Question();
        question.setId(id);
        questionRepository.delete(question);
    }
}
