package com.api.ingredients.repository;

public class Classic {
  private String name = "Classic";

  private String[] ingredients = {"strawberry", "banana", "pineapple", "mango", "peach", "honey"};


  public String[] getIngredients() {
    return ingredients;
  }

  public String getName() {
    return name;
  }
}
