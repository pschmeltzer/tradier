package com.psbi.tradier.obj;

import java.time.LocalDateTime;

/**
 * Created by Peter.Schmeltzer on 5/20/2017.
 */
public class TimeSalesEvent {

    /*
        <time>2014-04-03T10:15</time>
        <open>188.92</open>
        <close>188.74</close>
        <high>189.03</high>
        <low>188.72</low>
        <volume>2212195</volume>
     */

    private final LocalDateTime time;
    private final double open;
    private final double high;
    private final double low;
    private final double close;
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
