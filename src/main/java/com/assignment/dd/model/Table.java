package com.assignment.dd.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "table")
@XmlAccessorType(XmlAccessType.FIELD)
public class Table {

	@XmlElement(name = "name")
	private String name;

	@XmlElementWrapper(name = "columns")
	@XmlElement(name = "column")
	private List<Column> columns;

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
}
