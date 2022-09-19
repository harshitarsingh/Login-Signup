package com.application.app1.controller;

import com.application.app1.model.User;

import com.application.app1.model.UserProfile;
import com.application.app1.repository.UserRepository;
import com.application.app1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.NoSuchElementException;


@RestController
public class HomeController {

    @Autowired
    UserServiceImpl userServiceImpl;


    @PostMapping("/signup")
    public HttpStatus registerUser(@RequestBody User user)
    {
        userServiceImpl.addUser(user);
        return HttpStatus.OK;
    }

    @GetMapping("/mydetails/{email}")
    public String getUserDetails(@PathVariable String email) throws UserPrincipalNotFoundException {

        return userServiceImpl.getUserDetails(email);

    }

    @GetMapping("/login")
    public String userLogin(@RequestBody User user) throws NoSuchElementException
    {
        return userServiceImpl.validLogin(user.getId(), user.getPassword());
    }

    @PostMapping("/login/mydetails")
    public HttpStatus addUserDetails(@RequestBody UserProfile userProfile) throws UserPrincipalNotFoundException {

        userServiceImpl.addUserDetails(userProfile);
        return HttpStatus.OK;
    }


    @GetMapping("/login/pet/{id}")
    public String getPet(@PathVariable Long id)
    {
        return userServiceImpl.getPet(id);
    }


}
