package com.assignment.dd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.assignment.dd.model.Tables;
import com.assignment.dd.service.DatabaseService;
import com.assignment.dd.utility.XMLParser;

import jakarta.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/xml")
public class XMLController {

	@Autowired
	private final DatabaseService databaseService;

	public XMLController(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}

	@PostMapping("/upload")
	public String uploadXML(@RequestParam("file") MultipartFile file) throws JAXBException, IOException {
		File tempFile = File.createTempFile("uploaded-", ".xml");
		file.transferTo(tempFile);

		Tables tables = XMLParser.parseXML(tempFile.getAbsolutePath());
		databaseService.createTables(tables.getTables());

		return "Tables created successfully!";
	}
}
