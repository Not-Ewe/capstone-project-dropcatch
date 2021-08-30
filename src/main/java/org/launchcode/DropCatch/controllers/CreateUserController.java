package org.launchcode.DropCatch.controllers;

import org.launchcode.DropCatch.models.User;
import org.launchcode.DropCatch.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("index")
    public String createUser(Model model) {
        model.addAttribute(new User());

        return "";
    }






















//    public String createUser() {
//    }
//    public User createUser(@RequestParam("exampleInputEmail1") String email, @RequestParam(
//            "exampleInputPassword1") String password) {
//
//        User user = new User();
//        user.setUserEmail(user.getUserEmail());
//        return user;

    }

