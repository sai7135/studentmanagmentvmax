package com.vmax.schoolmanagment.service;

import com.vmax.schoolmanagment.dtos.MarkDto;
import com.vmax.schoolmanagment.dtos.StudentDto;
import com.vmax.schoolmanagment.models.Mark;
import com.vmax.schoolmanagment.models.Student;
import com.vmax.schoolmanagment.repository.MarkRepo;
import com.vmax.schoolmanagment.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarkService {
    private final MarkRepo markRepo;
    private final StudentRepo studentRepo;

    public MarkDto saveMarks(MarkDto markDto){

        Optional<Student> student = this.studentRepo.findById(markDto.getStudent().getId());
        Student retrivedStudent = student.get();
        Mark mark = Mark.builder()
                .student(retrivedStudent)
                .subject(markDto.getSubject())
                .marks(markDto.getMarks())
                .build();

        Mark savedMark = this.markRepo.save(mark);
        return MarkDto.builder()
                .id(savedMark.getId())
                .student(StudentDto.builder().id(savedMark.getStudent().getId()).build())
                .subject(savedMark.getSubject())
                .marks(mark.getMarks()).build();
    }

    public List<MarkDto> getMarks(int studentId){
        Optional<Student> student = this.studentRepo.findById(studentId);
        if(student.isPresent()){
            List<Mark> marks = this.markRepo.findMarkByStudent(student.get());
            List<MarkDto> retrivedMarks = marks.stream().map(m->MarkDto.builder()
                    .subject(m.getSubject())
                    .id(m.getId())
                    .marks(m.getMarks())
                    .build()).collect(Collectors.toList());
            return retrivedMarks;
        }
        return null;
    }
}
