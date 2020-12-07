package com.sancom.careerday.Services;

import com.sancom.careerday.Entities.Applications;

import java.util.List;

public interface ApplicationService {
    Applications save(Applications applications);
    Applications findById(Long id)throws Exception;
    void deleteById(Long id);
    void updateApplicationById(Long jobId,Long applicationId);
    List<Applications>findAll(Applications applications);
    List<Applications>findByApplicantId(Long applicantId) throws Exception;
    List<Applications>findByJobId(Long id) throws Exception;



}
