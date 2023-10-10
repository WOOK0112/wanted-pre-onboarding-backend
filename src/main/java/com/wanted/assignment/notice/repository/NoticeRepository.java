package com.wanted.assignment.notice.repository;

import com.wanted.assignment.notice.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    @Query("SELECT n.noticeId FROM Notice n WHERE n.company.companyId = :companyId")
    List<Long> findByNoticeIdList(@Param("companyId") long companyId);

    @Query("SELECT n FROM Notice n WHERE " +
            "n.content LIKE %:keyword% OR " +
            "n.companyName LIKE %:keyword% OR " +
            "n.companyNation LIKE %:keyword% OR " +
            "n.companyRegion LIKE %:keyword% OR " +
            "n.position LIKE %:keyword% OR " +
            "n.techStack LIKE %:keyword%")
    Page<Notice> findByKeyword(@Param("keyword")String keyword, Pageable pageable);
}
