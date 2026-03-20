package com.college.StudentManagementSystem.controller;

import com.college.StudentManagementSystem.dto.StudentDTO;
import com.college.StudentManagementSystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("school")
public class StudentController {

    private final StudentService services;

    public StudentController(StudentService services) {
        this.services = services;
    }

    @PostMapping("/create/new/student")
    StudentDTO create(@RequestBody StudentDTO studentDTO) {
        return services.createStudent(studentDTO);
    }

    @GetMapping("/students")
    List<StudentDTO> getStudents() {
        return services.getAllStudentsList();
    }

    @GetMapping("/student/{id}")
    StudentDTO getStudentById(@PathVariable Long id) {
        return services.getStudentById(id);
    }

    @PutMapping("/update/student/{id}")
    StudentDTO modifyStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return services.updateStudent(id, studentDTO);
    }

    @DeleteMapping("/delete/{id}")
    String RemoveStudent(@PathVariable Long id) {
        return services.deleteStudent(id);
    }
}
