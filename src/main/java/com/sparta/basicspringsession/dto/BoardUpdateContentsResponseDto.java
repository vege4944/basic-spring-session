package com.sparta.basicspringsession.dto;

import lombok.Getter;

@Getter
public class BoardUpdateContentsResponseDto {
    private final Long id;
    private final String titles;
    private final String contents;

    public BoardUpdateContentsResponseDto(Long id, String titles, String contents) {
        this.id = id;
        this.titles = titles;
        this.contents = contents;
    }
}
