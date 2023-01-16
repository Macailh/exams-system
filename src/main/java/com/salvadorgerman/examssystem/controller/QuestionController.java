package com.salvadorgerman.examssystem.controller;

import com.salvadorgerman.examssystem.persistence.entity.Exam;
import com.salvadorgerman.examssystem.persistence.entity.Question;
import com.salvadorgerman.examssystem.service.ExamService;
import com.salvadorgerman.examssystem.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@RestController
@RequestMapping("/questions")
@CrossOrigin("*")
public class QuestionController {

    private final QuestionService questionService;

    private final ExamService examService;

    public QuestionController(QuestionService questionService, ExamService examService) {
        this.questionService = questionService;
        this.examService = examService;
    }

    @GetMapping
    public ResponseEntity<?> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestion(id));
    }

    @GetMapping("/exam/{id}")
    public ResponseEntity<?> getQuestionsFromExam(@PathVariable("id") Long id) {
        Exam exam = new Exam();
        Set<Question> questions = exam.getQuestions();

        List exams = new ArrayList();
        if(exams.size() > Integer.parseInt(exam.getNumberOfQuestions())) {
            exams = exams.subList(0, Integer.parseInt(exam.getNumberOfQuestions() + 1));
        }

        Collections.shuffle(exams);
        return ResponseEntity.ok(exams);
    }

    @GetMapping("/exam/all/{id}")
    public ResponseEntity<Set<Question>> getQuestionsFromExamAdmin(@PathVariable("id") Long id) {
        Exam exam = new Exam();
        exam.setId(id);
        Set<Question> questions = questionService.getQuestionsFromExam(exam);
        return ResponseEntity.ok(questions);
    }

    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.addQuestion(question));
    }

    @PutMapping
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.updateQuestion(question));
    }

    @DeleteMapping("/{id}")
    public void  deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }
}
