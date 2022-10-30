package com.api.ingredients;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.api.ingredients.dto.SmoothieDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IngredientsApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @Order(1)
  @DisplayName("1 - Display the correct list os ingredients")
  void shouldBeReturnIngredients() throws Exception {
    final var smoothie = new SmoothieDto("Classic,-strawberry");
    mockMvc
        .perform(post("/ingredients/create").contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(smoothie)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.ingredient").value("banana,pineapple,mango,peach,honey"));
  }

  @Test
  @Order(2)
  @DisplayName("2 - Display the correct error message and status when input is empty")
  void shouldBeReturnErrorEmpty() throws Exception {
    final var smoothie = new SmoothieDto("");
    mockMvc
        .perform(post("/ingredients/create").contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(smoothie)))
        .andExpect(status().isBadRequest()).andExpect(jsonPath("$.error").value("Empty Input"));
  }

  @Test
  @Order(3)
  @DisplayName("3 - Display the correct error message and status when Smoothie dont exist")
  void shouldBeReturnErrorNotFound() throws Exception {
    final var smoothie = new SmoothieDto("Very Tasty Smoothie,-strawberry,-peanut");
    mockMvc
        .perform(post("/ingredients/create").contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(smoothie)))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Not Found Smoothie"));
  }


  @Test
  @Order(4)
  @DisplayName("4 - Display the correct error message and status when additional ingredient detected")
  void shouldBeReturnErrorAdditionalIngredient() throws Exception {
    final var smoothie = new SmoothieDto("Classic,mango");
    mockMvc
        .perform(post("/ingredients/create").contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(smoothie)))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Aditional Ingredient Not Supported"));
  }


  @Test
  @Order(5)
  @DisplayName("5 - Display the correct error message and status when atype of input is wrong")
  void shouldBeReturnErrorWhenWrongTypeOfInput() throws Exception {
    final var smoothie = new SmoothieDto("1");
    mockMvc
        .perform(post("/ingredients/create").contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(smoothie)))
        .andExpect(status().isBadRequest());

  }

  @Test
  @Order(6)
  @DisplayName("6 - Display the correct list os ingredients and ignore allergens imgredients that do not is present of the smoothie ingredients")
  void shouldBeReturnIngredientsAndIgnoreIngredients() throws Exception {
    final var smoothie = new SmoothieDto("Classic,-strawberry,-peanut,-blackberry");
    mockMvc
        .perform(post("/ingredients/create").contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(smoothie)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.ingredient").value("banana,pineapple,mango,peach,honey"));
  }
}
