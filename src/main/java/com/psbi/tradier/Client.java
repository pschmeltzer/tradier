package com.psbi.tradier;

import com.psbi.tradier.obj.HistoricalDailyPrice;
import com.psbi.tradier.obj.Quote;
import com.psbi.tradier.obj.TimeSalesEvent;

import java.util.Collection;

/**
 * Created by Peter.Schmeltzer on 5/1/2017.
 */
public interface Client {

    Quote getQuote(String symbol);

    Collection<Quote> getQuotes(String... symbols);

    //important that longs are epochMillis not seconds, etc.
    Collection<HistoricalDailyPrice> getHistory(long fromDate, long toDate, String symbol);

    Collection<HistoricalDailyPrice> getHistory(String symbol);

    Collection<TimeSalesEvent> getTimeSalesData(String symbol, TimeSalesEvent.Interval interval, long startTime, long endTime);
}
