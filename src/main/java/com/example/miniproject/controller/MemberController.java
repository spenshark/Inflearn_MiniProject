package com.example.miniproject.controller;

import com.example.miniproject.domain.dto.member.MemberRequest;
import com.example.miniproject.domain.dto.member.MemberResponse;
import com.example.miniproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public List<MemberResponse> getMember(){
        return memberService.getMember();
    }

    @PostMapping("/member")
    public void saveMember(@RequestBody MemberRequest request){
        memberService.saveMember(request);
    }
}
