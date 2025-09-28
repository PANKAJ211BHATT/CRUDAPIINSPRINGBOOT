package com.bitGeeksCRUDAPI.CRUDAPI.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitGeeksCRUDAPI.CRUDAPI.Model.StudentModel;
import com.bitGeeksCRUDAPI.CRUDAPI.Repository.StudentRepository;
import com.bitGeeksCRUDAPI.CRUDAPI.dto.StudentDTO;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //GetAllStudents
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Optional<StudentDTO> getStudentById(Long registeration_no ){
        return studentRepository.findById(registeration_no).map(this::mapToDTO);
    }

    public Optional<StudentDTO> updateStudent(Long id, StudentDTO updatedStudentDTO) {
        return studentRepository.findById(id).map(existingStudent -> {
            existingStudent.setName(updatedStudentDTO.getName());
            existingStudent.setEmail(updatedStudentDTO.getEmail());
            StudentModel savedStudent = studentRepository.save(existingStudent);
            return mapToDTO(savedStudent);
        });
    }

    // DELETE student
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        StudentModel student = mapToEntity(studentDTO);
        StudentModel savedStudent = studentRepository.save(student);
        return mapToDTO(savedStudent);
    }
    private StudentDTO mapToDTO(StudentModel student) {
        StudentDTO dto = new StudentDTO(
                student.getRoll_no(),
                student.getName(),
                student.getEmail(),
                student.getPhone()
        );
        dto.setRegisteration_no(student.getRegisteration_no());
        dto.setVersion(student.getVersion());
        return dto;
    }

    // Helper: DTO to Entity
    private StudentModel mapToEntity(StudentDTO studentDTO) {
        return new StudentModel(
                studentDTO.getRoll_no(),
                studentDTO.getName(),
                studentDTO.getEmail(),
                studentDTO.getPhone()
        );
    }

}



