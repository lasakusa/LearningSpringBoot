package com.example.LearningSpringBoot.Entity;

public class Weather {
    private double latitude;
    private double longitude;
    private CurrentWeatherData current;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public CurrentWeatherData getCurrent() {
        return current;
    }

    public void setCurrent(CurrentWeatherData current) {
        this.current = current;
    }
}
