package com.example.LearningSpringBoot.service;

import com.example.LearningSpringBoot.Entity.CatFact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CatFactService {

    @Autowired
    private RestTemplate restTemplate;

    public CatFact fetchCatFact() {
        String url = "https://catfact.ninja/fact";
        return restTemplate.getForObject(url, CatFact.class);
    }
}
