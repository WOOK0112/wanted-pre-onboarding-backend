package com.wanted.assignment;

import com.google.gson.Gson;
import com.wanted.assignment.company.Company;
import com.wanted.assignment.company.CompanyRepository;
import com.wanted.assignment.notice.dto.NoticePostDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class AssignmentApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private Gson gson;

	@Autowired
	private CompanyRepository companyRepository;

	@Test
	void postCompanyTest() {
		Company company = new Company();
		company.setName("원티드");
		company.setNation("한국");
		company.setRegion("서울");

		companyRepository.save(company);
	}


}
