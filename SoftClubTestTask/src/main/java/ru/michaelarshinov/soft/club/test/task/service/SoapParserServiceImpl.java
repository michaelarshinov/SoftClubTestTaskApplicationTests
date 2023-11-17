package ru.michaelarshinov.soft.club.test.task.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Service
public class SoapParserServiceImpl implements SoapParserService {

	private static final Logger logger = LoggerFactory.getLogger(SoapParserServiceImpl.class);
	
	@Override
	public List<Double> getValues(String xml, int level1, int level2) {
		List<Double> list = new ArrayList<>();
		Node body;
		try {
			body = loadXMLString(xml).getFirstChild();
			while(level1-->0) body = body.getFirstChild();
			NodeList nodes = body.getChildNodes();
			for (int i=0; i<nodes.getLength(); i++) {
				Node node = nodes.item(0).getChildNodes().item(level2);
				list.add(Double.parseDouble(node.getTextContent()));
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return list;
	}
	
	public static Document loadXMLString(String response) throws Exception{
	    DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    InputSource is = new InputSource(new StringReader(response));
	    return db.parse(is);
	}
}
