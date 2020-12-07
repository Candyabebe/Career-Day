package com.sancom.careerday.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private JobType jobType;

    @Column
    private String name;
    @Column
    private  String description;
    @Column(name="Years_of_experience")
    private int years_of_experience_needed;
    @Enumerated(EnumType.STRING)
    @Column(name="Education_leve")
    private EducationLevel education_level_needed;
    @Column(unique = true)
    private LocalDate interview_date;

    @Enumerated(EnumType.STRING)
    private JobSataus status;
    @Column
    private LocalDate interview_start_time;
    @Column
    private LocalDate interview_end_time;




}
