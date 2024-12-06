package com.dduongdev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

public class BankStatementCSVParserTests {
	@Test
	public void shouldParserOneCorrectLine() throws Exception {
		final String line = "30-01-2017,-50,Tesco";
		
		BankStatementParser statementParser = new BankStatementCSVParser();
		
		final BankTransaction result = statementParser.parseFrom(line);
		
		final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
		final double tolerance = 0.0d;
		
		assertEquals(expected.getDate(), result.getDate());
		assertEquals(expected.getAmount(), result.getAmount(), tolerance);
		assertEquals(expected.getDescription(), result.getDescription());
	}
}
