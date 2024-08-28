package com.sparta.basicspringsession.dto;

import lombok.Getter;

@Getter
public class BoardUpdateTitleResponseDto {
    private final Long id;
    private final String titles;
    private final String contents;

    public BoardUpdateTitleResponseDto(Long id, String titles, String contents) {
        this.id = id;
        this.titles = titles;
        this.contents = contents;
    }
}
