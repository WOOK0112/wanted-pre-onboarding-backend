package com.wanted.assignment.member;

import com.wanted.assignment.company.Company;
import com.wanted.assignment.notice.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

//    @OneToMany(mappedBy = "member")
//    private List<Notice> noticeList = new ArrayList<>();
}
