package ru.michaelarshinov.soft.club.test.task.constants;

public class Constants {
	public static final String REQUEST_GET_CURRENCY = 
	
	"<?xml version='1.0' encoding='utf-8'?> "+
	"<soap12:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap12='http://www.w3.org/2003/05/soap-envelope'> "+
	"  <soap12:Body> "+
	"    <GetCursDynamicXML xmlns='http://web.cbr.ru/'> "+
	"      <FromDate>%s</FromDate> "+
	"      <ToDate>%s</ToDate> "+
	"      <ValutaCode>%s</ValutaCode> "+
	"    </GetCursDynamicXML> "+
	"  </soap12:Body> "+
	"</soap12:Envelope> ";
}
