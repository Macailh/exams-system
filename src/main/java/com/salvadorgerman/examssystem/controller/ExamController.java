package com.salvadorgerman.examssystem.controller;

import com.salvadorgerman.examssystem.persistence.entity.Exam;
import com.salvadorgerman.examssystem.service.ExamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/exams")
@CrossOrigin
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

    @PostMapping
    public Exam addExam(@RequestBody Exam exam) {
        return examService.addExam(exam);
    }

    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
    }
}
