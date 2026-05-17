package com.example.springai.controller;

import com.example.springai.dto.AskResponse;
import com.example.springai.service.AskService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api")
public class AskController {

    private final AskService askService;

    public AskController(AskService askService) {
        this.askService = askService;
    }

    @GetMapping("/ask")
    public AskResponse ask(@RequestParam @NotBlank(message = "question is required") String question) {
        String answer = askService.ask(question);
        return new AskResponse(question, answer);
    }
}