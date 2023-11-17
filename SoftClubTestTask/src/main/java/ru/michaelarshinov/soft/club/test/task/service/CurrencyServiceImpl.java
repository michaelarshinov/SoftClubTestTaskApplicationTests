package ru.michaelarshinov.soft.club.test.task.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import ru.michaelarshinov.soft.club.test.task.constants.Constants;

@Service("currencyService")
public class CurrencyServiceImpl implements CurrencyService {

	private static final Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);
	
	
	@Value("${cbr.endpoint}")
	String cbrEndpoint;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	SoapParserService soapService;
	
	@Override
	public List<Double> getCurrencyInRubles(Currency currency, String fromDate, String toDate) {
		List<Double> values = new ArrayList<>();
	    try {
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Type", "text/xml; charset=utf-8");
	        HttpEntity<String> request = new HttpEntity<>(String.format(Constants.REQUEST_GET_CURRENCY,
	        		fromDate, toDate, "R01235"), headers);
	        String result = restTemplate.postForObject(cbrEndpoint, request, String.class);
	        if(result.contains("<soap:Envelope")) {
	        	values = soapService.getValues(result, 4, 3);
	        }
	    }
	    catch(Exception e) {
	        logger.error(e.getMessage(), e);
	    }
	    return values;
	}

}
