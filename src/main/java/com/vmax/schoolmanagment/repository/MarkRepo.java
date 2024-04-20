package com.vmax.schoolmanagment.repository;

import com.vmax.schoolmanagment.models.Mark;
import com.vmax.schoolmanagment.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepo extends JpaRepository<Mark,Integer> {
    List<Mark> findMarkByStudent(Student student);
}
