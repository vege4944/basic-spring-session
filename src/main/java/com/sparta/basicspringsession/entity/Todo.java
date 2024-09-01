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

public class Todo extends Timestamped{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String contents;

        private String username; // username 은 연관관계를 맺어줄 예정이니 맨 아래로 내려주기

    public Todo(String title, String contents, String username) { //생성자: 클래스로 객체를 생성할 때 그 객체를 강제로 이렇게 생성하라고 지정해주는 메서드
        this.title = title;
        this.contents = contents;
        this.username = username;
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
