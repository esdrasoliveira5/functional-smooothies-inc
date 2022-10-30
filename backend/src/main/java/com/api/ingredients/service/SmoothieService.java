package com.api.ingredients.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.api.ingredients.dto.SmoothieDto;
import com.api.ingredients.repository.Smoothie;

@Service
public class SmoothieService {

  Smoothie classic = new Smoothie("Classic", new ArrayList<>(
      Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey")));
  Smoothie freezie = new Smoothie("Freezie", new ArrayList<>(
      Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt")));
  Smoothie greenie = new Smoothie("Greenie", new ArrayList<>(
      Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice")));
  Smoothie justDesserts = new Smoothie("Just Desserts",
      new ArrayList<>(Arrays.asList("banana", "ice cream", "chocolate", "peanut", "cherry")));

  public SmoothieDto create(SmoothieDto smoothie) {
    SmoothieDto result = new SmoothieDto();
    try {
      if (smoothie.getIngredient() == "") {
        throw new IllegalArgumentException("Empty Input");
      } ;

      List<String> splitSmoothie =
          new ArrayList<String>(Arrays.asList(smoothie.getIngredient().split(",")));

      String smoothieName = splitSmoothie.get(0);

      if (classic.isSmoothie(smoothieName)) {
        String ingredients = this.isIngredient(splitSmoothie, classic);
        result.setIngredient(ingredients);

      } else if (freezie.isSmoothie(smoothieName)) {
        String ingredients = this.isIngredient(splitSmoothie, freezie);
        result.setIngredient(ingredients);
      } else if (greenie.isSmoothie(smoothieName)) {
        String ingredients = this.isIngredient(splitSmoothie, greenie);
        result.setIngredient(ingredients);
      } else if (justDesserts.isSmoothie(smoothieName)) {
        String ingredients = this.isIngredient(splitSmoothie, justDesserts);
        result.setIngredient(ingredients);
      } else {
        throw new IllegalArgumentException("Not Found Smoothie");
      }

    } catch (Exception e) {
      throw new IllegalArgumentException(e.getMessage());
    }
    return result;
  }

  private String isIngredient(List<String> ingredients, Smoothie smoothie) {
    ingredients.remove(0);
    List<String> palavra =
        ingredients.stream().filter(i -> !i.trim().startsWith("-")).collect(Collectors.toList());

    if (!palavra.isEmpty()) {
      throw new IllegalArgumentException("Aditional Ingredient Not Supported");
    }
    return smoothie.ingredientList(ingredients);
  }
}
