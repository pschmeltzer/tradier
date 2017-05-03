package com.psbi.tradier.obj;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bicabone on 5/2/2017.
 */
public class HistoricalDailyPrice {
    @SerializedName("date")
    private final String date;
    @SerializedName("open")
    private final double open;
    @SerializedName("high")
    private final double high;
    @SerializedName("low")
    private final double low;
    @SerializedName("close")
    private final double close;
    @SerializedName("volume")
    private final int volume;

    public HistoricalDailyPrice(String date, double open, double high, double low, double close, int volume) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public String getDate() {
        return date;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getClose() {
        return close;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoricalDailyPrice that = (HistoricalDailyPrice) o;

        if (Double.compare(that.open, open) != 0) return false;
        if (Double.compare(that.high, high) != 0) return false;
        if (Double.compare(that.low, low) != 0) return false;
        if (Double.compare(that.close, close) != 0) return false;
        if (volume != that.volume) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = date != null ? date.hashCode() : 0;
        temp = Double.doubleToLongBits(open);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(high);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(low);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(close);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + volume;
        return result;
    }

    @Override
    public String toString() {
        return "HistoricalDailyPrice{" +
                "date='" + date + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                '}';
    }
}
