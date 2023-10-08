package com.wanted.assignment.notice.mapper;

import com.wanted.assignment.company.Company;
import com.wanted.assignment.notice.dto.NoticePatchDto;
import com.wanted.assignment.notice.dto.NoticePostDto;
import com.wanted.assignment.notice.dto.NoticeResponseDto;
import com.wanted.assignment.notice.entity.Notice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoticeMapper {
    default Notice noticePostDtoToNotice (NoticePostDto noticePostDto, Company company) {
        return Notice.builder()
                .companyName(company.getName())
                .companyNation(company.getNation())
                .companyRegion(company.getRegion())
                .position(noticePostDto.getPosition())
                .payment(noticePostDto.getPayment())
                .content(noticePostDto.getContent())
                .techStack(noticePostDto.getTechStack())
                .company(company)
                .build();
    }

    Notice noticePatchDtoToNotice (NoticePatchDto noticePatchDto, Company company);

    NoticeResponseDto noticeToNoticeResponseDto (Notice notice);
}
