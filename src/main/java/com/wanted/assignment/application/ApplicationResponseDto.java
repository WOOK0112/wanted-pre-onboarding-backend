package com.wanted.assignment.application;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationResponseDto {
    private long noticeId;

    private long memberId;
}
