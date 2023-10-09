package com.wanted.assignment.notice.controller;

import com.wanted.assignment.company.Company;
import com.wanted.assignment.company.CompanyService;
import com.wanted.assignment.notice.dto.NoticePatchDto;
import com.wanted.assignment.notice.dto.NoticePostDto;
import com.wanted.assignment.notice.entity.Notice;
import com.wanted.assignment.notice.mapper.NoticeMapper;
import com.wanted.assignment.notice.pagination.MultiResponseDto;
import com.wanted.assignment.notice.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

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
        Company company = companyService.getCompany(companyId);
        Notice notice = noticeService.createNotice(noticeMapper.noticePostDtoToNotice(noticePostDto, company));

        return new ResponseEntity(noticeMapper.noticeToNoticeResponseDto(notice), HttpStatus.CREATED);
    }

    @GetMapping("/{notice-id}")
    public ResponseEntity getNotice(@PathVariable("notice-id") long noticeId) {
        Notice notice = noticeService.getNotice(noticeId);
        List<Long> noticeIdList = noticeService.getMyNoticeIdList(notice.getCompany().getCompanyId());

        return new ResponseEntity(noticeMapper.noticeToNoticeDetailResponseDto(notice, noticeIdList), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getNotices(@Positive @RequestParam("page") int page,
                                     @Positive @RequestParam("size") int size) {
        Page<Notice> pageNotice = noticeService.getNotices(page-1, size);
        List<Notice> notices = pageNotice.getContent();

        return new ResponseEntity(
                new MultiResponseDto<>(noticeMapper.noticesToNoticeResponseDtos(notices), pageNotice),
                HttpStatus.OK);
    }

    @PatchMapping("/{company-id}")
    public ResponseEntity patchNotice (@PathVariable("company-id") long companyId,
                                       @RequestBody NoticePatchDto noticePatchDto) {
        Notice notice = noticeService.updateNotice(noticePatchDto, companyId);

        return new ResponseEntity(noticeMapper.noticeToNoticeResponseDto(notice), HttpStatus.CREATED);
    }

    @DeleteMapping("/{company-id}")
    public ResponseEntity deleteNotice(@PathVariable("company-id") long companyId,
                                       @RequestParam("noticeId") long noticeId) {
        noticeService.deleteNotice(companyId, noticeId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
