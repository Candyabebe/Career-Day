package com.sancom.careerday.Services;
import com.sancom.careerday.Entities.User;

import java.util.List;

public interface UserService {

    void deleteUser(User user);

    User save(User user);

    User findUserByEmail(String email);

    List<User> findUserByUsernameAndPassword(String username, String password);

    User findByUserId(Long userId);

}
