package com.wanted.assignment.notice.service;

import com.wanted.assignment.exception.BusinessLogicException;
import com.wanted.assignment.exception.ExceptionCode;
import com.wanted.assignment.notice.dto.NoticePatchDto;
import com.wanted.assignment.notice.entity.Notice;
import com.wanted.assignment.notice.repository.NoticeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public Notice createNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    public Notice getNotice(long noticeId) {
        Optional<Notice> optionalNotice = noticeRepository.findById(noticeId);

        return optionalNotice.orElseThrow( () -> new BusinessLogicException(ExceptionCode.NOTICE_NOT_FOUND) );
    }

    public Page<Notice> getNotices(int page, int size) {
        return noticeRepository.findAll(PageRequest.of(page, size,
                Sort.by("noticeId").descending()));
    }

    public Page<Notice> getSearchNotices(String keyword, int page, int size) {
        return noticeRepository.findByKeyword(keyword, PageRequest.of(page, size));
    }

    //회사가 작성한 채용공고 목록 Id를 불러오는 메서드
    public List<Long> getMyNoticeIdList(long companyId) {
        return noticeRepository.findByNoticeIdList(companyId);
    }

    public Notice updateNotice(NoticePatchDto patchDto, long companyId) {
        Notice findNotice = getNotice(patchDto.getNoticeId());

        //수정할 채용공고를 작성한 회사가 맞는지 검증
        if(findNotice.getCompany().getCompanyId() != companyId) new BusinessLogicException(ExceptionCode.COMPANY_DOES_NOT_MATCH);

        Optional.ofNullable(patchDto.getPosition())
                .ifPresent(position->findNotice.setPosition(position));
        Optional.ofNullable(patchDto.getPayment())
                .ifPresent(payment->findNotice.setPayment(payment));
        Optional.ofNullable(patchDto.getContent())
                .ifPresent(content->findNotice.setContent(content));
        Optional.ofNullable(patchDto.getTechStack())
                .ifPresent(techStack->findNotice.setTechStack(techStack));

        return noticeRepository.save(findNotice);
    }

    public void deleteNotice(long companyId, long noticeId) {
        Notice findNotice = getNotice(noticeId);

        //수정할 채용공고를 작성한 회사가 맞는지 검증
        if(findNotice.getCompany().getCompanyId() != companyId) new RuntimeException();new BusinessLogicException(ExceptionCode.COMPANY_DOES_NOT_MATCH);
        noticeRepository.delete(findNotice);
    }

}
