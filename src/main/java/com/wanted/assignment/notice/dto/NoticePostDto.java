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
public class NoticePostDto {
    @NotBlank
    private String position;

    @NotBlank
    private long payment;

    @NotBlank
    private String content;

    @NotBlank
    private String techStack;
}
