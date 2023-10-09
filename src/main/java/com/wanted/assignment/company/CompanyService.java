package com.wanted.assignment.company;

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
                () -> new RuntimeException()
        );
    }
}
