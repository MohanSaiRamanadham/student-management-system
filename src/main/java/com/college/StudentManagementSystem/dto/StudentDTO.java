package com.college.StudentManagementSystem.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String studentName;
    private String mailId;
    private String course;

}
