package com.wanted.assignment.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticePatchDto {
    @NotNull
    @Min(value = 1, message = "채용공고 ID를 입력해주세요")
    private long noticeId;

    private String position;

    private long payment;

    private String content;

    private String techStack;
}
