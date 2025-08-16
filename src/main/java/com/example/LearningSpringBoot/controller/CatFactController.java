package com.example.LearningSpringBoot.controller;

import com.example.LearningSpringBoot.Entity.CatFact;
import com.example.LearningSpringBoot.service.CatFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CatFactController {

    @Autowired
    private CatFactService catFactService;

    @GetMapping("/cat-fact")
    public String showCatFact(Model model) {
        CatFact fact = catFactService.fetchCatFact();
        model.addAttribute("fact", fact.getFact());
        model.addAttribute("length", fact.getLength());
        return "cat-fact-ui";
    }
    
    @GetMapping("/api/cat-fact")
    @ResponseBody
    public CatFact getCatFactJson() {
        return catFactService.fetchCatFact();
    }

}
