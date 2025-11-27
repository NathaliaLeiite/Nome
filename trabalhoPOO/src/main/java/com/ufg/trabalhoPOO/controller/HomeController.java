package com.ufg.trabalhoPOO.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // Quando acessar a raiz (localhost:8080/)
    public String home() {
        return "index"; // O Spring vai procurar o arquivo "index.html" na pasta templates
    }
}
