package com.college.StudentManagementSystem.service;

import com.college.StudentManagementSystem.dto.StudentDTO;
import com.college.StudentManagementSystem.entity.Student;
import com.college.StudentManagementSystem.mapper.StudentMapper;
import com.college.StudentManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        studentDTO.setStudentName(studentDTO.getStudentName().trim());
        studentDTO.setMailId(studentDTO.getMailId().trim());
        studentDTO.setCourse(studentDTO.getCourse().trim());
        Student student = StudentMapper.toEntity(studentDTO);
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
