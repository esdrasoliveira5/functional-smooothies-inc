package com.api.ingredients.dto;

public class SmoothieDto {

  private String ingredient;

  public SmoothieDto() {}

  public SmoothieDto(String ingredient) {
    this.setIngredient(ingredient);
  }

  public String getIngredient() {
    return ingredient;
  }

  public void setIngredient(String ingredient) {
    this.ingredient = ingredient;
  }


}
