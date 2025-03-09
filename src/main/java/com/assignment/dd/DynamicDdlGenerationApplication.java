package com.assignment.dd;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assignment.dd.model.Table;
import com.assignment.dd.model.Tables;
import com.assignment.dd.utility.XMLParser;

import jakarta.xml.bind.JAXBException;

@SpringBootApplication
public class DynamicDdlGenerationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DynamicDdlGenerationApplication.class, args);
	}

	@Override
	public void run(String... args) throws JAXBException {
		String xmlFilePath = "src/main/resources/schema.xml";

		Tables tables = XMLParser.parseXML(xmlFilePath);
		List<Table> tableList = tables.getTables();
	}
}
