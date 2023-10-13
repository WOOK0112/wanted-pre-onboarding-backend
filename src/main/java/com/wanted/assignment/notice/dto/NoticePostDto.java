package com.wanted.assignment.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticePostDto {
    @NotBlank(message = "채용포지션을 입력해주세요.")
    private String position;

    @NotNull
    @Min(value = 1, message = "채용보상금을 입력해주세요.")
    private long payment;

    @NotBlank(message = "채용공고 내용을 입력해주세요.")
    private String content;

    @NotBlank(message = "채용기술스택을 입력해주세요.")
    private String techStack;
}
