package com.gtb.quiz.answear.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    private String description;
    private long year;
    private String title;
    private long userId;
}
