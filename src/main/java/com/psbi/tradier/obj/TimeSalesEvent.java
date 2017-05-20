package com.psbi.tradier.obj;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

/**
 * Created by Peter.Schmeltzer on 5/20/2017.
 */
public class TimeSalesEvent {

    public enum Interval {

        TICK("tick"), ONE_MINUTE("1min"), FIVE_MINUTE("5min"), FIFTEEN_MINUTE("15min");

        private final String tradierInterval;

        Interval(String tradierInterval) {
            this.tradierInterval = tradierInterval;
        }

        public String getTradierInterval() {
            return tradierInterval;
        }
    }

    /*
        <time>2014-04-03T10:15</time>
        <open>188.92</open>
        <close>188.74</close>
        <high>189.03</high>
        <low>188.72</low>
        <volume>2212195</volume>
     */

    @SerializedName("time")
    private final LocalDateTime time;
    @SerializedName("open")
    private final double open;
    @SerializedName("high")
    private final double high;
    @SerializedName("low")
    private final double low;
    @SerializedName("close")
    private final double close;
    @SerializedName("volume")
    private final long volume;

    public TimeSalesEvent(LocalDateTime time, double open, double high, double low, double close, long volume) {
        this.time = time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public LocalDateTime getTime() {
        return time;
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

    public long getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "TimeSalesEvent{" +
                "time=" + time +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                '}';
    }
}
