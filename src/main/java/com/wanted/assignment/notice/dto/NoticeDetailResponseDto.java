package com.wanted.assignment.notice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NoticeDetailResponseDto {
    private long noticeId;

    private String companyName;

    private String companyNation;

    private String companyRegion;

    private String position;

    private long payment;

    private String content;

    private String techStack;

    //채용공고를 올린 회사가 올린 다른 채용공고
    private List<Long> idList;
}
