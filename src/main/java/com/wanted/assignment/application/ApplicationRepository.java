package com.wanted.assignment.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Application findByNoticeNoticeIdAndMemberMemberId(Long noticeId, Long memberId);

}
