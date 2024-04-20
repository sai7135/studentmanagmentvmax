package com.vmax.schoolmanagment.controller;

import com.vmax.schoolmanagment.dtos.MarkDto;
import com.vmax.schoolmanagment.dtos.StudentDto;
import com.vmax.schoolmanagment.service.MarkService;
import com.vmax.schoolmanagment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
@RequiredArgsConstructor
public class MarkController {
    private final MarkService markService;
    @PostMapping("/add")
    public ResponseEntity<MarkDto> addNewMarks(@RequestBody MarkDto marksData){
        MarkDto retrivedMarks = this.markService.saveMarks(marksData);
        return new ResponseEntity<>(retrivedMarks, HttpStatus.CREATED);
    }

    @GetMapping("/getMarks/{id}")
    public ResponseEntity<List<MarkDto>> getMargs(@PathVariable Integer id){
        List<MarkDto> marks = this.markService.getMarks(id);
        return new ResponseEntity<>(marks,HttpStatus.OK);
    }
}
