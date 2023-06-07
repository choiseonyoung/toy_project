package com.likelion.toy.controller;

import com.likelion.toy.dto.MemberDTO;
import com.likelion.toy.service.MemberSerivce;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final MemberSerivce memberSerivce;

    public HomeController(MemberSerivce memberSerivce) {
        this.memberSerivce = memberSerivce;
    }

    @GetMapping("/")
    public String home() {

        return "main";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO) {
        boolean login_success = memberSerivce.login(memberDTO);
        // 로그인 성공시
        if(login_success) {
            return "redirect:/board/list";
        } else {
            return "redirect:/";
        }

    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("email=" + memberDTO.getEmail() + " password=" + memberDTO.getPassword() + " nickname=" + memberDTO.getNickName());
        memberSerivce.join(memberDTO);
        return "redirect:/";
    }

}
