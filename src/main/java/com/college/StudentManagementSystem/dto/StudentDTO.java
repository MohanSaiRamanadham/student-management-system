package com.college.StudentManagementSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentDTO {
    private Long id;

    @NotBlank(message = "Please enter Name")
    @Size(max = 25, min = 2, message = "Name should be in between 2 - 25 characters")
    @Pattern(regexp = "^[a-zA-Z .'-]+$", message = "Name should use only Alphabets,spacesm .'- ")
    private String studentName;

    @NotBlank(message = "email shouldn't be blank")
    @Email(message = "Please enter valid Email id")
    private String mailId;

    @NotBlank(message = "Please enter valid Course")
    @Pattern(regexp = "^[a-zA-Z .()'-]+$", message = "Only alphabets, spaces, (), . ' - are allowed")
    private String course;
}
