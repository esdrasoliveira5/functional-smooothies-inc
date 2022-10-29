package com.api.ingredients.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.api.ingredients.exception.DataError;

@ControllerAdvice
public class ControllerAdivice {
  @ExceptionHandler({IllegalArgumentException.class})
  public ResponseEntity<DataError> handleConflict(RuntimeException err) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DataError(err.getMessage()));
  }

}
