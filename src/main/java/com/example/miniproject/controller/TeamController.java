package com.example.miniproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamController {

    @GetMapping("/member")
    public void getMember(){

    }

    @PostMapping("/member")
    public void saveMember(){

    }
}
