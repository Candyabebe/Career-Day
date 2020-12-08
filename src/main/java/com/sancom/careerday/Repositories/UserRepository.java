package com.sancom.careerday.Repositories;


import com.sancom.careerday.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String email);


    User findByUsernameAndPassword(String username, String password);




}
