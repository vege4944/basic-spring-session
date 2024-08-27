package com.sparta.basicspringsession.service;

import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.entity.Member;
import com.sparta.basicspringsession.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service //8
@RequiredArgsConstructor //9

public class MemberService {

    private final MemberRepository memberRepository; //10 -> MemberController

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto requestDto) {//24: 단축키로 자동생성함 : 이름에 MemberSave 더 추가해서 넣기 -> 그리고 MemberRequestDto를 Member로 바꿔줘야하니 entity 가서 member 생성자 만들어주기
        Member newMember = new Member(requestDto.getName()); //26
        Member savedMember = memberRepository.save(newMember); //27

//        MemberSaveResponseDto dto = new MemberSaveResponseDto(savedMember.getId(), savedMember.getName()); // 28: member를 memberSavedResponseDto 로 바꿔줘야 하니까
//        return dto;
        return new MemberSaveResponseDto(savedMember.getId(), savedMember.getName()); //29: 28번을 이렇게 바꿔줌
    }

    public List<MemberSimpleResponseDto> getMembers() {
        List<Member> memberList = memberRepository.findAll();

        List<MemberSimpleResponseDto> dtoList = new ArrayList<>();
        for (Member member : memberList) {
            dtoList.add(new MemberSimpleResponseDto(member.getName()));
        }

        return  dtoList;
    }

    public MemberDetailResponseDto getMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NullPointerException("멤버가 없습니다."));

        return new MemberDetailResponseDto(member.getId(), member.getName());
    }

    @Transactional
    public MemberUpdateResponseDto updateMember(Long memberId, MemberUpdateRequestDto requestDto) {
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("멤버가 없습니다."));

        member.update(requestDto.getName());

        return new MemberUpdateResponseDto(member.getId(), member.getName());
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("멤버가 없습니다."));

        memberRepository.delete(member);
    }
}
