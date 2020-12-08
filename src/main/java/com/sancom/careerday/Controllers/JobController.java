package com.sancom.careerday.Controllers;

import com.sancom.careerday.Entities.Job;
import com.sancom.careerday.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController extends BaseController {
    @Autowired
    JobService jobService;

    @PostMapping("/createJob")
    public ResponseEntity createJob(@RequestBody Job jobResponse) {
        try {
            Job job = new Job();
            if (jobResponse.getId() != null) {
                job = jobService.findById(jobResponse.getId());
            }
            job.setDescription(jobResponse.getDescription());
            job.setEducation_level_needed(jobResponse.getEducation_level_needed());
            job.setName(jobResponse.getName());
            job.setYears_of_experience_needed(jobResponse.getYears_of_experience_needed());
            job.setInterview_date(jobResponse.getInterview_date());
            job.setInterview_start_time(jobResponse.getInterview_start_time());
            job.setInterview_end_time(jobResponse.getInterview_end_time());
            job.setJobType(jobResponse.getJobType());
            job.setStatus(jobResponse.getStatus());
            job = jobService.save(job);

            return ResponseEntity.ok().body(job);

        } catch (Exception e) {
            e.printStackTrace();
            return sendResponse(false, "An error ocurred " + e.getLocalizedMessage());
        }

    }

    @DeleteMapping("/deleteJob/{id}")
    public ResponseEntity deleteApplication(@PathVariable Long id) {
        try {
            Job jobResponse=jobService.findById(id);
            if (jobResponse.getId() != null) {
                jobService.deleteJobById(jobResponse.getId());
            }
            return sendResponse(true, "successfully Deleted the Job!");

        } catch (Exception e) {
            e.printStackTrace();
            return sendResponse(false, "An error ocurred " + e.getLocalizedMessage());
        }

    }

    @PostMapping("/updateJob/{id}")
    public ResponseEntity updateApplication(@RequestBody Job jobResponse) {
        try {
            Job job = new Job();
            if (jobResponse.getId() != null) {
                job = jobService.findById(jobResponse.getId());
                job.setDescription(jobResponse.getDescription());
                job.setEducation_level_needed(jobResponse.getEducation_level_needed());
                job.setName(jobResponse.getName());
                job.setYears_of_experience_needed(jobResponse.getYears_of_experience_needed());
                job.setInterview_date(jobResponse.getInterview_date());
                job.setInterview_start_time(jobResponse.getInterview_start_time());
                job.setInterview_end_time(jobResponse.getInterview_end_time());
                job.setJobType(jobResponse.getJobType());
                job.setStatus(jobResponse.getStatus());
                job = jobService.save(job);
                return ResponseEntity.ok().body(job);
            } else {
                return sendResponse(false, "We could not find this application!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return sendResponse(false, "An error ocurred " + e.getLocalizedMessage());
        }
    }

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.getAllJobs();
    }

    @GetMapping("/applications/{id}")
    ResponseEntity findById(@PathVariable Long id) {
        try {
            Job job = jobService.findById(id);
            if (job != null) {
                return ResponseEntity.ok().body(job);
            }else {
                return sendResponse(false, "We could not find this application!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return sendResponse(false, "An error ocurred " + e.getLocalizedMessage());
        }
    }


}
