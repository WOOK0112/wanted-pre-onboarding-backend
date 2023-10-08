package com.wanted.assignment.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticePatchDto {
    @NotBlank
    private long noticeId;

    private String position;

    private long payment;

    private String content;

    private String techStack;
}
