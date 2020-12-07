package com.sancom.careerday.Services;

import com.sancom.careerday.Entities.Job;
import com.sancom.careerday.Repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JobServiceImpl implements JobService{
    @Autowired
    private JobRepository repository;

    @Override
    public Job save(Job job) {
        return repository.save(job);
    }

    @Override
    public Job findById(Long id) throws Exception {
        Optional<Job> optionalJob=repository.findById(id);
        return optionalJob
                .map((vaue) -> optionalJob.get())
                .orElseThrow(() -> new Exception("Job Selected does not exist!"));
    }

    @Override
    public List<Job> getAllJobs() {
        return repository.findAll();
    }

    @Override
    public void deleteJobById(Long id) {
        repository.deleteById(id);
    }
}
