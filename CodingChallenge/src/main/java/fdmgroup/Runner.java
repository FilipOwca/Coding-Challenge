package fdmgroup;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * The Runner class is responsible for executing the program and generating 
 * daily aggregates and indexes based on market data.
 * @author Filip
 *
 */
public class Runner {

	/**
	 * The main method of the program.
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {

	    // Path to the market data file
		File data = new File("src/main/resources/test-market.csv");
		
		String[] tickerNames = { "ABC", "MEGA", "NGL", "TRX" };

		try {
			// Read the market data from the file
			List<Trade> trades = MarketLogReader.readMarketData(data);

			// Calculate daily aggregates
			DailyAggregateCalculator calculator = new DailyAggregateCalculator(tickerNames);
			calculator.calculate(trades);
			Map<LocalDate, Map<String, DailyAggregate>> dailyAggregates = calculator.getDailyAggregates();

			// Calculate daily indexes
			Map<LocalDate, Index> dailyIndexes = calculator.getDailyIndexes();

			// Print the results to the console
			Result result = new Result();
			result.printToConsole(dailyAggregates, dailyIndexes);

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

}
