package com.example.wannabeapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // tworzenie kontrolera dla GET
    @GetMapping("/")
    public String sayHello() {
        return "Oto ja";
    }

}
