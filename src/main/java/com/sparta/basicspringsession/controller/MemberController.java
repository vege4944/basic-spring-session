package com.sparta.basicspringsession.controller;

import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.service.MemberService;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor

public class MemberController { // 컨트롤러는 무엇을 넣고 받고싶은지만 알고싶음

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberSaveResponseDto> saveMember(@RequestBody MemberSaveRequestDto requestDto) {
        return ResponseEntity.ok(memberService.saveMember(requestDto));
    }

    @GetMapping("/members")
    public ResponseEntity<MemberSimpleResponseDto> getMembers() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberUpdateResponseDto> getMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getMember(memberId));
    }

    @PutMapping("/members/{memberId}")
    public ResponseEntity<MemberUpdateResponseDto> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto requestDto) {
        return ResponseEntity.ok(memberService.updateMember(memberId, requestDto));
    }

    @DeleteMapping("members/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {memberService.deleteMember(memberId);
    }

}


