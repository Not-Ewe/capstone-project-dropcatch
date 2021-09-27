package org.launchcode.DropCatch.controllers;

import org.launchcode.DropCatch.models.PinballMachines;
import org.launchcode.DropCatch.models.data.PinballMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private PinballMachineRepository pinballMachineRepository;

    @RequestMapping("search")
    public String search(Model model) {
        return "search/search";
    }

    @PostMapping("search")
    public String displaySearchResults(Model model, @RequestParam String searchTerm,
                                       @RequestParam String searchType) {

        Iterable<PinballMachines> machines;

        if (searchType.equals("all") || searchTerm.equals("") || searchTerm.toLowerCase(Locale.ROOT).equals("all")){
            machines = pinballMachineRepository.findAll();
            model.addAttribute("machines", machines);
            return "search/results";
        }
        if (searchType.equals("machineName")) {
            machines = pinballMachineRepository.findByMachineNameLike("%" +
                            searchTerm.toLowerCase(Locale.ROOT) + "%");
            model.addAttribute("machines", machines);
            return "search/results";
        }
        if (searchType.equals("machineLocation")) {
            machines = pinballMachineRepository.findByMachineLocationLike("%" +
                    searchTerm.toLowerCase(Locale.ROOT) + "%");
            model.addAttribute("machines", machines);

            return "search/results";
        }
        return "index";
    }
}
