package com.matrix.modulo_bicatoras.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("*")
public class DefaultController {
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> defaultResponse() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "REST API for Modulo Bicatoras is running");
        return response;
    }
}
