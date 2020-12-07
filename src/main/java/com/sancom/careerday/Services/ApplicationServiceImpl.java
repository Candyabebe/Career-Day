package com.sancom.careerday.Services;

import com.sancom.careerday.Entities.Applications;
import com.sancom.careerday.Repositories.ApplicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationsRepository repository;
    @Override
    public Applications save(Applications applications) {
        return repository.save(applications);
    }

    @Override
    public Applications findById(Long id) throws Exception{
        Optional<Applications> optionalApplicant=repository.findById(id);
        return optionalApplicant
                .map((value)->optionalApplicant.get())
                .orElseThrow(()-> new Exception("Selected Job Applicant does not exist!"));

    }

    @Override
    public List<Applications> findAll(Applications applications) {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
         repository.deleteById(id);
    }

    @Override
    public List<Applications> findByApplicantId(Long applicantId)throws Exception {
        return repository.findByJobApplicant(applicantId);
    }

    @Override
    public List<Applications> findByJobId(Long jobId)throws Exception {
        return repository.findAppliedJobs(jobId);
    }

    @Override
    public void updateApplicationById(Long jobId,Long applicationId) {
        repository.updateApplication(jobId,applicationId);
    }
}
