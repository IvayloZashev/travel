package com.zashev.travel.model.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rates {
	@JsonProperty("TRY")
    private BigDecimal TRY;
	@JsonProperty("RSD")
    private BigDecimal RSD;
	@JsonProperty("MKD")
    private BigDecimal MKD;
	@JsonProperty("RON")
    private BigDecimal RON;
	public BigDecimal getTRY() {
		return TRY;
	}
	public void setTRY(BigDecimal tRY) {
		TRY = tRY;
	}
	public BigDecimal getRSD() {
		return RSD;
	}
	public void setRSD(BigDecimal rSD) {
		RSD = rSD;
	}
	public BigDecimal getMKD() {
		return MKD;
	}
	public void setMKD(BigDecimal mKD) {
		MKD = mKD;
	}
	public BigDecimal getRON() {
		return RON;
	}
	public void setRON(BigDecimal rON) {
		RON = rON;
	}
    
}
