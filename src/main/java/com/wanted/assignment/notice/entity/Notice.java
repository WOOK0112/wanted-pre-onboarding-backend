package com.wanted.assignment.notice.entity;

import com.wanted.assignment.company.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long noticeId;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String companyNation;

    @Column(nullable = false)
    private String companyRegion;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private long payment;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String techStack;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;
}
