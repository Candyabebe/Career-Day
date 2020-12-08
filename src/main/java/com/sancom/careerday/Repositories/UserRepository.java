package com.sancom.careerday.Repositories;


import com.sancom.careerday.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String email);

    @Query(value ="from User  where username= ?1 and password= ?2")
    //@Query(value ="select * from user u where u.username= ?1 and u.password= ?2",nativeQuery = true)
    List<User> findByUsernameAndPassword(String username, String password);
   // User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);




}
