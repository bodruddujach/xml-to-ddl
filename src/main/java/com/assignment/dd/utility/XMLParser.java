package com.assignment.dd.utility;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

import com.assignment.dd.model.Tables;

public class XMLParser {
	public static Tables parseXML(String filePath) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Tables.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (Tables) unmarshaller.unmarshal(new File(filePath));
	}
}