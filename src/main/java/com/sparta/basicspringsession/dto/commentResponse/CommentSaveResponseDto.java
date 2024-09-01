package com.sparta.basicspringsession.dto.commentResponse;

import lombok.Getter;

@Getter
public class CommentSaveResponseDto {
    private final Long id;
    private final String contents;
    private final String username;

    public CommentSaveResponseDto(Long id, String contents, String username) {
        this.id = id;
        this.contents = contents;
        this.username = username;
    }
}
