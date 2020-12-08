package com.sancom.careerday.Services;


import com.sancom.careerday.Entities.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll(String roleName);

    List<Role> findByIds(List<Long> ids);


    Role save(Role role);

    Role findById(Long id);

    void deleteById(Long id);

}
