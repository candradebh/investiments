package dev.carlosandrade.investimentos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessagesController {

    @GetMapping("/hello")
    public String hello(){
        return "Olá eu estou vivo!";
    }
}
