package com.wanted.assignment;

import com.google.gson.Gson;
import com.wanted.assignment.company.Company;
import com.wanted.assignment.company.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompanyRepositoryTest {
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void findByCompanyIdTest() {
        Company company = new Company();
        company.setName("원티드");
        company.setNation("한국");
        company.setRegion("서울");

        companyRepository.save(company);
        Optional<Company> findCompany = companyRepository.findById(company.getCompanyId());

        Company result = findCompany.orElseThrow(
                () -> new RuntimeException()
        );

        System.out.println("테스트");
        System.out.println(result.getName());
    }


}
