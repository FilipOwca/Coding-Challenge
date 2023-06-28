package fdmgroup;

/**
 * The DailyAggregate class represents the aggregated information for a specific
 * ticker on a daily basis.
 * 
 * @author Filip
 *
 */
public class DailyAggregate extends DailyCollection {

	private double dailyVolume;

	/**
	 * Constructs a DailyAggregate object with the specified ticker.
	 *
	 * @param ticker The ticker symbol associated with the aggregated data
	 */
	public DailyAggregate(String ticker) {
		super(ticker);
	}

	public double getDailyVolume() {
		return dailyVolume;
	}

	public void setDailyVolume(double dailyVolume) {
		this.dailyVolume = dailyVolume;
	}

	@Override
	public String toString() {
		return "DailyAggregate [ticker=" + super.getTicker() + ", openPrice=" + super.getOpenPrice() + ", closePrice="
				+ super.getClosePrice() + ", highestPrice=" + super.getHighestPrice() + ", lowestPrice="
				+ super.getLowestPrice() + ", dailyVolume=" + dailyVolume + "]";
	}

}
