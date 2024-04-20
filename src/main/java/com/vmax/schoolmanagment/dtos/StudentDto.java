package com.vmax.schoolmanagment.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private Integer id;

    private String firstName;

    private String lastName;

    private String section;

    private Integer className;
}
