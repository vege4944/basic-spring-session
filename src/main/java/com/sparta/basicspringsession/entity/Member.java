package com.sparta.basicspringsession.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor

public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Member(String name){ // 얘는 생성자
        this.name = name;
    }
    //6
    //생성자를 안만들어줬기 때문에 네임이 필요하니까 네임 생성자 만들어주기
    //다시 서비스단으로 이동해서

    public void update(String name) { // 얘는 메서드
        this.name = name;
    }
    //37
    //메서드 만들어주기
    // 다시 서비스단 가서
}
