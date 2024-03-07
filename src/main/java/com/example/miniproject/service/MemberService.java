package com.example.miniproject.service;

import com.example.miniproject.domain.dto.member.MemberRequest;
import com.example.miniproject.domain.dto.member.MemberResponse;
import com.example.miniproject.domain.entity.Member;
import com.example.miniproject.domain.entity.Role;
import com.example.miniproject.domain.entity.Team;
import com.example.miniproject.repository.MemberRepository;
import com.example.miniproject.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public List<MemberResponse> getMember(){
        return memberRepository.findAll().stream()
                .map(member -> new MemberResponse(
                        member.getName(),
                        member.getTeamName(),
                        member.getRole(),
                        member.getWorkStartDate(),
                        member.getBirthday()
                )).collect(Collectors.toList());
    }

    @Transactional
    public void saveMember(MemberRequest request) {

        Team team = teamRepository.findByName(request.getTeamName())
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 팀이 없습니다: " + request.getTeamName()));

        memberRepository.save(new Member(
                request.getName(),
                request.getTeamName(),
                request.getRole(),
                request.getWorkStartDate(),
                request.getBirthday()
                ));

        if(request.getRole().equals("MANAGER")){
            team.setManager(request.getName());
            teamRepository.save(team);
        }
        team.addMemberCount();
        teamRepository.save(team);
    }
}
