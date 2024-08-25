package com.sparta.basicspringsession.dto;

import lombok.Getter;

@Getter
public class MemberUpdateResponseDto {

    private final Long id;
    private final String name;
    //30
    // response 니까 final 붙여주기 -> 이건 나중에 설명해주신다 하심

    public MemberUpdateResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    //31
    //id 까지 리턴해줄거니까
    // private final Long id;
    //    private final String name; 이 두줄에 빨간줄 뜨니 거기에 커서 가져다 놓고
    // option enter enter 하면 생성자 자동으로 생성 완료
    // 이제 컨트롤러 가서 put 작성


}
