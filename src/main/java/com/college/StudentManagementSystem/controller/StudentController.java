package com.college.StudentManagementSystem.controller;

import com.college.StudentManagementSystem.dto.StudentDTO;
import com.college.StudentManagementSystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO studentDTO) {
        StudentDTO stuDTO = services.createStudent(studentDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(stuDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(stuDTO);
    }

    @GetMapping("/students")
    ResponseEntity<List<StudentDTO>> getStudents() {
        return new ResponseEntity<>(services.getAllStudentsList(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(services.getStudentById(id), HttpStatus.OK);
    }

    @PutMapping("/students/{id}")
    ResponseEntity<StudentDTO> modifyStudent(@PathVariable Long id, @Valid @RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(services.updateStudent(id, studentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    ResponseEntity<String> removeStudent(@PathVariable Long id) {
        return new ResponseEntity<>(services.deleteStudent(id), HttpStatus.OK);
    }
}
