package fdmgroup;

/**
 * The Index class represents an index price calculated based on the prices of
 * different tickers. It tracks the open price, close price, highest price, and
 * lowest price of the index.
 * 
 * @author Filip
 *
 */
public class Index extends DailyCollection {

	private static final String ABC_NAME = "ABC";
	private static final String MEGA_NAME = "MEGA";
	private static final String NGL_NAME = "NGL";
	private static final String TRX_NAME = "TRX";

	private final double ABC = 0.1;
	private final double MEGA = 0.3;
	private final double NGL = 0.4;
	private final double TRX = 0.2;

	private static double lastABCPrice;
	private static double lastMEGAPrice;
	private static double lastNGLPrice;
	private static double lastTRXPrice;

	/**
	 * Constructs an Index object with the specified ticker.
	 *
	 * @param ticker The ticker symbol associated with the index
	 */
	public Index(String ticker) {
		super(ticker);
	}

	/**
	 * Updates the index values with the latest price for a specific ticker.
	 *
	 * @param ticker The ticker symbol
	 * @param price  The price of the ticker
	 */
	public void update(String ticker, double price) {

		switch (ticker) {
		case ABC_NAME:
			lastABCPrice = price;
			break;
		case MEGA_NAME:
			lastMEGAPrice = price;
			break;
		case NGL_NAME:
			lastNGLPrice = price;
			break;
		case TRX_NAME:
			lastTRXPrice = price;
			break;
		}

//		Index calculation is possible only after all market prices are available on the first traded day
		if (lastABCPrice != 0 && lastMEGAPrice != 0 && lastNGLPrice != 0 && lastTRXPrice != 0) {
			double currentPrice = ABC * lastABCPrice + MEGA * lastMEGAPrice + NGL * lastNGLPrice + TRX * lastTRXPrice;

			if (super.getOpenPrice() == 0) {
				super.setOpenPrice(currentPrice);
			}

			super.setClosePrice(currentPrice);

			if (super.getHighestPrice() == 0 || (super.getHighestPrice() < currentPrice)) {
				super.setHighestPrice(currentPrice);
			}

			if (super.getLowestPrice() == 0 || super.getLowestPrice() > currentPrice) {
				super.setLowestPrice(currentPrice);
			}
		}
	}

	@Override
	public String toString() {
		return "Index [openPrice=" + super.getOpenPrice() + ", closePrice=" + super.getClosePrice() + ", highestPrice="
				+ super.getHighestPrice() + ", lowestPrice=" + super.getLowestPrice() + ", ticker=" + super.getTicker()
				+ "]";
	}

}
