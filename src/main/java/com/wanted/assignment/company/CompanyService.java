package com.wanted.assignment.company;

import com.wanted.assignment.exception.BusinessLogicException;
import com.wanted.assignment.exception.ExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CompanyService {

    private final CompanyRepository companyRepository;
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company getCompany(long companyId) {
        Optional<Company> company = companyRepository.findById(companyId);

        return company.orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.COMPANY_NOT_FOUND)
        );
    }
}
