package com.sancom.careerday.Services;

import com.sancom.careerday.Entities.Job;

import java.util.List;

public interface JobService {
    Job save(Job job);
    Job findById(Long id) throws Exception;
    List<Job>getAllJobs();
    void deleteJobById(Long id);

}
