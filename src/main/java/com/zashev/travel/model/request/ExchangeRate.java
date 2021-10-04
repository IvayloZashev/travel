package com.zashev.travel.model.request;

import java.time.LocalDate;

/**
 * Object for exchange rate api endpoint. 
 * @see <a href="https://manage.exchangeratesapi.io/quickstart">https://manage.exchangeratesapi.io/quickstart</a>
 */
public class ExchangeRate {
	private boolean success;
    private long timestamp;
    private String base;
    private LocalDate date;
    private Rates rates;

    public boolean getSuccess() { return success; }
    public void setSuccess(boolean value) { this.success = value; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long value) { this.timestamp = value; }

    public String getBase() { return base; }
    public void setBase(String value) { this.base = value; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate value) { this.date = value; }

    public Rates getRates() { return rates; }
    public void setRates(Rates value) { this.rates = value; }
    
}
