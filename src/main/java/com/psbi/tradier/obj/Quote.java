package com.psbi.tradier.obj;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Peter.Schmeltzer on 5/1/2017.
 */
public class Quote {

    @SerializedName("symbol")
    private final String symbol;
    @SerializedName("description")
    private final String description;


    public Quote(String symbol, String description) {
        this.symbol = symbol;
        this.description = description;
    }


}
