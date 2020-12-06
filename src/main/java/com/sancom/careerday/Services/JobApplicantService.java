package com.sancom.careerday.Services;

import com.sancom.careerday.Entities.JobApplicant;

import java.util.List;

public interface JobApplicantService {
    JobApplicant save(JobApplicant applicant);
    JobApplicant findById(Long id) throws Exception;
    List<JobApplicant> getAllJobApplicants();
    void deleteJobApplicant(Long id);

}
