package com.assignment.dd.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "tables")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tables {

	@XmlElement(name = "table")
	private List<Table> tables;

	public List<Table> getTables() {
		return tables;
	}
}
