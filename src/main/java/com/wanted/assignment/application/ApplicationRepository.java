package com.wanted.assignment.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Application findByNoticeNoticeIdAndMemberMemberId(Long noticeId, Long memberId);

    @Query("SELECT a.notice.noticeId FROM Application a WHERE a.member.memberId = :memberId")
    List<Long> findNoticeIdListByMemberId(@Param("memberId") long memberId);
}
