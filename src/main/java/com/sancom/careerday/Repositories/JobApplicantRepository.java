package com.sancom.careerday.Repositories;

import com.sancom.careerday.Entities.JobApplicant;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicantRepository extends JpaRepository<JobApplicant,Long> {




}
