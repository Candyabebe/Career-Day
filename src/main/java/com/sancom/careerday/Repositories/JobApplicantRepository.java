package com.sancom.careerday.Repositories;

import com.sancom.careerday.Entities.JobApplicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicantRepository extends JpaRepository<JobApplicant,Long> {
}
