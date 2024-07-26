package com.examenjava.city.application;

import java.util.List;

import com.examenjava.city.domain.entity.City;

public class CityUseCase {
    private final CityUseCase cityUseCase;

    public CityUseCase(CityUseCase cityUseCase) {
        this.cityUseCase = cityUseCase;
    }
    
    public List<City> getAllCities(){
        return cityUseCase.getAllCities();
    }
}
