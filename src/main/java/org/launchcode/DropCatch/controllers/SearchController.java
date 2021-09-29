package org.launchcode.DropCatch.controllers;

import org.launchcode.DropCatch.models.PinballMachines;
import org.launchcode.DropCatch.models.data.PinballMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.expression.Lists;

import java.util.List;
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

        // Search all
        if (searchType.equals("all") || searchTerm.equals("") || searchTerm.toLowerCase(Locale.ROOT).equals("all")){
            machines = pinballMachineRepository.findAll();
            model.addAttribute("machines", machines);
            return "search/results";
        }
        // Search by Machine Name
        if (searchType.equals("machineName")) {
            machines = pinballMachineRepository.findByMachineNameLike("%" +
                            searchTerm.toLowerCase(Locale.ROOT) + "%");
            if (!machines.iterator().hasNext()) {
                model.addAttribute("errors", "No matches found");
                return "search/results";
            }
            model.addAttribute("machines", machines);
            return "search/results";
        }

        // Search by Machine Location
        if (searchType.equals("machineLocation")) {
            machines = pinballMachineRepository.findByMachineLocationLike("%" +
                    searchTerm.toLowerCase(Locale.ROOT) + "%");
            if (!machines.iterator().hasNext()) {
                model.addAttribute("errors", "No matches found");
                return "search/results";
            }
            model.addAttribute("machines", machines);

//            return "search/results";
        }
        return "search/results";
    }
}
