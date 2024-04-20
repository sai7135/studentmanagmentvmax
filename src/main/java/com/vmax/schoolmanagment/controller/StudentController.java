package com.vmax.schoolmanagment.controller;

import com.vmax.schoolmanagment.dtos.RankDto;
import com.vmax.schoolmanagment.dtos.StudentDto;
import com.vmax.schoolmanagment.models.Student;
import com.vmax.schoolmanagment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @PostMapping("add")
    public ResponseEntity<StudentDto> addNewStudent(@RequestBody StudentDto studentDto){
        StudentDto retrivedStudent = this.studentService.saveStudentData(studentDto);
        return new ResponseEntity<>(retrivedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer id ){
        StudentDto retrivedStudent = this.studentService.getStudentById(id);
        return new ResponseEntity<>(retrivedStudent, HttpStatus.OK);
    }

    @GetMapping("/getStudentRank/{id}")
    public ResponseEntity<List<RankDto>> getRank(@PathVariable Integer id){
       List<RankDto> rankDtos = this.studentService.getStudentRank(id);
       return new ResponseEntity<>(rankDtos,HttpStatus.OK);
    }
}
