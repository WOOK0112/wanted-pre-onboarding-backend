package com.wanted.assignment.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404,"존재하지 않는 회원 ID 입니다."),
    COMPANY_NOT_FOUND(404,"존재하지 않는 회사 ID 입니다."),
    COMPANY_DOES_NOT_MATCH(403,"채용공고와 작성자가 맞지 않습니다."),
    NOTICE_NOT_FOUND(404,"존재하지 않는 채용공고 ID 입니다."),
    APPLICATION_EXISTS(409,"이미 지원한 채용공고입니다.");


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }

}
