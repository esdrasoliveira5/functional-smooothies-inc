package com.api.ingredients.service;

import org.springframework.stereotype.Service;
import com.api.ingredients.dto.SmoothieDto;

@Service
public class SmoothieService {

  public SmoothieDto create(SmoothieDto smoothie) {
    return smoothie;
  }
}
