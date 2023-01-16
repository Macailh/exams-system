package com.salvadorgerman.examssystem.controller;

import com.salvadorgerman.examssystem.persistence.entity.Category;
import com.salvadorgerman.examssystem.persistence.entity.Exam;
import com.salvadorgerman.examssystem.service.ExamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/exams")
@CrossOrigin("*")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExam(@PathVariable("id") Long id) {
        return ResponseEntity.ok(examService.getExam(id));
    }

    @GetMapping
    public ResponseEntity<Set<Exam>> getAllExams() {
        return ResponseEntity.ok(examService.getAllExams());
    }

    @GetMapping("/active")
    public ResponseEntity<List<Exam>> getActiveExams() {
        return ResponseEntity.ok(examService.getActiveExams());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Exam>> getExamsFromCategory(@PathVariable("id") Long id) {
        Category category = new Category();
        category.setId(id);
        return ResponseEntity.ok(examService.getExamnsFromCategory(category));
    }

    @GetMapping("/category/active/{id}")
    public ResponseEntity<List<Exam>> getActiveExamsFromCategory(@PathVariable("id") Long id) {
        Category category = new Category();
        category.setId(id);
        return ResponseEntity.ok(examService.getActiveExamsFromCategory(category));
    }

    @PostMapping
    public Exam addExam(@RequestBody Exam exam) {
        return examService.addExam(exam);
    }

    @PutMapping
    public ResponseEntity<Exam> updateExam(@RequestBody Exam exam) {
        return ResponseEntity.ok(examService.updateExam(exam));
    }

    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
    }

}
