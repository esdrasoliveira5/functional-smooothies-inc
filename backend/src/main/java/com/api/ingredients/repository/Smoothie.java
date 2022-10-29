package com.api.ingredients.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Smoothie {

  private String name;

  private ArrayList<String> ingredients;

  public Smoothie(String name, ArrayList<String> ingredients) {
    this.setingredients(ingredients);
    this.setName(name);
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<String> getIngredients() {
    return ingredients;
  }

  public void setingredients(ArrayList<String> ingredients) {
    this.ingredients = ingredients;
  }

  public Boolean isSmoothie(String name) {
    return this.name.equals(name);
  }

  public String ingredientList(List<String> ingredients) {
    List<String> newIngredients =
        ingredients.stream().map(i -> i.trim().replace("-", "")).collect(Collectors.toList());
    String string = this.ingredients.stream().filter(i -> !newIngredients.contains(i))
        .map(Object::toString).collect(Collectors.joining(","));
    return string;
  }

}
