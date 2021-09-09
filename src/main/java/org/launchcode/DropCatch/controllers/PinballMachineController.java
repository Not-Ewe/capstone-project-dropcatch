package org.launchcode.DropCatch.controllers;

import org.launchcode.DropCatch.models.data.PinballMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("pinball_machines")
public class PinballMachineController {

    @Autowired
    private PinballMachineRepository pinballMachineRepository;

    @GetMapping("add")
    public String createPinballMachine(Model model) {
        return "pinball_machines/add";
    }

}
