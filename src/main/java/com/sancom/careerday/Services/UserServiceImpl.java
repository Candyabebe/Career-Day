package com.sancom.careerday.Services;


import com.sancom.careerday.Entities.User;
import com.sancom.careerday.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public void deleteUser(final User user) {

        userRepository.delete(user);
    }


    @Override
    public User findUserByEmail(final String email) {
        return userRepository.findByUsername(email);
    }

    @Override
    public List<User> findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }


    public User save(User user) {
        return userRepository.save(user);
    }


    @Override
    public User findByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        }

        throw new IllegalArgumentException("Given user with userId=" + userId + " does not exists.");
    }


}
