package com.wanted.assignment.application;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    default ApplicationResponseDto applicationToApplicationResponseDto(Application application) {
        return ApplicationResponseDto.builder()
                .noticeId(application.getNotice().getNoticeId())
                .memberId(application.getMember().getMemberId())
                .build();
    };
}
