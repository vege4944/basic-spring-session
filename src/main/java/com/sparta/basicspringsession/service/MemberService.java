package com.sparta.basicspringsession.service;


import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.entity.Member;
import com.sparta.basicspringsession.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto requestDto) {
        //3
        //CRUD 에서 read가 아닌 간단한 로직을 제외하고 무조건 @Transactional 에너테이션 넣어줘야함 -> JPA 할때 설명해주실 예정
        //MemberSaveResponseDto: 생성자타입
        //saveMember: 생성자이름
        //MemberSaveRequestDto: 매개변수타입
        //requestDto: 매개변수 이름
        Member newMember = new Member(requestDto.getName());
        //5
        //32번 이어서 진행된거 -> 생성자를 안만들어준거라 entity 로 이동 26번 오른쪽 Member클릭하면 이동됨
        //7
        //26번줄 괄호안에 requestDto.getName(); 적어서 네임을 넣어주고
        Member savedMember = memberRepository.save(newMember);
        //4
        //19번 MemberSaveRequestDto 는 29번 memberRepository에 저장이 안되있으므로 (왜냐면 memberRepository는 멤버를 보는거기 때문에) 그래서
        //MemberSaveRequestDto를 멤버로 바꿔줘야함
        //8
        //31번 괄호안에 newMember;를 넣어줌
        //그럼 savedMember가 나오겠구나 생각하고 31번 맨 앞줄에 넣어줌
//        MemberSaveResponseDto dto = new MemberSaveResponseDto(savedMember.getId(), savedMember.getName());
        //9
        //38번줄에서 그럼 MemberSaveResponseDto 바꿔줘야겠구나 라고 생각하고 dto 는 new 까지 써주고 MemberSaveResponseDto 써줘서
        //바로 그거 커멘드클릭해서 가보면 id 랑 name이 필요한걸 알 수있어서 괄호안에 savedMember.getId(), savedMember.getName() 로 이 파라미터를
        //MemberSaveResponseDto의 생성자와 맞춰주면 됨 왜냔면 이 생성자는 강제니까
        return new MemberSaveResponseDto(savedMember.getId(), savedMember.getName());
        //10
        // 38번에서 변형한건데 38번 맨 앞 MemberSaveResponseDto 랑 19번 노란색이랑 타입이 똑같은걸 알 수 있어서 MemberSaveResponseDto dto = 지우고 리턴해줌
        // 컨트로러로 가서
    }

//    @Transactional(read only = true)
    // 13
    // 이렇게 처음에 썻다가 crud 에서 r은 transactional 안붙여준다고 했으니 지움
    public List<MemberSimpleResponseDto> getMembers() {
        //14
        List<Member> memberList = memberRepository.findAll();
        //15
        //다 가져와야하니까 memberRepository.findAll(); 이거먼저 적어주고 option Enter 눌러서 자동완성 시켜주기
        // 그럼 이렇게 뜨는데 List<Member> all = memberRepository.findAll(); -> memberList를 가져와야하니 all 대신 바꿔줌
        List<MemberSimpleResponseDto> dtoList = new ArrayList<>();
        //16
        // MemberSimpleResponseDto 를 리턴해줘야하니까 먼저 선언해주고 array로 만들어줌
        //List에는 무조건 newArrayList 쓰는거 잊지마 그냥 무조건 해!!
        for (Member member : memberList) {
        //17
        // memberList.for 치면 향상된포문 생성해줌
            MemberSimpleResponseDto dto = new MemberSimpleResponseDto(member.getName());
        //18
        //member를 얘로 MemberSimpleResponseDto 바꿔줘야하기때문에 MemberSimpleResponseDto dtp = new MemberSimpleResponseDto();  이렇게 적고
        // 뭐가 필요한지 보러가야하니 파란색 MemberSimpleResponseDto 눌러서 들어가보면 name 만 필요한걸 알 수 있어서 괄호안에 member.getName() 넣어줌
            dtoList.add(dto);
            //19
        }

        return dtoList;
        //20
        // 이제 컨트롤러 가서 리턴해줘야함
    }

    public MemberDetailResponseDto getMember(Long memberId) { // 여기도 crud 에서 r 은 transactional 안넣어주니 뺐음
        //23
        // 어떤 특정멤버의 아이디를 가지고 찾아야돼 왜냐면 유니크한 값이기 때문에.
        // 어떤 그 멤버의 아이디로 query 를 날려야됨 그래서 멤버아이디를 가져와서 Long memberId를 가져옴 왜냐면 우리가 받을거니까
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("멤버가 없습니다."));
//        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NullPointerException("멤버가 없습니다."));
        //24
        // 아이디로 찾을거니까 이렇게 적음
        // Jdbc에서는 어려운데 jpa 는 다찾고싶으면 findAll 하나만 찾고싶으면 findId 이런식임
        // 그리고 끝내는게 아니라 .orElseThrow(() -> new NullPointerException("멤버가 없습니다.") 이걸 써줘야 하는데 지금은 몰라도 돼
        // 그럼 memberRepository.findById(memberId).orElseThrow(() -> new NullPointerException("멤버가 없습니다.")); 이렇게 써져있는 상태인데
        // member로 받아야하니 앞에
        return new MemberDetailResponseDto(member.getId(), member.getName());
        //25
        //member로 리턴할게 아니라 MemberDetailResponseDto 이걸로 리턴할거니까
        // MemberDetailResponseDto dto = new MemberDetailResponseDto(); 쓰고 파란색 눌러보면 생성자가 아이디랑 네임이 필요한게 보이니까
        //member에 getId(), member에 getName() 을 해줘서 생성자 충족 완료되었구 아래줄에 return dto; 라고 써줘야 하는데
        // 우린 이걸 한번에 할 수 있으니 MemberDetailResponseDto dto = new MemberDetailResponseDto(member.getId(), member.getName());
        // 이렇게 적었던거에서 MemberDetailResponseDto dto =  이거 지우고 return 붙여주면됨
        // 다시 컨트롤러가서 리턴해주기
    }
    @Transactional // 여기도 crud 에서 r 이 아니니 transactional 넣어줘야함
    public MemberUpdateResponseDto updateMember(Long memberId, MemberUpdateRequestDto requestDto) {
        //35
        //괄호안에 81번줄이랑 똑같이 넣어주고 putmapping에서 복사해온 MemberUpdateRequestDto requestDto 까지 추가 어떤멤버인지 알아야하니가
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("멤버가 없습니다."));
        //36
        // 마찬가지로 있는지 없는지 찾아줘야하니까 (검사해야하니까) 넣어주기
        // entity가서 멤버에 업데이트 만들어줘야함
        member.update(requestDto.getName());
        //38
        //requestDTo의 name 을 업데이트 해줄거라 getName 해주면 돼 enitoty에 스트링네임을 수정할 수 있도록 만들어서 가능
        return new MemberUpdateResponseDto(member.getId(), member.getName());
                //39 파란색 누르면 아이디랑 네임 리턴하기로 했으니 넣어줘
        //40 이제 다했으니 컨트롤러가서 ResponseEntity <> 랑 ResponseEntity.ok() 두개 @deletemapping에 빼고 모두 넣어주러가기

    }


    @Transactional
    public void deleteMember(Long memberId) { // 여기도 crud 에서 r 이 아니니 transactional 넣어줘야함
        //25
        // 리턴 안만들어주기로 했으니 void
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("멤버가 없습니다."));
        //27
        //복붙 후 다시 컨트롤러 가서

        memberRepository.delete(member);
        // 26
        //삭제니까 단순히 memberRepository.delete(memberId); 이렇게 적을 것 같지만 안됨
        // 왜냐면 delete가 entity를 넣게되어있거든 그래서 한번 찾아줘야해서
        //  Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("멤버가 없습니다."));
        // 이걸 윗줄에 복붙해줘

    }
}
