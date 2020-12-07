package com.sancom.careerday.Controllers;

import com.sancom.careerday.Entities.Applications;
import com.sancom.careerday.Payload.ApplicationResponse;
import com.sancom.careerday.Services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class ApplicationsController extends BaseController{
    @Autowired
    ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity apply(@Valid @RequestBody ApplicationResponse applicantResponse) {
        try {
            Applications application = new Applications();
            if (applicantResponse.getId()!= null) {
                application = applicationService.findById(application.getId());
            }
            application.setJob(applicantResponse.getJob());
            applicantResponse.setDate_applied(applicantResponse.getDate_applied());
            application.setJobApplicant(applicantResponse.getJobApplicant());

            application = applicationService.save(application);

            return sendResponse(true, "successfully applied for the job!");

        } catch (Exception e) {
            e.printStackTrace();
            return sendResponse(false, "An error ocurred " + e.getLocalizedMessage());
        }

    }

    @PostMapping("/deleteApplication")
    public ResponseEntity deleteApplication(@Valid @RequestBody ApplicationResponse applicantResponse) {
        try {
            if (applicantResponse.getId()!= null) {
                applicationService.deleteById(applicantResponse.getId());
            }
            return sendResponse(true, "successfully Deleted the application!");

        } catch (Exception e) {
            e.printStackTrace();
            return sendResponse(false, "An error ocurred " + e.getLocalizedMessage());
        }

    }
    @PostMapping("/updateApplication")
    public ResponseEntity updateApplication(@Valid @RequestBody ApplicationResponse applicantResponse) {
        try {
            Applications application = new Applications();
            if (applicantResponse.getId()!= null) {
                application=applicationService.findById(applicantResponse.getId());
                application.setJob(applicantResponse.getJob());
                applicationService.save(application);
            }else {
                return sendResponse(false, "We could not find this application!");
            }

            return sendResponse(true, "successfully Deleted the application!");

        } catch (Exception e) {
            e.printStackTrace();
            return sendResponse(false, "An error ocurred " + e.getLocalizedMessage());
        }

    }
}
