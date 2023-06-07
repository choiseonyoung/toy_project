package com.likelion.toy.dto;

import com.likelion.toy.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {

    private String email;

    private String password;

    private String nickName;

    public MemberDTO toMemberDTO(Member member) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setEmail(member.getEmail());
        memberDTO.setPassword(member.getPassword());
        memberDTO.setNickName(member.getNickName());
        return memberDTO;
    }
}
