package com.lizana.microservicecreditcard.application.exeptions;

public class CustomExeption extends RuntimeException {
  public CustomExeption(String message) {
    super(message);
  }
}
