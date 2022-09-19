package com.application.app1.service;

import com.application.app1.model.User;
import com.application.app1.model.UserProfile;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public interface UserService {

    String getPet(Long id);

    String validLogin(Long id, String password) throws UserPrincipalNotFoundException;
    void addUser(User user);

    void addUserDetails(UserProfile userProfile);

}
