package com.turing.hello.service;

import com.turing.hello.domain.Member;
import com.turing.hello.repository.MemberRepository;
import com.turing.hello.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private final MemberRepository memberRepository;

    public Long join(Member member){
        validateDuplicatedMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원");
        });
    }

    public List<Member> findMembers(){
       return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
