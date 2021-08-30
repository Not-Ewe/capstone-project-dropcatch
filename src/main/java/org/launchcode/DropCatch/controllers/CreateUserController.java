package org.launchcode.DropCatch.controllers;

import org.launchcode.DropCatch.models.User;
import org.launchcode.DropCatch.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user/")
public class CreateUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("index")
//    @ResponseBody
    public String createUser(Model model) {
        model.addAttribute(new User());
        return "user/index";
    }

//    @RequestMapping(value = "index", method = {RequestMethod.GET})
//    public String testMethod(@ModelAttribute User user, Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            return "index";
//        }
//        return "/user-home";
//    }


//    public String createUser() {
//    }
//    public User createUser(@RequestParam("exampleInputEmail1") String email, @RequestParam(
//            "exampleInputPassword1") String password) {
//
//        User user = new User();
//        user.setUserEmail(user.getUserEmail());
//        return user;

    @PostMapping("index")
    public String processAddEmployerForm(Model model, @ModelAttribute @Valid User user,
                                         Errors errors ) {

        if (!user.getUserPassword().matches(user.getVerifyPassword())) {
            errors.hasErrors();
        }
        if (errors.hasErrors()) {
            return "user/index";
        }

        userRepository.save(user);
        return "user/user-home";
    }

    }

