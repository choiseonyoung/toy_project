package com.likelion.toy.entity;

import com.likelion.toy.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickName;

    // DTO -> Entity 변환
    public static Member toMember(MemberDTO memberDTO) {
        Member member = new Member();
        member.setEmail(memberDTO.getEmail());
        member.setPassword(memberDTO.getPassword());
        member.setNickName(memberDTO.getNickName());
        return member;
    }

}
