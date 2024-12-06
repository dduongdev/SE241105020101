package com.dduongdev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.Test;

public class IntegrationTests {
	/**
	 * Test toàn bộ luồng chương trình từ đọc file, chuyển đổi dữ liệu thành đối tượng, và phân tích dữ liệu.
	 * 
	 * @author dduongdev
	 */
	@Test
	public void csvParser_processor_shouldSuccess() throws Exception {
		final Path filePath = Paths.get("src/transactions.csv");
		final List<String> lines = Files.readAllLines(filePath);
		
		BankStatementParser statementParser = new BankStatementCSVParser();
		
		final List<BankTransaction> bankTransactions = statementParser.parseLinesFrom(lines);
		
		BankStatementProcessor statementProcessor = new BankStatementProcessor(bankTransactions);
		
		final double totalAmount = statementProcessor.calculateTotalAmount();
		final double totalAmountInJannuary = statementProcessor.calculateTotalInMonth(Month.JANUARY);
		final double totalForCategory = statementProcessor.calculateTotalForCategory("Tesco");
		
		final double expectedTotalAmount = 6820;
		final double expectedTotalAmountInJanuary = -150;
		final double expectedTotalForCategory = 2950;
		final double tolerance = 0.0d;
		
		assertEquals(totalAmount, expectedTotalAmount, tolerance);
		assertEquals(totalAmountInJannuary, expectedTotalAmountInJanuary, tolerance);
		assertEquals(totalForCategory, expectedTotalForCategory, tolerance);
	}
}
