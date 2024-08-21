package com.sparta.basicspringsession.dto;

import lombok.Getter;

@Getter
public class MemberSaveRequestDto { // request에는 final x , 생성자 x

    private String name; // Generatevalue 에 id 있으니 여기에 안적어줘도 됨
}
