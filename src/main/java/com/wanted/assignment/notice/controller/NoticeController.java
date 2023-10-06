package com.wanted.assignment.notice.controller;

import com.wanted.assignment.company.Company;
import com.wanted.assignment.company.CompanyService;
import com.wanted.assignment.notice.dto.NoticePostDto;
import com.wanted.assignment.notice.entity.Notice;
import com.wanted.assignment.notice.mapper.NoticeMapper;
import com.wanted.assignment.notice.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notice")
@Validated
@Slf4j
public class NoticeController {
    private final NoticeService noticeService;
    private final NoticeMapper noticeMapper;
    private final CompanyService companyService;

    public NoticeController(NoticeService noticeService, NoticeMapper noticeMapper, CompanyService companyService) {
        this.noticeService = noticeService;
        this.noticeMapper = noticeMapper;
        this.companyService = companyService;
    }

    @PostMapping("/{company-id}")
    public ResponseEntity postNotice (@PathVariable("company-id") long companyId,
                                      @RequestBody NoticePostDto noticePostDto) {
        Company company = companyService.findCompany(companyId);
        Notice notice = noticeService.createNotice(noticeMapper.noticePostDtoToNotice(noticePostDto, company));

        return new ResponseEntity(noticeMapper.noticeToNoticeResponseDto(notice), HttpStatus.CREATED);
    }

}
