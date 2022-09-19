package com.application.app1.service;

import com.application.app1.model.User;
import com.application.app1.model.UserProfile;
import com.application.app1.repository.UserProfileRepository;
import com.application.app1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public void addUser(User user) {
        if(userRepository.findById(user.getId()).isEmpty())
               userRepository.save(user);
        else
            throw new InvalidParameterException("User already registered");
            }

    @Override
    public String getPet(Long id) {
        return userProfileRepository.findById(id).get().getPet();
    }
    public String getUserDetails(String email){
//        if(userProfileRepository.findByEmail(email).isEmpty())
//            return "User not registered";
//        else
        return userProfileRepository.findByEmail(email).toString();
    }

    @Override
    public String validLogin(Long id, String password) throws NoSuchElementException {
        User user= userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not registered"));

        if(user.getId()==id && user.getPassword().equals(password))
            return "Welcome";
        else
            return "Incorrect credentials";
    }

    @Override
    public void addUserDetails(UserProfile userProfile) {
         userProfileRepository.save(userProfile);
    }
}
