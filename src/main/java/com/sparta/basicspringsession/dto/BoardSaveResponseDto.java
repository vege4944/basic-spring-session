package com.sparta.basicspringsession.dto;

import lombok.Getter;

@Getter
public class BoardSaveResponseDto {
    private final Long id;
    private final String titles;
    private final String contents;

    public BoardSaveResponseDto(Long id, String titles, String contents) {
        this.id = id;
        this.titles = titles;
        this.contents = contents;
    }
}
