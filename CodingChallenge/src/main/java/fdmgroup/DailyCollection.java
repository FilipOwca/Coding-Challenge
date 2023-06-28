package fdmgroup;

public class DailyCollection {

	private String ticker;
	private double openPrice;
	private double closePrice;
	private double highestPrice;
	private double lowestPrice;

	public DailyCollection(String ticker) {
		super();
		this.ticker = ticker;
	}

	public String getTicker() {
		return ticker;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public double getClosePrice() {
		return closePrice;
	}

	public double getHighestPrice() {
		return highestPrice;
	}

	public double getLowestPrice() {
		return lowestPrice;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}

	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}

	public void setHighestPrice(double highestPrice) {
		this.highestPrice = highestPrice;
	}

	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

}
