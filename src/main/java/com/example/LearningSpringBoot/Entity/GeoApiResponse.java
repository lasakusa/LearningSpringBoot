package com.example.LearningSpringBoot.Entity;

import java.util.List;

public class GeoApiResponse {
    private List<GeoLocation> results;

    public List<GeoLocation> getResults() {
        return results;
    }

    public void setResults(List<GeoLocation> results) {
        this.results = results;
    }
}
