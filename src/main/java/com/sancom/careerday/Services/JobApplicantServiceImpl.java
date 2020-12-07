package com.sancom.careerday.Services;

import com.sancom.careerday.Entities.JobApplicant;
import com.sancom.careerday.Repositories.JobApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class JobApplicantServiceImpl implements JobApplicantService {
   @Autowired
   private JobApplicantRepository repository;

    @Override
    public JobApplicant save(JobApplicant applicant) {
        return repository.save(applicant);
    }

    @Override
    public JobApplicant findById(Long id) throws Exception {
        Optional<JobApplicant>optionalJobApplicant=repository.findById(id);
        return optionalJobApplicant
                .map((value)->optionalJobApplicant.get())
                .orElseThrow(()-> new Exception("Selected Job Applicant does not exist!"));

    }

    @Override
    public List<JobApplicant> getAllJobApplicants() {
        return repository.findAll();
    }

    @Override
    public void deleteJobApplicant(Long id) {
      repository.deleteById(id);
    }

}
