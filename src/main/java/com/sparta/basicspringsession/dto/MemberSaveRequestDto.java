package com.sparta.basicspringsession.dto;

import lombok.Getter;

@Getter //21
public class MemberSaveRequestDto {

    private String name; //22:여기에 id필요없는 이유는 db에서 알아서 generate 되기때문에(생성)되기 때문에 name만 씀/ 그리고 request니까 final이 필요없음 -> controller로 가기

}
