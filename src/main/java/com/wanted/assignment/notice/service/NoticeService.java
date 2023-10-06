package com.wanted.assignment.notice.service;

import com.wanted.assignment.notice.entity.Notice;
import com.wanted.assignment.notice.repository.NoticeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

}
