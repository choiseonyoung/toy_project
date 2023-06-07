package com.likelion.toy.service;

import com.likelion.toy.dto.MemberDTO;
import com.likelion.toy.entity.Member;
import com.likelion.toy.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class MemberSerivce {

    private final MemberRepository memberRepository;

    public MemberSerivce(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 가입
    public void join(MemberDTO memberDTO) {
        // id 중복검사
        Member member = Member.toMember(memberDTO);
        memberRepository.save(member);
    }

    public boolean login(MemberDTO memberDTO) {
        // 이메일 일치 여부 확인
        Optional<Member> byEmail = memberRepository.findByEmail(memberDTO.getEmail());
        // 조회 결과 있으면
        if(byEmail.isPresent()) {
            Member member = byEmail.get();
            // 비밀번호 일치 여부 확인
            if(member.getPassword().equals(member.getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }



    }



}
