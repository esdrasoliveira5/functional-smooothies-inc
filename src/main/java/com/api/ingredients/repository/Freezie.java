package com.api.ingredients.repository;

public class Freezie {
  private String name = "Freezie";

  private String[] ingredients =
      {"blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt"};


  public String[] getIngredients() {
    return ingredients;
  }

  public String getName() {
    return name;
  }
}
