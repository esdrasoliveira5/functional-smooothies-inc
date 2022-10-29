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
  @DisplayName("1 - Correto")
  void deveAdicionarDrone() throws Exception {
    final var smoothie = new SmoothieDto("Classic,-strawberry,-peanut");
    mockMvc
        .perform(post("/ingredients/create").contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(smoothie)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.ingredient").value("banana,pineapple,mango,peach,honey"));
  }

}
