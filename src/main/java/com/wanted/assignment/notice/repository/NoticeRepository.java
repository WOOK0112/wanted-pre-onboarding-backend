package com.wanted.assignment.notice.repository;

import com.wanted.assignment.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    @Query("SELECT n.noticeId FROM Notice n WHERE n.company.companyId = :companyId")
    List<Long> findNoticeIdList(@Param("companyId") long companyId);
}
