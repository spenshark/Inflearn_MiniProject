package com.example.miniproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/team")
    public void getMember(){

    }

    @PostMapping("/team")
    public void saveMember(){

    }
}
