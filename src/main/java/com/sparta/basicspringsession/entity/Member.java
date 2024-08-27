package com.sparta.basicspringsession.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter //1
@Entity //2
@NoArgsConstructor //3

public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //4
    private Long id; //5
    private String name; //6 -> MemberRepository

    public Member(String name) { //25
        this.name = name;
    }

    public void update(String name) {
        this.name = name;
    }
}
