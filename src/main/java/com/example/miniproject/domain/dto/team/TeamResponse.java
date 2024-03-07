package com.example.miniproject.domain.dto.team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class TeamResponse {

    private String name;
    private String manager;
    private long memberCount;
}
