package com.wanted.assignment.notice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

//사용자가 지원한 채용공고 Id목록 응답DTO
@Data
@Builder
public class ApplicationNoticeResponseDto {
    private long memberId;
    private List<Long> noticeIdList;
}
