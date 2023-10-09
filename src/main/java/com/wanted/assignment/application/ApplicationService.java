package com.wanted.assignment.application;

import com.wanted.assignment.company.CompanyService;
import com.wanted.assignment.member.MemberService;
import com.wanted.assignment.notice.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final MemberService memberService;
    private final NoticeService noticeService;

    public ApplicationService(ApplicationRepository applicationRepository, MemberService memberService, NoticeService noticeService) {
        this.applicationRepository = applicationRepository;
        this.memberService = memberService;
        this.noticeService = noticeService;
    }

    public Application createApplication(Long noticeId, Long memberId) {

        //이미 지원한 적 있는 공고인지 검증하는 로직
        Optional<Application> applicationOptional = Optional.ofNullable(applicationRepository.findByNoticeNoticeIdAndMemberMemberId(noticeId, memberId));

        applicationOptional.ifPresent(application -> {
            throw new RuntimeException("Application already exists");
        });

        Application application = new Application();
        application.setMember(memberService.getMember(memberId));
        application.setNotice(noticeService.getNotice(noticeId));

        return applicationRepository.save(application);
    }

    public Application getApplication(Long noticeId, Long memberId) {
        return applicationRepository.findByNoticeNoticeIdAndMemberMemberId(noticeId, memberId);
    }

}
