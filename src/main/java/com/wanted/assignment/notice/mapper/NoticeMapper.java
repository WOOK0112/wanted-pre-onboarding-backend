package com.wanted.assignment.notice.mapper;

import com.wanted.assignment.company.Company;
import com.wanted.assignment.notice.dto.NoticeDetailResponseDto;
import com.wanted.assignment.notice.dto.NoticePatchDto;
import com.wanted.assignment.notice.dto.NoticePostDto;
import com.wanted.assignment.notice.dto.NoticeResponseDto;
import com.wanted.assignment.notice.entity.Notice;
import org.mapstruct.Mapper;

import java.util.List;

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

    List<NoticeResponseDto> noticesToNoticeResponseDtos(List<Notice> notices);

    NoticeResponseDto noticeToNoticeResponseDto (Notice notice);

    default NoticeDetailResponseDto noticeToNoticeDetailResponseDto (Notice notice, List<Long> noticeIdList){
        return NoticeDetailResponseDto.builder()
                .noticeId(notice.getNoticeId())
                .companyName(notice.getCompanyName())
                .companyNation(notice.getCompanyNation())
                .companyRegion(notice.getCompanyRegion())
                .position(notice.getPosition())
                .payment(notice.getPayment())
                .content(notice.getContent())
                .techStack(notice.getTechStack())
                .idList(noticeIdList)
                .build();
    }
}
