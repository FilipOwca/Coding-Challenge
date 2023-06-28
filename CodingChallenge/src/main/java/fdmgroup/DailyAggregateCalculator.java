package fdmgroup;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The DailyAggregateCalculator class is responsible for calculating daily
 * aggregates and indexes based on a list of trades.
 * 
 * This class maintains a map of daily aggregates and a map of daily indexes.
 * The daily aggregates map stores daily aggregates for each date and ticker
 * symbol, while the daily indexes map stores index values for each date.
 * 
 * @author Filip
 *
 */
public class DailyAggregateCalculator {

	private Map<LocalDate, Map<String, DailyAggregate>> dailyAggregates = new HashMap<>();
	private Map<LocalDate, Index> dailyIndexes = new HashMap<>();
	private String[] tickerNames;

	/**
	 * Constructs a DailyAggregateCalculator object with the provided ticker names.
	 * 
	 * @param tickerNames an array of ticker names
	 */
	public DailyAggregateCalculator(String[] tickerNames) {
		this.tickerNames = tickerNames;
	}

	/**
	 * Calculates the daily aggregates and indexes based on a list of trades.
	 * 
	 * @param trades the list of trades
	 */
	public void calculate(List<Trade> trades) {
		for (Trade trade : trades) {
			calculateDailyAggregates(trade);
			calculateDailyIndexes(trade);
		}
	}

	/**
	 * Calculates the daily aggregates for a given trade.
	 * 
	 * @param trade the trade
	 */
	private void calculateDailyAggregates(Trade trade) {

		LocalDate date = trade.getDate();
		String ticker = trade.getTicker();

//		Get the map of daily aggregates for the respective day. Create a new one if doesn't exist.
		Map<String, DailyAggregate> aggregatesByTicker = dailyAggregates.get(date);
		if (aggregatesByTicker == null) {
			aggregatesByTicker = createNewEmptyDailyAggregates();
			dailyAggregates.put(date, aggregatesByTicker);
		}

//		Get the daily aggregate for a respective ticker. Create a new one if doesn't exist.
		DailyAggregate aggregate = aggregatesByTicker.get(ticker);

		updateDailyAggregatePrices(aggregate, trade);

	}

	/**
	 * Creates a new map of empty DailyAggregate objects for all ticker names.
	 * 
	 * @return the map of empty DailyAggregate objects
	 */
	private Map<String, DailyAggregate> createNewEmptyDailyAggregates() {
		Map<String, DailyAggregate> tickers = new HashMap<>();
		for (String tickerName : tickerNames) {
			tickers.put(tickerName, new DailyAggregate(tickerName));
		}
		return tickers;
	}

	/**
	 * Updates the prices in the daily aggregate based on a trade.
	 * 
	 * @param aggregate the daily aggregate
	 * @param trade     the trade
	 */
	private void updateDailyAggregatePrices(DailyAggregate aggregate, Trade trade) {

		if (aggregate.getOpenPrice() == 0) {
			aggregate.setOpenPrice(trade.getPrice());
		}

		aggregate.setClosePrice(trade.getPrice());

		if (aggregate.getHighestPrice() == 0 || trade.getPrice() > aggregate.getHighestPrice()) {
			aggregate.setHighestPrice(trade.getPrice());
		}

		if (aggregate.getLowestPrice() == 0 || trade.getPrice() < aggregate.getLowestPrice()) {
			aggregate.setLowestPrice(trade.getPrice());
		}

		aggregate.setDailyVolume(aggregate.getDailyVolume() + (trade.getPrice() * trade.getTradeQuantity()));
	}

	/**
	 * Calculates the daily indexes for a given trade.
	 * 
	 * @param trade the trade
	 */
	private void calculateDailyIndexes(Trade trade) {

		LocalDate date = trade.getDate();
		String ticker = trade.getTicker();
		double price = trade.getPrice();

//		Get the index object for a respective day. Create one if doesn't exist.
		Index currentIndex = dailyIndexes.get(date);
		if (currentIndex == null) {
			currentIndex = new Index("INDEX");
			dailyIndexes.put(date, currentIndex);
		}
//		Update index values.
		currentIndex.update(ticker, price);

	}

	public Map<LocalDate, Map<String, DailyAggregate>> getDailyAggregates() {
		return dailyAggregates;
	}

	public Map<LocalDate, Index> getDailyIndexes() {
		return dailyIndexes;
	}

}
