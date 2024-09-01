package com.sparta.basicspringsession.dto.commentRequest;

import lombok.Getter;

@Getter
public class CommentSaveRequestDto {
    private String contents;
    private String username;
}
