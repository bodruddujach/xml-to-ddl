package com.assignment.dd.model;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Column {

	@XmlElement(name = "name")
	private String name;

	@XmlElement(name = "type")
	private String type;

	@XmlElement(name = "isPrimaryKey")
	private boolean primaryKey;

	@XmlElement(name = "isNullable")
	private boolean nullable;

	@XmlElement(name = "isUnique")
	private boolean unique;

	@XmlElement(name = "isForeignKey")
	private boolean foreignKey;

	@XmlElement(name = "referencedTableName")
	private String referencedTableName;

	// Getters and setters
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public boolean isPrimaryKey() {
		return primaryKey;
	}

	public boolean isNullable() {
		return nullable;
	}

	public boolean isUnique() {
		return unique;
	}

	public boolean isForeignKey() {
		return foreignKey;
	}

	public String getReferencedTableName() {
		return referencedTableName;
	}
}
