package com.examenjava.gender.application;

import java.util.List;

import com.examenjava.gender.domain.entity.Gender;
import com.examenjava.gender.domain.service.GenderService;

public class GenderUseCase {
 private final GenderService genderService;

public GenderUseCase(GenderService genderService) {
    this.genderService = genderService;
}
 public List<Gender> getAllGenders(){
    return genderService.getAllGenders();
 }
}
