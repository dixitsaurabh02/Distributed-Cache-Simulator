package com.myanatomy.sandboxpro.controller;

import com.myanatomy.sandboxpro.model.User;
import com.myanatomy.sandboxpro.service.HelloService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cache")
@CrossOrigin("*")
public class HelloController {

    private final HelloService service;

    public HelloController(HelloService service) {
        this.service = service;
    }

    @PostMapping("/put")
    public String put(@RequestBody User user) {
        return service.put(user.getKey(), user.getValue());
    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable String key) {
        return service.get(key);
    }

    @GetMapping("/all")
    public List<Map<String, String>> getAll() {
        return service.getAll();
    }
}