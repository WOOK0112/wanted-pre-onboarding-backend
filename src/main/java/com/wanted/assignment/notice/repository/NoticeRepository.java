package com.wanted.assignment.notice.repository;

import com.wanted.assignment.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
