package com.sparta.basicspringsession.dto.todoResponse;

import lombok.Getter;

@Getter
public class TodoSimpleResponseDto { //3단계
    private final String title;
    public TodoSimpleResponseDto(String title) {
        this.title = title;
    }
}
