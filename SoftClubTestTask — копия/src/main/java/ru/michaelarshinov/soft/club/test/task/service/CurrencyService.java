package ru.michaelarshinov.soft.club.test.task.service;

import java.util.Date;
import java.util.List;

/**
 * @author Админ
 *
 */
public interface CurrencyService {
	
	/**
	 * @param currency
	 * @param fromDate {@value 2023-11-17}
	 * @param toDate {@value 2023-11-18}
	 * @return
	 */
	List<Double> getCurrencyInRubles(Currency currency, String fromDate, String toDate);
	
	enum Currency {
		USD("R01235"), EURO("R01239");
		private String code;
		Currency(String string) {
			code = string;
		}
	}
}
