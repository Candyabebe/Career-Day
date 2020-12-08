package com.sancom.careerday.Repositories;


import com.sancom.careerday.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select  r from Role  r where r.name like %?1%")
    List<Role> findAllByName(String name);

    Role findByName(String name);

    @Override
    void delete(Role role);

    @Query("select  r from Role r where r.id in (?1)")
    List<Role> findByIds(List<Long> ids);



}
