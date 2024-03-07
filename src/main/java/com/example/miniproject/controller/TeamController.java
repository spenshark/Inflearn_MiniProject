package com.example.miniproject.controller;

import com.example.miniproject.domain.dto.team.TeamRequest;
import com.example.miniproject.domain.dto.team.TeamResponse;
import com.example.miniproject.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/team")
    public List<TeamResponse> getTeam(){
        return teamService.getTeam();
    }

    @PostMapping("/team")
    public void saveTeam(@RequestBody TeamRequest request){
        teamService.saveTeam(request);
    }
}
