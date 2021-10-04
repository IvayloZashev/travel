package com.zashev.travel.model.response;

import java.math.BigDecimal;

public class TripBudget {
	private int travelTimes;
	
	public class Budget {
		private BigDecimal TR;
		private BigDecimal GR;
		private BigDecimal MK;
		private BigDecimal SR;
		private BigDecimal RO;
		public BigDecimal getTR() {
			return TR;
		}
		public void setTR(BigDecimal tR) {
			TR = tR;
		}
		public BigDecimal getGR() {
			return GR;
		}
		public void setGR(BigDecimal gR) {
			GR = gR;
		}
		public BigDecimal getMK() {
			return MK;
		}
		public void setMK(BigDecimal mK) {
			MK = mK;
		}
		public BigDecimal getSR() {
			return SR;
		}
		public void setSR(BigDecimal sR) {
			SR = sR;
		}
		public BigDecimal getRO() {
			return RO;
		}
		public void setRO(BigDecimal rO) {
			RO = rO;
		}
		
	}
	
	private Budget budget;

	public int getTravelTimes() {
		return travelTimes;
	}

	public void setTravelTimes(int travelTimes) {
		this.travelTimes = travelTimes;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	
}