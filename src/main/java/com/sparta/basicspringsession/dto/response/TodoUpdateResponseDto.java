package com.sparta.basicspringsession.dto.response;

import lombok.Getter;

@Getter
public class TodoUpdateResponseDto {
    private final Long id;


    public TodoUpdateResponseDto(Long id) {
        this.id = id;

    }
}
