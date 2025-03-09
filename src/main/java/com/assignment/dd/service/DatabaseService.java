package com.assignment.dd.service;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.dd.exception.ForeignKeyReferenceException;
import com.assignment.dd.exception.GeneralSQLExecutionException;
import com.assignment.dd.exception.TableAlreadyExistsException;
import com.assignment.dd.model.Table;
import com.assignment.dd.utility.SQLGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

@Service
public class DatabaseService {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseService.class);
	private final JdbcTemplate jdbcTemplate;

	public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Transactional(rollbackFor = { RuntimeException.class, SQLException.class })
	public void createTables(List<Table> tables) {
		for (Table table : tables) {
			try {
				String sql = SQLGenerator.generateCreateTableSQL(table);
				logger.info("Executing TABLE: {}", table.getName());
				logger.debug("Executing SQL: \n{}", sql);

				// Execute the SQL to create the table
				jdbcTemplate.execute(sql);

			} catch (DataAccessException e) {
				handleSQLException(e, table);
				throw new RuntimeException("Table creation failed, rolling back all changes."); // Re-throw as RuntimeException to trigger rollback
			}
		}
	}

	private void handleSQLException(Exception e, Table table) {
		String errorMessage = e.getMessage().toLowerCase();
		String cause = e.getCause() != null ? e.getCause().toString().toLowerCase() : "";
		// Check for table already exists error
		if (errorMessage.contains("already exists") || cause.contains("already exists")) {
			logger.error("Table '{}' already exists in the database.", table.getName());
			throw new TableAlreadyExistsException("Table '" + table.getName() + "' already exists in the database.");
		}

		// Check for foreign key constraint violation (referencing a table that doesn't exist)
		if (errorMessage.contains("foreign key constraint fails") || cause.contains("foreign key constraint fails")) {
			logger.error("Foreign key reference error for table '{}'.", table.getName());
			throw new ForeignKeyReferenceException(
					"Foreign key reference error in table '" + table.getName() + "'. Check referenced tables.");
		}

		// For any other SQL error
		logger.error("SQL execution failed for table '{}'. Error: {}, Cause", table.getName(), e.getMessage(), cause);
		throw new GeneralSQLExecutionException(
				"SQL execution failed for table '" + table.getName() + "'. Please check the SQL syntax.");
	}
}