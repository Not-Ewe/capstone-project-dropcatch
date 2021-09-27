package org.launchcode.DropCatch.controllers;

import org.launchcode.DropCatch.models.data.PinballMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private PinballMachineRepository pinballMachineRepository;

    @RequestMapping("search")
    public String search(Model model) {
        return "search/search";
    }

//    @PostMapping("search")
//    public String displaySearchResults(Model model, @RequestParam String searchTerm,
//                                       @RequestParam String searchType) {
//
//        if (searchType == )
//        return "search/results";
//    }
}
