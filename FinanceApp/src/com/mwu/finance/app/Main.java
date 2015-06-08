package com.mwu.finance.app;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Stock stock = YahooFinance.get("INTC");

        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

        stock.print();

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.YEAR, -1); // from 1 year ago

        Stock google = YahooFinance.get("GOOG");
        List<HistoricalQuote> googleHistQuotes = google.getHistory(from, to, Interval.DAILY);

        System.out.println(googleHistQuotes.size());


    }
}
