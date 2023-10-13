package com.wanted.assignment.application;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/application")
@Validated
@Slf4j
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ApplicationMapper applicationMapper;

    public ApplicationController(ApplicationService applicationService, ApplicationMapper applicationMapper) {
        this.applicationService = applicationService;
        this.applicationMapper = applicationMapper;
    }

    @PostMapping("/{notice-id}")
    public ResponseEntity postApplication (@PathVariable("notice-id") long noticeId,
                                           @RequestParam("memberId") long memberId) {
        Application application = applicationService.createApplication(noticeId, memberId);

        return new ResponseEntity(applicationMapper.applicationToApplicationResponseDto(application), HttpStatus.CREATED);
    }
}
