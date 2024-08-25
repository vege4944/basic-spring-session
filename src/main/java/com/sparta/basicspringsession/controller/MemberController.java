package com.sparta.basicspringsession.controller;


import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.service.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberSaveResponseDto> saveMember(@RequestBody MemberSaveRequestDto requestDto) {
        //1
        //Response Entity는 귀찮아서 빼신다고 하심 나중에 해도 됨
        //List<MemberSaveResponseDto> 라고 처음에 썼는데 타이포여서 MemberSaveResponseDto 라고 쓰면됨 post니까 List일리가 없음:  생성자타입
        //saveMember: 생성자이름-> 멤버 세이브할거니까
        //@RequestBody: 바디로 받을거니까
        //MemberSaveRequestDto: 매개변수에서 타입
        //requestDto: 배개변수 중 타입의 이름
        return ResponseEntity.ok(memberService.saveMember(requestDto));
        //2
        //멤버서비스 만들어주려다가 서비스에 없어서 서비스단으로 넘어가서 만들예정
        //11
        //saveMember에 requestDto 를 넣어주겠다 그러므로 리턴하겠다
    }

    @GetMapping("/members") // 전체조회
    public ResponseEntity<List<MemberSimpleResponseDto>> getMembers() {
        //12
        //전체조회를 할거니까 @Getmappiing 그리고 전체니까 심플해야해서 List<MemberSimpleResponseDto>  넣어주고 getmembers 해주기
        // getMembers 는 파라미터가 필요없음
        // 전체를 가져오는걸 만들거니까 서비스단으로 가
        return ResponseEntity.ok(memberService.getMembers());
        //21
    }

    @GetMapping("/members/{memberId}") // 한명만조회
    public ResponseEntity<MemberDetailResponseDto> getMember(@PathVariable Long memberId) {
        //22
        //하나만 가져올거라 detail 가져와야함.
        //여기서 50번줄 {} 이 중괄호 안에 있는걸 pathvariable 이라고도 하는데 나중에 알려주실 예정
        //그래서 48번 줄에 @PathVariable 써주고 memberId 받아주기. 그냥 id도 되긴 하지만 구분하기 쉽게 하기 위해 memberId라고 적음
        // 이제 또 만들어줘야하니 서비스 단에 가기
        return ResponseEntity.ok(memberService.getMember(memberId));
        //26
        //하나만가져올거니까 괄호에 memberId 넣어주기
    }

    @PutMapping("/members/{memberId}")
    //32
    //put은 특정멤버의 필드니까 똑같이 id
    public ResponseEntity<MemberUpdateResponseDto> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto requestDto){
        //33
        //45번줄일아 똑같이 받아줘야 하니까 pathvariable 그대로 복붙하고
        //putmapping은 어떤 멤버인지도 알아야하지만 어떤 수일들을 수정할건지도 알아야하기 때문에
        //  @RequestBody MemberUpdateRequestDto requestDto 까지 받아줘야함
        return ResponseEntity.ok(memberService.updateMember(memberId, requestDto));
        //34
        // @RequestBody MemberUpdateRequestDto requestDto 때문에 requestDto 도 같이 넣어줘야해
        //리턴해줄건데 updateMember가 없으니 만들어 주러 서비스단 또 가기

    }

    @DeleteMapping("/members/{memberId}") // 얘도 특정한 한명만
    public void deleteMember(@PathVariable Long memberId) {
    //23
    // 얘도 특정한명만 지우는거니까 리턴이 필요가 없음
        memberService.deleteMember(memberId);
    //24
    //생성자 안만들어주었으니 return memberService 여기까지 적구 또 서비스단 가서
    //28
    // 서비스단 가서 만들어주고 void 니 리턴이 필요없어서 return memberService 지우고 memberService.deleteMember(memberId); 이렇게 바꿔주면됨
    // 이제 수정할거라서 dto 패키지에 MemberUpdateRequestDto 먼저 만들어주기

    }

}














