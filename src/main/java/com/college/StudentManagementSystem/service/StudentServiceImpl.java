package com.college.StudentManagementSystem.service;

import com.college.StudentManagementSystem.dto.StudentDTO;
import com.college.StudentManagementSystem.entity.Student;
import com.college.StudentManagementSystem.mapper.StudentMapper;
import com.college.StudentManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {

        Objects.requireNonNull(studentDTO,"Student should not be null");

        String name=studentDTO.getStudentName().trim();
        String mailId =studentDTO.getMailId().trim().toLowerCase();
        String course =studentDTO.getCourse().trim();
        if(repository.existsByEmail(mailId)){
            throw new RuntimeException("Email already exists");
        }
        Student student = new Student();
        student.setName(name);
        student.setEmail(mailId);
        student.setCourse(course);

        return StudentMapper.toDTO(repository.save(student));
    }

    @Override
    public List<StudentDTO> getAllStudentsList() {
        return repository.findAll().stream().map(StudentMapper::toDTO).toList();
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = repository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        return StudentMapper.toDTO(student);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {

        Student student = repository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        student.setName(studentDTO.getStudentName());
        student.setEmail(studentDTO.getMailId());
        student.setCourse(studentDTO.getCourse());
        return StudentMapper.toDTO(repository.save(student));
    }

    @Override
    public String deleteStudent(Long id) {
        Student student = repository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        repository.delete(student);
        return "deleted :)";
    }

}
