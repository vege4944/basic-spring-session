package com.sparta.basicspringsession.dto;


import lombok.Getter;

@Getter

public class MemberUpdateRequestDto {
    private String name;
    // 29
//수정할게 name 밖에 없으니 Getter 넣어주고 private String name; 넣어주면 끝
// 이제 또 dto 에 MemberUpdateResponseDto 만들어주러 가기
}
