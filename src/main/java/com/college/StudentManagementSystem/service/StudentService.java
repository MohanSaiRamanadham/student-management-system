package com.college.StudentManagementSystem.service;

import com.college.StudentManagementSystem.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudentsList();

    StudentDTO getStudentById(Long id);

    StudentDTO updateStudent(Long id, StudentDTO studentDTO);

    String deleteStudent(Long id);
}
