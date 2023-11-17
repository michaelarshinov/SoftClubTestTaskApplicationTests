package ru.michaelarshinov.soft.club.test.task.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ru.michaelarshinov.soft.club.test.task.SoftClubTestTaskApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SoftClubTestTaskApplication.class)
class CurrencyServiceImplTest {

	@Autowired
	CurrencyServiceImpl service;
	
	@Test
	final void testGetCurrencyInRubles() {
		List<Double> values = service.getCurrencyInRubles(CurrencyService.Currency.USD, 
				"2000-01-01", "2000-01-07");
		assertEquals(values.get(0), 27, 0.1);
		values = service.getCurrencyInRubles(CurrencyService.Currency.USD, 
				"1000-01-01", "1000-01-07");
		assertEquals(values.size(), 0);
		values = service.getCurrencyInRubles(CurrencyService.Currency.EURO, 
				"3000-01-01", "3000-01-07");
		assertEquals(values.size(), 0);
	}

}
