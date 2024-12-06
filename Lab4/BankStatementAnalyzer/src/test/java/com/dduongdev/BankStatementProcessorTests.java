package com.dduongdev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BankStatementProcessorTests {
	List<BankTransaction> bankTransactions = List.of(
            new BankTransaction(LocalDate.of(2017, 1, 30), -100, "Deliveroo"),
            new BankTransaction(LocalDate.of(2017, 1, 30), -50, "Tesco"),
            new BankTransaction(LocalDate.of(2017, 2, 1), 6000, "Salary"),
            new BankTransaction(LocalDate.of(2017, 2, 2), 2000, "Royalties"),
            new BankTransaction(LocalDate.of(2017, 2, 2), -4000, "Rent"),
            new BankTransaction(LocalDate.of(2017, 2, 3), 3000, "Tesco"),
            new BankTransaction(LocalDate.of(2017, 2, 5), -30, "Cinema")
        );

	@Test
	public void calculateTotalAmount_shouldSuccess() throws Exception {
		BankStatementProcessor statementProcessor = new BankStatementProcessor(bankTransactions);
		
		final double totalAmount = statementProcessor.calculateTotalAmount();
		
		final double expected = 6820;
		final double tolerance = 0.0d;
		
		assertEquals(totalAmount, expected, tolerance);
	}
	
	@Test
	public void calculateTotalAmount_shouldWrong() throws Exception {
		BankStatementProcessor statementProcessor = new BankStatementProcessor(bankTransactions);
		
		final double totalAmount = statementProcessor.calculateTotalAmount();
		
		final double expected = 682;
		final double tolerance = 0.0d;
		
		assertEquals(totalAmount, expected, tolerance);
	}
	
	@Test
	public void calculateTotalInMonth_shouldSuccess() throws Exception {
		BankStatementProcessor statementProcessor = new BankStatementProcessor(bankTransactions);
		
		final double totalAmountInJannuary = statementProcessor.calculateTotalInMonth(Month.JANUARY);
		
		final double expected = -150;
		final double tolerance = 0.0d;
		
		assertEquals(totalAmountInJannuary, expected, tolerance);
	}
	
	@Test
	public void calculateTotalForCategory_shouldSuccess() throws Exception {
		BankStatementProcessor statementProcessor = new BankStatementProcessor(bankTransactions);
		
		final double totalForCategory = statementProcessor.calculateTotalForCategory("Tesco");
		
		final double expected = 2950;
		final double tolerance = 0.0d;
		
		assertEquals(totalForCategory, expected, tolerance);
	}
}
