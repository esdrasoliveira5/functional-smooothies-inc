package com.api.ingredients.service;

import org.springframework.stereotype.Service;
import com.api.ingredients.dto.SmoothieDto;

@Service
public class SmoothieService {

  public SmoothieDto create(SmoothieDto smoothie) {


    try {


      if (smoothie.getIngredient() == "") {
        throw new IllegalArgumentException("Empty Input");
      } ;

      String ingredient_smoothie[] = smoothie.getIngredient().split(",");

    } catch (ArithmeticException e) {
      System.out.println("Erro tratado");
      System.out.println(e);
    } finally {
      System.out.println("Bloco finally");
    }

    return smoothie;
  }
}
