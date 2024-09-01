package com.sparta.basicspringsession.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor

public class Comment extends Timestamped{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String contents;
        private String username;

        @ManyToOne(fetch = FetchType.LAZY) // ManyToOne 은 당연히 많은쪽에 붙여줘야해 comments > todoo // manytoone의 default는 eager 라서 무조건 fetchtype lazy로 해줘
        @JoinColumn(name = "todo_id") // comment 입장에서 상대방의 id 를 넣어줘야되는데 상대방은 todo니까!
        private Todo todo;

    public Comment(String contents, String username, Todo todo) {
        this.contents = contents;
        this.username = username;
        this.todo = todo;
    }

    public void update(String contents) {
        this.contents = contents;
    }
}
