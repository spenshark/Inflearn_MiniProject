package com.example.miniproject.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "member_count")
    private long memberCount;

    public Team(String name) {
        this.name = name;
        this.managerName = null;
        this.memberCount = 0;
    }

    public void addMemberCount() {
        this.memberCount++;
    }

    public void setManager(String name){
        this.managerName = name;
    }
}
