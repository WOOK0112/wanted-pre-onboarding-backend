package com.wanted.assignment.member;

import com.wanted.assignment.exception.BusinessLogicException;
import com.wanted.assignment.exception.ExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member getMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);

        return optionalMember.orElseThrow( () -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }


}
