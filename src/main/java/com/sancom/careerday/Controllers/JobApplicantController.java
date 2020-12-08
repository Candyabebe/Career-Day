package com.sancom.careerday.Controllers;

import com.sancom.careerday.Entities.EducationLevel;
import com.sancom.careerday.Entities.JobApplicant;
import com.sancom.careerday.Entities.Role;
import com.sancom.careerday.Entities.User;
import com.sancom.careerday.Payload.JobApplicantResponse;
import com.sancom.careerday.Services.JobApplicantService;
import com.sancom.careerday.Services.RoleService;
import com.sancom.careerday.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/applicant")
public class JobApplicantController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JobApplicantService jobApplicantService;
    @Autowired
    private UserService userService;
    @Autowired
    RoleService roleService;

    @PostMapping("/register")
    public ModelAndView register(JobApplicantResponse applicantResponse) {
        try {
            JobApplicant applicant = new JobApplicant();
            if (applicantResponse.getId() != null) {
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
            Role role = new Role();
            role.setDescription("APPLICANT");
            role.setName("APPLICANT");
            role = roleService.save(role);
            User user = new User();
            user.setUsername(applicant.getEmail());
            user.setPassword(applicantResponse.getPassword());
            user.setRoles(Collections.singleton(role));
            user.setActive(1);
            user = userService.save(user);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("login");
            return modelAndView;
            // return sendResponse(true, "successfully registered!");

        } catch (Exception e) {
            e.printStackTrace();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("registration");
            return modelAndView;
            //return sendResponse(false, "An error ocurred " + e.getLocalizedMessage());
        }

    }

    @PostMapping("/login")
    public ModelAndView login(JobApplicantResponse applicantResponse) {
        logger.info("email>>>>" + applicantResponse.getEmail());
        logger.info("password>>>>" + applicantResponse.getPassword());
        List<User> users = userService.findUserByUsernameAndPassword(applicantResponse.getEmail(), applicantResponse.getPassword());
        ModelAndView modelAndView = new ModelAndView();
        if(users.isEmpty()){
            modelAndView.setViewName("homePage");
            return modelAndView;
        }
        User user=users.get(0);
        if (user != null) {
            logger.info("PASSED*********");
            modelAndView.setViewName("homePage");
            return modelAndView;
        } else {
            logger.info("FAILED*********");
            modelAndView.setViewName("homePage");
            return modelAndView;
        }

    }

    @GetMapping("/applicants")
    public List<JobApplicant>findAll(){
        return jobApplicantService.getAllJobApplicants();
    }

    @GetMapping("/applicants/{id}")
    JobApplicant findById(@PathVariable Long id) {
        JobApplicant jobApplicant=new JobApplicant();
        try {
           jobApplicant= jobApplicantService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jobApplicant;
    }
    @GetMapping("/updateApplicant/{id}")
    ResponseEntity updateApplicant(@RequestBody JobApplicantResponse applicantResponse, @PathVariable Long id){
        try {
            JobApplicant applicant=new JobApplicant();
            applicant= jobApplicantService.findById(id);
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

            }  else if (applicantResponse.getEducation_level().equalsIgnoreCase("DIPLOMA")) {
                applicant.setEducation_level(EducationLevel.DIPLOMA);

            } else if (applicantResponse.getEducation_level().equalsIgnoreCase("HIGHER_DIPLOMA")) {
                applicant.setEducation_level(EducationLevel.HIGHER_DIPLOMA);

            }else if (applicantResponse.getEducation_level().equalsIgnoreCase("HIGH_SCHOOL")) {
                applicant.setEducation_level(EducationLevel.HIGH_SCHOOL);

            } else if (applicantResponse.getEducation_level().equalsIgnoreCase("POST_GRADUATE_DIPLOMA")) {
                applicant.setEducation_level(EducationLevel.POST_GRADUATE_DIPLOMA);
            }
            applicant = jobApplicantService.save(applicant);
            return ResponseEntity.ok().body(applicant);
        } catch (Exception e) {
            e.printStackTrace();
            return sendResponse(false, "An error ocurred " + e.getLocalizedMessage());
        }
    }
}

