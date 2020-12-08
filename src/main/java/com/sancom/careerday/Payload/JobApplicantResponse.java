package com.sancom.careerday.Payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicantResponse {
    private Long id;
    private String first_name;

    private String last_name;

    private String email;

    private String phone;

    private String education_level;

    private int years_of_experience;

    private String password;
    private String confirm_password;
}
