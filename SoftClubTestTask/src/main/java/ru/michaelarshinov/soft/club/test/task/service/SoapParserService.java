package ru.michaelarshinov.soft.club.test.task.service;

import java.util.List;

public interface SoapParserService {
	List<Double> getValues(String xml, int level1, int level2);
}
