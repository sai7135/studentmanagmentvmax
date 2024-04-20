package com.vmax.schoolmanagment.repository;

import com.vmax.schoolmanagment.dtos.RankDto;
import com.vmax.schoolmanagment.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    @Query("select new com.vmax.schoolmanagment.dtos.RankDto(id,r) from (SELECT s.id as id,(RANK() over( order by sum(m.marks) desc)) as r from Mark m inner join Student s on s.id=m.student.id GROUP BY s.id) where id=:studentId")
    public List<RankDto> getRanks(Integer studentId);
}
