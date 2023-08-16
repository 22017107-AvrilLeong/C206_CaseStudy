/**
 * 
 */

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22010980, 14 Aug 2023 2:19:51 pm
 */

public class CurrencyC {
		private int currencyCode;
		private String currencyName;
		private double exchangeRate;
		
		public CurrencyC(int currencyCode, String currencyName, double exchangeRate) {
			this.currencyCode = currencyCode;
			this.currencyName = currencyName;
			this.exchangeRate = exchangeRate;
		}
		
		public int getCurrencyCode() {
			return currencyCode;
		}
		
		public String getCurrencyName() {
			return currencyName;
		}

		public double getExchangeRate() {
			return exchangeRate;
		}
		
		public void setCurrencyCode(int currencyCode) {
			this.currencyCode = currencyCode;
		}
		
		public void setCurrencyName(String currencyName) {
			this.currencyName = currencyName;
		}

		public void setExchangeRate(double exchangeRate) {
			this.exchangeRate = exchangeRate;
		}
	}

