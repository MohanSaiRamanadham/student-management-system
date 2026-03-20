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

        Student student = StudentMapper.toEntity(getStudentById(id));
        student.setName(studentDTO.getStudentName());
        student.setEmail(student.getEmail());
        student.setCourse(student.getCourse());
        return StudentMapper.toDTO(repository.save(student));
    }

    @Override
    public String deleteStudent(Long id) {
        repository.deleteById(id);
        return "deleted :)";
    }

}
