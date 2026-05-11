package br.com.cristianofeitosa.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firstRouter")
public class MyFirstController {
  
  @GetMapping("/")
  public String firstMessage() {
    return "Hello World";
  }
}
