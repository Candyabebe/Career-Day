package com.sancom.careerday.Services;
import com.sancom.careerday.Entities.User;

public interface UserService {

    void deleteUser(User user);

    User save(User user);

    User findUserByEmail(String email);

    User findUserByUsernameAndPassword(String username, String password);

    User findByUserId(Long userId);

}
