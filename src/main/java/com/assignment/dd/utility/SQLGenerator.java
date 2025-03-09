package com.assignment.dd.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.assignment.dd.model.Column;
import com.assignment.dd.model.Table;

public class SQLGenerator {

	public static String generateCreateTableSQL(Table table) {
		StringBuilder sql = new StringBuilder("CREATE TABLE ").append(table.getName()).append(" (\n");

		List<String> columnDefinitions = table.getColumns().stream().map(column -> {
			StringBuilder columnDef = new StringBuilder(column.getName()).append(" ")
					.append(getSQLType(column.getType()));

			if (column.isPrimaryKey())
				columnDef.append(" PRIMARY KEY");
			if (column.isUnique())
				columnDef.append(" UNIQUE");
			if (!column.isNullable())
				columnDef.append(" NOT NULL");

			return columnDef.toString();
		}).collect(Collectors.toList());

		// Add foreign key constraints separately
		table.getColumns().stream().filter(Column::isForeignKey).forEach(column -> columnDefinitions
				.add("FOREIGN KEY (" + column.getName() + ") REFERENCES " + column.getReferencedTableName() + "(id)"));

		sql.append(String.join(",\n", columnDefinitions));
		sql.append("\n);");

		return sql.toString();
	}

	private static String getSQLType(String type) {
		return switch (type.toLowerCase()) {
		case "varchar" -> "VARCHAR(255)";
		case "text" -> "TEXT";
		case "bool", "boolean" -> "BOOLEAN";
		case "date" -> "DATE";
		case "int", "integer" -> "INTEGER";
		case "uuid" -> "UUID";
		default -> throw new IllegalArgumentException("Unsupported type: " + type);
		};
	}

}
