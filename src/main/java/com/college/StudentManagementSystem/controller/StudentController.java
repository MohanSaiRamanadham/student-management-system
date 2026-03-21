package com.college.StudentManagementSystem.controller;

import com.college.StudentManagementSystem.dto.StudentDTO;
import com.college.StudentManagementSystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("school")
public class StudentController {

    private final StudentService services;

    public StudentController(StudentService services) {
        this.services = services;
    }

    @PostMapping("/students")
    StudentDTO create(@Valid @RequestBody StudentDTO studentDTO) {
        return services.createStudent(studentDTO);
    }

    @GetMapping("/students")
    List<StudentDTO> getStudents() {
        return services.getAllStudentsList();
    }

    @GetMapping("/students/{id}")
    StudentDTO getStudentById(@PathVariable Long id) {
        return services.getStudentById(id);
    }

    @PutMapping("/students/{id}")
    StudentDTO modifyStudent(@PathVariable Long id, @Valid @RequestBody StudentDTO studentDTO) {
        return services.updateStudent(id, studentDTO);
    }

    @DeleteMapping("/students/{id}")
    String removeStudent(@PathVariable Long id) {
        return services.deleteStudent(id);
    }
}
