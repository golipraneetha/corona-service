package com.learning.coronatracker.controllers;

import com.learning.coronatracker.models.LocationStats;
import com.learning.coronatracker.services.CoronaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaDataService coronaDataService;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> locationStatsList = coronaDataService.getAllStats();
        int totalCases = locationStatsList.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = locationStatsList.stream().mapToInt(stat -> stat.getDiffFromPreviousDay()).sum();
        model.addAttribute("locationStats", locationStatsList);
        model.addAttribute("totalReportedCases", totalCases);
        model.addAttribute("totalNewCases", totalNewCases);
        return "home";
    }
}
