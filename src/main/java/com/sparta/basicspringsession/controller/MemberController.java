package com.sparta.basicspringsession.controller;

import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//11
@RequiredArgsConstructor //12

public class MemberController {
    private final MemberService memberService; //13

    @PostMapping("/members") //15
    public ResponseEntity<MemberSaveResponseDto> saveMember(@RequestBody MemberSaveRequestDto requestDto) { //16->saveResponseDto로 가기
        return ResponseEntity.ok(memberService.saveMember(requestDto)); //23: option enter enter -> service 로 이동
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberSimpleResponseDto>> getMembers() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping("/members{memberId}")
    public ResponseEntity<MemberDetailResponseDto> getMembers(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getMember(memberId));
    }

    @PutMapping("/members/{memberId}")
    public ResponseEntity<MemberUpdateResponseDto> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto requestDto) {
        return ResponseEntity.ok(memberService.updateMember(memberId, requestDto));
    }

    @DeleteMapping("/members/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
    }
}
