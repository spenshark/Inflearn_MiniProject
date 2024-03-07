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
                .map(Member::toDto).collect(Collectors.toList());
    }

    @Transactional
    public void saveMember(MemberRequest request) {

        Team team = teamRepository.findByName(request.getTeamName())
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 팀이 없습니다: " + request.getTeamName()));

        Role role = request.getRole();

        memberRepository.save(Member.toEntity(request));

        if(role.equals(Role.MANAGER)){
            if(team.getManagerName() == null){
                team.setManager(request.getName());
                teamRepository.save(team);
            }
            else throw new IllegalArgumentException("이미 매니저가 존재합니다.");
        }
        team.addMemberCount();
        teamRepository.save(team);
    }
}
