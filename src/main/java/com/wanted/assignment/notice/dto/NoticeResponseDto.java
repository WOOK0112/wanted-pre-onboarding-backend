package com.wanted.assignment.notice.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class NoticeResponseDto {
    private long noticeId;

    private String companyName;

    private String companyNation;

    private String companyRegion;

    private String position;

    private long payment;

    private String content;

    private String techStack;
}
