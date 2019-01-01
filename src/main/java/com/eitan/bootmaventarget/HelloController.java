package com.eitan.bootmaventarget;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
  @GetMapping
  public Map<String, String> hello() {
    Map<String, String> map = new HashMap<>();
    map.put("message", "hello");
    return map;
  }
}
