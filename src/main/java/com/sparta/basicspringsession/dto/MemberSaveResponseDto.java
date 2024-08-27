package com.sparta.basicspringsession.dto;

import lombok.Getter;

@Getter //17
public class MemberSaveResponseDto {
    private final long id; //18
    private final String name;//19


    public MemberSaveResponseDto(long id, String name) { //20: option enter enter 로 생성자 만들어주기 -> saveRequestDto
        this.id = id;
        this.name = name;
    }
}
