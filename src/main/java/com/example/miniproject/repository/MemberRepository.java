package com.example.miniproject.repository;

import com.example.miniproject.domain.entity.Member;
import com.example.miniproject.domain.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {


}
