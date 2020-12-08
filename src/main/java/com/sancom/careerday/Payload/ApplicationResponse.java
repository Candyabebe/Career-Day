package com.sancom.careerday.Payload;

import com.sancom.careerday.Entities.Job;
import com.sancom.careerday.Entities.JobApplicant;
import com.sancom.careerday.Entities.JobSataus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationResponse {
    private Long id;
     private Job job;
     private JobApplicant jobApplicant;
     private Date date_applied;
}
