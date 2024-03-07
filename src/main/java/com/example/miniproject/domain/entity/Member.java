package com.example.miniproject.domain.entity;

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

    @Column
    private String name;

    @Column(name = "team_name")
    private String teamName;

    @Column
    private String role;

    @Column
    private LocalDate birthday;

    @Column(name = "work_state_date")
    private LocalDate workStartDate;


    public Member(String name, String teamName, String role, LocalDate workStartDate, LocalDate birthday) {
        this.name = name;
        this.teamName = teamName;
        this.role = role;
        this.workStartDate = workStartDate;
        this.birthday = birthday;
    }
}
