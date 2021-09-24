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


        if (machineName.isBlank()) {
            model.addAttribute("errors", "You gotta put SOMETHING in here...");
            return "pinball_machines/add";
        } else if (highScore.isBlank() || highScore.startsWith("-")) {
            model.addAttribute("errors","You at least scored 0...");
            return "pinball_machines/add";
        } else {
            pinballMachineRepository.save(pinballMachines);
        }
        return "index";

    }

}
