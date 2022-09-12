package com.turing.hello.controller;

import com.turing.hello.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    private final MemberService memberService;
}
