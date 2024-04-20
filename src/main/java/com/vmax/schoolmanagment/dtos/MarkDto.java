package com.vmax.schoolmanagment.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {
    private Integer id;

    private StudentDto student;

    private String subject;

    private Integer marks;
}
