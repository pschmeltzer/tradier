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
    @SerializedName("exch")
    private final String exchange;
    @SerializedName("type") //stock, etf, option
    private final String securityType;
    @SerializedName("change") //daily net change
    private final double change;
    @SerializedName("change_percentage")
    private final double percentChange;
    @SerializedName("volume")
    private final int volume;
    @SerializedName("average_volume")
    private final int averageVolume;
    @SerializedName("last_volume")
    private final int lastVolume;
    @SerializedName("trade_date")
    private final long tradeDate;
    @SerializedName("open")
    private final double openPrice;
    @SerializedName("high")
    private final double highPrice;
    @SerializedName("low")
    private final double lowPrice;
    @SerializedName("close")
    private final double closePrice;
    @SerializedName("prevclose")
    private final double previousClosePrice;
    @SerializedName("week_52_high")
    private final double fiscalYearHigh;
    @SerializedName("week_52_low")
    private final double fiscalYearLow;
    @SerializedName("bid")
    private final double bid;
    @SerializedName("bidsize")
    private final int bidSize;
    @SerializedName("bidexch")
    private final String bidExchange;
    @SerializedName("bid_date")
    private final long bidDate;
    @SerializedName("ask")
    private final double ask;
    @SerializedName("asksize")
    private final int askSize;
    @SerializedName("askexch")
    private final String askExchange;
    @SerializedName("ask_date")
    private final long askDate;
    @SerializedName("open_interest")
    private final int openInterest;
    @SerializedName("underlying")
    private final String underlying;
    @SerializedName("strike")
    private final double strike;
    @SerializedName("contract_size")
    private final int contractSize;
    @SerializedName("expiration_date")
    private final String expirationDate;
    @SerializedName("expiration_type")
    private final String expirationType;
    @SerializedName("option_type")
    private final String optionType;

    public Quote(String symbol, String description, String exchange, String securityType, double change, double percentChange, int volume, int averageVolume, int lastVolume, long tradeDate, double openPrice, double highPrice, double lowPrice, double closePrice, double previousClosePrice, double fiscalYearHigh, double fiscalYearLow, double bid, int bidSize, String bidExchange, long bidDate, double ask, int askSize, String askExchange, long askDate, int openInterest, String underlying, double strike, int contractSize, String expirationDate, String expirationType, String optionType) {
        this.symbol = symbol;
        this.description = description;
        this.exchange = exchange;
        this.securityType = securityType;
        this.change = change;
        this.percentChange = percentChange;
        this.volume = volume;
        this.averageVolume = averageVolume;
        this.lastVolume = lastVolume;
        this.tradeDate = tradeDate;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.closePrice = closePrice;
        this.previousClosePrice = previousClosePrice;
        this.fiscalYearHigh = fiscalYearHigh;
        this.fiscalYearLow = fiscalYearLow;
        this.bid = bid;
        this.bidSize = bidSize;
        this.bidExchange = bidExchange;
        this.bidDate = bidDate;
        this.ask = ask;
        this.askSize = askSize;
        this.askExchange = askExchange;
        this.askDate = askDate;
        this.openInterest = openInterest;
        this.underlying = underlying;
        this.strike = strike;
        this.contractSize = contractSize;
        this.expirationDate = expirationDate;
        this.expirationType = expirationType;
        this.optionType = optionType;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDescription() {
        return description;
    }

    public String getExchange() {
        return exchange;
    }

    public String getSecurityType() {
        return securityType;
    }

    public double getChange() {
        return change;
    }

    public double getPercentChange() {
        return percentChange;
    }

    public int getVolume() {
        return volume;
    }

    public int getAverageVolume() {
        return averageVolume;
    }

    public int getLastVolume() {
        return lastVolume;
    }

    public long getTradeDate() {
        return tradeDate;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public double getPreviousClosePrice() {
        return previousClosePrice;
    }

    public double getFiscalYearHigh() {
        return fiscalYearHigh;
    }

    public double getFiscalYearLow() {
        return fiscalYearLow;
    }

    public double getBid() {
        return bid;
    }

    public int getBidSize() {
        return bidSize;
    }

    public String getBidExchange() {
        return bidExchange;
    }

    public long getBidDate() {
        return bidDate;
    }

    public double getAsk() {
        return ask;
    }

    public int getAskSize() {
        return askSize;
    }

    public String getAskExchange() {
        return askExchange;
    }

    public long getAskDate() {
        return askDate;
    }

    public int getOpenInterest() {
        return openInterest;
    }

    public String getUnderlying() {
        return underlying;
    }

    public double getStrike() {
        return strike;
    }

    public int getContractSize() {
        return contractSize;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getExpirationType() {
        return expirationType;
    }

    public long getEpochMillisExpirationDate() throws java.text.ParseException {
        java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        return df.parse(expirationDate).getTime();
    }

    public String getOptionType() {
        return optionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quote quote = (Quote) o;

        if (Double.compare(quote.change, change) != 0) return false;
        if (Double.compare(quote.percentChange, percentChange) != 0) return false;
        if (volume != quote.volume) return false;
        if (averageVolume != quote.averageVolume) return false;
        if (lastVolume != quote.lastVolume) return false;
        if (tradeDate != quote.tradeDate) return false;
        if (Double.compare(quote.openPrice, openPrice) != 0) return false;
        if (Double.compare(quote.highPrice, highPrice) != 0) return false;
        if (Double.compare(quote.lowPrice, lowPrice) != 0) return false;
        if (Double.compare(quote.closePrice, closePrice) != 0) return false;
        if (Double.compare(quote.previousClosePrice, previousClosePrice) != 0) return false;
        if (Double.compare(quote.fiscalYearHigh, fiscalYearHigh) != 0) return false;
        if (Double.compare(quote.fiscalYearLow, fiscalYearLow) != 0) return false;
        if (Double.compare(quote.bid, bid) != 0) return false;
        if (bidSize != quote.bidSize) return false;
        if (bidDate != quote.bidDate) return false;
        if (Double.compare(quote.ask, ask) != 0) return false;
        if (askSize != quote.askSize) return false;
        if (askDate != quote.askDate) return false;
        if (openInterest != quote.openInterest) return false;
        if (Double.compare(quote.strike, strike) != 0) return false;
        if (contractSize != quote.contractSize) return false;
        if (symbol != null ? !symbol.equals(quote.symbol) : quote.symbol != null) return false;
        if (description != null ? !description.equals(quote.description) : quote.description != null) return false;
        if (exchange != null ? !exchange.equals(quote.exchange) : quote.exchange != null) return false;
        if (securityType != null ? !securityType.equals(quote.securityType) : quote.securityType != null) return false;
        if (bidExchange != null ? !bidExchange.equals(quote.bidExchange) : quote.bidExchange != null) return false;
        if (askExchange != null ? !askExchange.equals(quote.askExchange) : quote.askExchange != null) return false;
        if (underlying != null ? !underlying.equals(quote.underlying) : quote.underlying != null) return false;
        if (expirationDate != null ? !expirationDate.equals(quote.expirationDate) : quote.expirationDate != null)
            return false;
        if (expirationType != null ? !expirationType.equals(quote.expirationType) : quote.expirationType != null)
            return false;
        return optionType != null ? optionType.equals(quote.optionType) : quote.optionType == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = symbol != null ? symbol.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (exchange != null ? exchange.hashCode() : 0);
        result = 31 * result + (securityType != null ? securityType.hashCode() : 0);
        temp = Double.doubleToLongBits(change);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(percentChange);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + volume;
        result = 31 * result + averageVolume;
        result = 31 * result + lastVolume;
        result = 31 * result + (int) (tradeDate ^ (tradeDate >>> 32));
        temp = Double.doubleToLongBits(openPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(highPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lowPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(closePrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(previousClosePrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fiscalYearHigh);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fiscalYearLow);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(bid);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + bidSize;
        result = 31 * result + (bidExchange != null ? bidExchange.hashCode() : 0);
        result = 31 * result + (int) (bidDate ^ (bidDate >>> 32));
        temp = Double.doubleToLongBits(ask);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + askSize;
        result = 31 * result + (askExchange != null ? askExchange.hashCode() : 0);
        result = 31 * result + (int) (askDate ^ (askDate >>> 32));
        result = 31 * result + openInterest;
        result = 31 * result + (underlying != null ? underlying.hashCode() : 0);
        temp = Double.doubleToLongBits(strike);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + contractSize;
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + (expirationType != null ? expirationType.hashCode() : 0);
        result = 31 * result + (optionType != null ? optionType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "symbol='" + symbol + '\'' +
                ", description='" + description + '\'' +
                ", exchange='" + exchange + '\'' +
                ", securityType='" + securityType + '\'' +
                ", change=" + change +
                ", percentChange=" + percentChange +
                ", volume=" + volume +
                ", averageVolume=" + averageVolume +
                ", lastVolume=" + lastVolume +
                ", tradeDate=" + tradeDate +
                ", openPrice=" + openPrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", closePrice=" + closePrice +
                ", previousClosePrice=" + previousClosePrice +
                ", fiscalYearHigh=" + fiscalYearHigh +
                ", fiscalYearLow=" + fiscalYearLow +
                ", bid=" + bid +
                ", bidSize=" + bidSize +
                ", bidExchange='" + bidExchange + '\'' +
                ", bidDate=" + bidDate +
                ", ask=" + ask +
                ", askSize=" + askSize +
                ", askExchange='" + askExchange + '\'' +
                ", askDate=" + askDate +
                ", openInterest=" + openInterest +
                ", underlying='" + underlying + '\'' +
                ", strike=" + strike +
                ", contractSize=" + contractSize +
                ", expirationDate='" + expirationDate + '\'' +
                ", expirationType='" + expirationType + '\'' +
                ", optionType='" + optionType + '\'' +
                '}';
    }
}
