package com.api.ingredients.repository;

public class Greenie {
  private String name = "Greenie";

  private String[] ingredients =
      {"green apple", "lime", "avocado", "spinach", "ice", "apple juice"};


  public String[] getIngredients() {
    return ingredients;
  }

  public String getName() {
    return name;
  }
}
