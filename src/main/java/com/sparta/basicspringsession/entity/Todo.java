package com.sparta.basicspringsession.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor

public class Todo extends Timestamped{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String contents;

        private String username; // username 은 연관관계를 맺어줄 예정이니 맨 아래로 내려주기

        @OneToMany(mappedBy = "todo") // 원투매니는 자기자신 넣는거 / OnetoMany의 default가 fetch Lazy 라서 안넣어줘도됨
        private List<Comment> comments = new ArrayList<>();

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
