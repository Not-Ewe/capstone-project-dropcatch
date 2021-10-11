package org.launchcode.DropCatch.controllers;

import org.launchcode.DropCatch.models.PinballMachines;
import org.launchcode.DropCatch.models.User;
import org.launchcode.DropCatch.models.data.HighScoreRepository;
import org.launchcode.DropCatch.models.HighScores;
import org.launchcode.DropCatch.models.data.PinballMachineRepository;
import org.launchcode.DropCatch.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("pinball_machines")
public class PinballMachineController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PinballMachineRepository pinballMachineRepository;

    @Autowired
    private HighScoreRepository highScoreRepository;

    @GetMapping("add")
    public String createPinballMachine(Model model, @RequestParam int userId) {

        model.addAttribute("userId", userId);
        model.addAttribute(new PinballMachines());
        model.addAttribute(new HighScores());
        return "pinball_machines/add";
    }

    @GetMapping("display_all")
    public String displayAllMachines(Model model) {
        return "pinball_machines/display_all";
    }

    @PostMapping("add")
    public String addPinballMachine(Model model,
                                    @RequestParam String machineName,
                                    @RequestParam(required = false, defaultValue = "Unknown") String machineLocation,
                                    @RequestParam String highScore,
                                    @RequestParam int userId,
                                    @ModelAttribute User user,
                                    @ModelAttribute @Valid PinballMachines pinballMachines,
                                    @ModelAttribute @Valid HighScores highScores,
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
            model.addAttribute("machineAdded", "Machine Successfully Added!!");
            model.addAttribute("userId", userId);
            pinballMachineRepository.save(pinballMachines);
            highScores.setHighScore(highScoreToInt);
            highScores.setMachineId(pinballMachines.getId());
            highScores.setUserId(userId);
            highScoreRepository.save(highScores);
        }
        Optional<User> currentUser = userRepository.findById(userId);
//        userId= userRepository.findById(userId).get();


        return "pinball_machines/add";
    }
}
