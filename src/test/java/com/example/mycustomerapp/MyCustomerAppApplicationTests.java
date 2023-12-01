package com.example.mycustomerapp;

import com.example.mycustomerapp.customerRepo.CustomerHashMap;
import com.example.mycustomerapp.customerRepo.MyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@SpringBootTest
class MyCustomerAppApplicationTests {

	private MyRepository myRepository= mock(CustomerHashMap.class);

	@Test
	void contextLoads() {
	}

}
