package com.wanted.assignment.application;

import com.wanted.assignment.company.CompanyService;
import com.wanted.assignment.member.MemberService;
import com.wanted.assignment.notice.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        Application application = new Application();
        application.setMember(memberService.getMember(memberId));
        application.setNotice(noticeService.getNotice(noticeId));

        return applicationRepository.save(application);
    }

}
