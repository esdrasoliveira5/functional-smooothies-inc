package com.api.ingredients.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.ingredients.dto.SmoothieDto;
import com.api.ingredients.service.SmoothieService;

@CrossOrigin
@RestController
@RequestMapping("/ingredients")
public class SmoothieController {
  @Autowired
  private SmoothieService service;

  @PostMapping("/create")
  public SmoothieDto create(@RequestBody SmoothieDto data) {

    return service.create(data);
  }
}
