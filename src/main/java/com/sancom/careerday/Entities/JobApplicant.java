package com.sancom.careerday.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column private String first_name;
    @Column private String last_name;
    @Column private String email;
    @Column private String phone;
    @Column private String education_level;
    @Column private int years_of_experience;

}
