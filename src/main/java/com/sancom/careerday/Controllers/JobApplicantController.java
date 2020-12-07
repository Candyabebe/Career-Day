package com.sancom.careerday.Controllers;

import com.sancom.careerday.Entities.EducationLevel;
import com.sancom.careerday.Entities.JobApplicant;
import com.sancom.careerday.Payload.JobApplicantResponse;
import com.sancom.careerday.Services.JobApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
@Controller
public class JobApplicantController extends BaseController {
    @Autowired
    private JobApplicantService jobApplicantService;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody JobApplicantResponse applicantResponse) {
        try {
            JobApplicant applicant = new JobApplicant();
            if (applicantResponse.getId()!= null) {
                applicant = jobApplicantService.findById(applicant.getId());
            }
            applicant.setEmail(applicantResponse.getEmail());
            applicant.setFirst_name(applicantResponse.getFirst_name());
            applicant.setLast_name(applicantResponse.getLast_name());
            applicant.setEmail(applicantResponse.getEmail());
            applicant.setPhone(applicantResponse.getPhone());
            applicant.setYears_of_experience(applicantResponse.getYears_of_experience());
            if (applicantResponse.getEducation_level().equalsIgnoreCase("POST_GRADUATE")) {
                applicant.setEducation_level(EducationLevel.POST_GRADUATE);
            } else if (applicantResponse.getEducation_level().equalsIgnoreCase("GRADUATE")) {
                applicant.setEducation_level(EducationLevel.GRADUATE);

            } else if (applicantResponse.getEducation_level().equalsIgnoreCase("HIGH_SCHOOL")) {
                applicant.setEducation_level(EducationLevel.HIGH_SCHOOL);

            } else if (applicantResponse.getEducation_level().equalsIgnoreCase("DIPLOMA")) {
                applicant.setEducation_level(EducationLevel.DIPLOMA);

            } else if (applicantResponse.getEducation_level().equalsIgnoreCase("HIGHER_DIPLOMA")) {
                applicant.setEducation_level(EducationLevel.HIGHER_DIPLOMA);

            } else if (applicantResponse.getEducation_level().equalsIgnoreCase("POST_GRADUATE_DIPLOMA")) {
                applicant.setEducation_level(EducationLevel.POST_GRADUATE_DIPLOMA);
            }
            applicant = jobApplicantService.save(applicant);

            return sendResponse(true, "successfully registered!");

        } catch (Exception e) {
            e.printStackTrace();
            return sendResponse(false, "An error ocurred " + e.getLocalizedMessage());
        }

    }
}
