package com.college.StudentManagementSystem.mapper;

import com.college.StudentManagementSystem.dto.StudentDTO;
import com.college.StudentManagementSystem.entity.Student;

public class StudentMapper {

    public static StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setStudentName(student.getName());
        dto.setMailId(student.getEmail());
        dto.setCourse(student.getCourse());
        return dto;
    }

    public static Student toEntity(StudentDTO dto) {
        Student student = new Student();
        student.setName(dto.getStudentName());
        student.setEmail(dto.getMailId());
        student.setCourse(dto.getCourse());
        return student;
    }
}
