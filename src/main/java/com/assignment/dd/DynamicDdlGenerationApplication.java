package com.assignment.dd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assignment.dd.model.Table;
import com.assignment.dd.model.Tables;
import com.assignment.dd.service.DatabaseService;
import com.assignment.dd.utility.XMLParser;

import jakarta.xml.bind.JAXBException;

@SpringBootApplication
public class DynamicDdlGenerationApplication implements CommandLineRunner {

	@Autowired
	private DatabaseService databaseService;

	public static void main(String[] args) {
		SpringApplication.run(DynamicDdlGenerationApplication.class, args);
	}

	@Override
	public void run(String... args) throws JAXBException {
	// You can run sample src/main/resources/schema.xml just by un-commenting the
	// below code block

	//	String xmlFilePath = "src/main/resources/schema.xml";
	//	Tables tables = XMLParser.parseXML(xmlFilePath); List<Table> tableList = tables.getTables();
	//	databaseService.createTables(tableList);
	}
}
