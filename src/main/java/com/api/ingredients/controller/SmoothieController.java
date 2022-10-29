package com.api.ingredients.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.ingredients.service.SmoothieService;

@RestController
@RequestMapping("/ingredients")
public class SmoothieController {
  @Autowired
  private SmoothieService service;

  @PostMapping("/")
  public String create(String delivery) {
    return service.create(delivery);
  }
}
