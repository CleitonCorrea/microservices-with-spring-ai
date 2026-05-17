package com.example.springai.controller;

import com.example.springai.dto.AskRequest;
import com.example.springai.dto.AskResponse;
import com.example.springai.service.AskService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api")
public class AskController {

    private final AskService askService;

    public AskController(AskService askService) {
        this.askService = askService;
    }

    @PostMapping("/ask")
    public AskResponse ask(@RequestBody @Valid AskRequest request) {
        String answer = askService.ask(request.question());
        return new AskResponse(request.question(), answer);
    }
}
