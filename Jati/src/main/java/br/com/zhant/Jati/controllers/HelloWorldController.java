package br.com.zhant.Jati.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloWorldController {

    @GetMapping
    public String olaMundo(){
        return "Olá mundo";
    }
}
