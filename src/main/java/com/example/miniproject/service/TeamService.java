package com.example.miniproject.service;

import com.example.miniproject.domain.dto.team.TeamRequest;
import com.example.miniproject.domain.dto.team.TeamResponse;
import com.example.miniproject.domain.entity.Team;
import com.example.miniproject.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public List<TeamResponse> getTeam(){
        return teamRepository.findAll().stream()
                .map(Team::toDto).collect(Collectors.toList());
    }

    @Transactional
    public void saveTeam(TeamRequest request){
        teamRepository.save(new Team(request.getName()));
    }
}
