package com.vmax.schoolmanagment.service;

import com.vmax.schoolmanagment.dtos.MarkDto;
import com.vmax.schoolmanagment.dtos.RankDto;
import com.vmax.schoolmanagment.dtos.StudentDto;
import com.vmax.schoolmanagment.models.Student;
import com.vmax.schoolmanagment.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final MarkService markService;
    public StudentDto saveStudentData(StudentDto studentDto){
        Student student = Student.builder()
                .className(studentDto.getClassName())
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .section(studentDto.getSection()).build();
        Student savedStudent = this.studentRepo.save(student);
        StudentDto savedStudentDto = StudentDto.builder()
                .className(savedStudent.getClassName())
                .firstName(savedStudent.getFirstName())
                .lastName(savedStudent.getLastName())
                .id(savedStudent.getId())
                .section(savedStudent.getSection()).build();
        return savedStudentDto;
    }

    public StudentDto getStudentById(Integer id){
        Optional<Student> student = this.studentRepo.findById(id);
        if(student.isPresent()){
            Student retrivedStudent= student.get();
            return StudentDto.builder()
                    .className(retrivedStudent.getClassName())
                    .firstName(retrivedStudent.getFirstName())
                    .lastName(retrivedStudent.getLastName())
                    .id(retrivedStudent.getId())
                    .section(retrivedStudent.getSection()).build();
        }
        return null;
    }

    public List<RankDto> getStudentRank(Integer id){
        List<RankDto> retrivedRank= this.studentRepo.getRanks(id);
        return retrivedRank;
    }
}
