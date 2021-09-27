package org.launchcode.DropCatch.controllers;

import org.launchcode.DropCatch.models.PinballMachines;
import org.launchcode.DropCatch.models.data.PinballMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
@RequestMapping("pinball_machines")
public class PinballMachineController {

    @Autowired
    private PinballMachineRepository pinballMachineRepository;

    @GetMapping("add")
    public String createPinballMachine(Model model) {
        model.addAttribute(new PinballMachines());
        return "pinball_machines/add";
    }

    @PostMapping("add")
    public String addPinballMachine(Model model,
                                    @RequestParam String machineName,
                                    @RequestParam String highScore,
                                    @ModelAttribute @Valid PinballMachines pinballMachines,
                                    Errors errors){

        // Check if fields are blank
        if (machineName.isBlank() || highScore.isBlank()) {
            model.addAttribute("errors", "You gotta name the game");
            model.addAttribute("scoreErrors", "And ya gotta have a score...");
            return "pinball_machines/add";
        }

        // Check if highScore is an int
        try {
            Integer.parseInt(highScore);
        } catch (NumberFormatException e) {
            model.addAttribute("scoreErrors", "Score must be a number");
            return "pinball_machines/add";
        }

        // Convert highScore to int, check if >0, save to repository
        int highScoreToInt = Integer.valueOf(highScore);
        if (highScoreToInt < 0) {
            model.addAttribute("scoreErrors", "Can't have a negative score");
            return "pinball_machines/add";
        } else {
            pinballMachineRepository.save(pinballMachines);
        }

        return "user_home";
    }

}
