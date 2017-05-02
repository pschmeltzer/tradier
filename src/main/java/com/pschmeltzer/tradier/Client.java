package com.pschmeltzer.tradier;

import com.pschmeltzer.tradier.obj.Quote;

import java.util.Collection;

/**
 * Created by Peter.Schmeltzer on 5/1/2017.
 */
public interface Client {

    Quote getQuote(String symbol);

    Collection<Quote> getQuotes(String... symbols);


}
