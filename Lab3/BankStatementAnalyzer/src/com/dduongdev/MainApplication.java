package com.dduongdev;

public class MainApplication {

    public static void main(final String[] args) throws Exception {

        final BankStatementAnalyzer bankStatementAnalyzer
                = new BankStatementAnalyzer();

        final BankStatementParser bankStatementParser
                = new BankStatementCSVParser();

        final Exporter exporter = new HtmlExporter();

        bankStatementAnalyzer.analyze("transactions.csv", bankStatementParser, exporter);

    }
}