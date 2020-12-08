package com.sancom.careerday.Repositories;

import com.sancom.careerday.Entities.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationsRepository extends JpaRepository<Applications,Long> {
    @Query(value="select * from Applications a where a.jobApplicant= :jobApplicant", nativeQuery=true)
    List<Applications> findByJobApplicant(@Param("jobApplicant")Long jobApplicantId);

    @Query(value="select * from Applications a where a.job= :job", nativeQuery=true)
    List<Applications> findAppliedJobs(@Param("job")Long job);

    @Modifying
    @Query(value="update Applications a set a.job= :job where a.id = :id", nativeQuery=true)
    void updateApplication(@Param("job")Long jobId,@Param("id") Long id);


}
