package com.example.miniproject.domain.entity;

import com.example.miniproject.domain.dto.member.MemberRequest;
import com.example.miniproject.domain.dto.member.MemberResponse;
import com.example.miniproject.domain.dto.team.TeamResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "team_name")
    private String teamName;

    @Column(nullable = false)
    @JsonProperty
    private Role role;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false, name = "work_state_date")
    private LocalDate workStartDate;


    public Member(String name, String teamName, Role role, LocalDate workStartDate, LocalDate birthday) {
        this.name = name;
        this.teamName = teamName;
        this.role = role;
        this.workStartDate = workStartDate;
        this.birthday = birthday;
    }

    public MemberResponse toDto(){
        return new MemberResponse(this.name, this.teamName, this.getRole(), this.getWorkStartDate(), this.getBirthday());
    }

    public static Member toEntity(MemberRequest request){
        return new Member(
                request.getName(),
                request.getTeamName(),
                request.getRole(),
                request.getWorkStartDate(),
                request.getBirthday()
        );
    }
}
