package com.sancom.careerday.Controllers;

import com.sancom.careerday.Entities.Applications;
import com.sancom.careerday.Entities.Job;
import com.sancom.careerday.Payload.ApplicationResponse;
import com.sancom.careerday.Services.ApplicationService;
import com.sancom.careerday.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationsController extends BaseController {
    @Autowired
    ApplicationService applicationService;

    @Autowired
    private JobService jobService;

    @PostMapping("/apply")
    public ResponseEntity apply(@PathParam("id") Long id) {
        try {
            logger.info("YES HERE APPLYING");
            Applications application = new Applications();
            Job job = jobService.findById(id);
            application.setJob(job);
            application.setDate_applied(LocalDate.now());
            //application.setJobApplicant(applicantResponse.getJobApplicant());
            application = applicationService.save(application);

            return sendResponse(true, "Successfully applied");

        } catch (Exception e) {
            e.printStackTrace();
            return sendResponse(false, "An error ocurred " + e.getLocalizedMessage());
        }

    }

    @DeleteMapping("/deleteApplication/{id}")
    public ResponseEntity deleteApplication(@PathVariable Long id) {
        try {
            Applications applicantResponse=applicationService.findById(id);
            if (applicantResponse.getId() != null) {
                applicationService.deleteById(applicantResponse.getId());
            }
            return sendResponse(true, "successfully Deleted the application!");

        } catch (Exception e) {
            e.printStackTrace();
            return sendResponse(false, "An error ocurred " + e.getLocalizedMessage());
        }

    }

    @PostMapping("/updateApplication/{id}")
    public ResponseEntity updateApplication(@RequestBody Applications applicantResponse) {
        try {
            Applications application = new Applications();
            if (applicantResponse.getId() != null) {
                application = applicationService.findById(applicantResponse.getId());
                application.setJob(applicantResponse.getJob());
                applicationService.save(application);
                return ResponseEntity.ok().body(application);
            } else {
                return sendResponse(false, "We could not find this application!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return sendResponse(false, "An error ocurred " + e.getLocalizedMessage());
        }
    }

    @GetMapping("/applications")
    public List<Applications> findAll() {
        return applicationService.findAll();
    }

    @GetMapping("/applications/{id}")
    ResponseEntity findById(@PathVariable Long id) {
        try {
            Applications applications = applicationService.findById(id);
            if (applications != null) {
               return ResponseEntity.ok().body(applications);
            }else {
                return sendResponse(false, "We could not find this application!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return sendResponse(false, "An error ocurred " + e.getLocalizedMessage());
        }
    }
}
