package com.example.miniproject.domain.dto.member;

import com.example.miniproject.domain.entity.Role;
import com.example.miniproject.domain.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class MemberResponse {

    private String name;
    private String teamName;
    private Role role;
    private LocalDate workStartDate;
    private LocalDate birthday;
}
