package com.sancom.careerday.Repositories;

import com.sancom.careerday.Entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
