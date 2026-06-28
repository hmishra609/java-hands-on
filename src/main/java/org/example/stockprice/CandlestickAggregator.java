package org.example.stockprice;

import java.util.*;

class Transaction {
    String ticker;
    long timestamp;
    double price;

    public Transaction(String ticker, long timestamp, double price) {
        this.ticker = ticker;
        this.timestamp = timestamp;
        this.price = price;
    }
}

class OHLC {
    long intervalStart;
    double open, high, low, close;
    // We need to track the exact timestamps of the open and close trades
    // to know if a new trade we are iterating over came before or after them.
    long openTime, closeTime;

    public OHLC(long intervalStart, long timestamp, double price) {
        this.intervalStart = intervalStart;
        this.open = price;
        this.high = price;
        this.low = price;
        this.close = price;
        this.openTime = timestamp;
        this.closeTime = timestamp;
    }

    public void update(long timestamp, double price) {
        // Update High and Low based on price value
        this.high = Math.max(this.high, price);
        this.low = Math.min(this.low, price);

        // Update Open if this transaction happened chronologically earlier
        if (timestamp < this.openTime) {
            this.openTime = timestamp;
            this.open = price;
        }

        // Update Close if this transaction happened chronologically later
        if (timestamp > this.closeTime) {
            this.closeTime = timestamp;
            this.close = price;
        }
    }
}

public class CandlestickAggregator {
    
    // 5 minutes in milliseconds
    private static final long INTERVAL_MS = 5 * 60 * 1000; 

    public List<OHLC> getCandlesticks(List<Transaction> transactions) {
        // Maps the interval's starting timestamp to its OHLC data
        Map<Long, OHLC> timeBuckets = new HashMap<>();

        for (Transaction t : transactions) {
            // Math trick to round down to the nearest 5-minute bucket
            long intervalStart = t.timestamp - (t.timestamp % INTERVAL_MS);

            if (!timeBuckets.containsKey(intervalStart)) {
                // First time seeing a trade in this 5-minute window
                timeBuckets.put(intervalStart, new OHLC(intervalStart, t.timestamp, t.price));
            } else {
                // Update the existing window with the new trade
                timeBuckets.get(intervalStart).update(t.timestamp, t.price);
            }
        }

        // Return the aggregated results, typically sorted by time
        List<OHLC> result = new ArrayList<>(timeBuckets.values());
        result.sort(Comparator.comparingLong(o -> o.intervalStart));
        
        return result;
    }
}
