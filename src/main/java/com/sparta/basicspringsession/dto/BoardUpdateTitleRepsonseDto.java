package com.sparta.basicspringsession.dto;

import lombok.Getter;

@Getter
public class BoardUpdateTitleRepsonseDto {
    private final Long id;
    private final String title;
    private final String contents;


    public BoardUpdateTitleRepsonseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
