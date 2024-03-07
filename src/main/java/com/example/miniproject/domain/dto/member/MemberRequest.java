package com.example.miniproject.domain.dto.member;

import com.example.miniproject.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {

    private String name;
    private String teamName;
    private Role role;
    private LocalDate workStartDate;
    private LocalDate birthday;
}
