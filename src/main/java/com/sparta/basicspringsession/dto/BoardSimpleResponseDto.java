package com.sparta.basicspringsession.dto;

import lombok.Getter;

@Getter
public class BoardSimpleResponseDto {
    private final String titles;

    public BoardSimpleResponseDto(String titles) {
        this.titles = titles;
    }
}
