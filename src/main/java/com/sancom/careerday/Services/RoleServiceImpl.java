package com.sancom.careerday.Services;


import com.sancom.careerday.Entities.Role;
import com.sancom.careerday.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll(String roleName) {
        List<Role> result = null;
        if (roleName != null)
            result = roleRepository.findAllByName(roleName);
        else
            result = roleRepository.findAll();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Role>();
        }
    }

    @Override
    public List<Role> findByIds(List<Long> ids) {
        return roleRepository.findByIds(ids);
    }



    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findById(Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            return optionalRole.get();
        }

        throw new IllegalArgumentException("Given role with id=" + id + " does not exists.");


    }

    @Override
    public void deleteById(Long id) {

        roleRepository.deleteById(id);

    }
}
