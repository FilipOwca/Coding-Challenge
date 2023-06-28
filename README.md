# Coding-Challenge

To run the program start the main method from Runner.java class.

**Task Description:** Task is to calculate some daily aggregates for the provided market historical log (sample attached). Log is a list of all trades done in the market for a period of time, file format: date+time;company ticker;price;number of securities traded

Market also publishes own index (please print as ticker INDEX), which is a weighted sum of ticker prices at an instant, please use the follow weights  to calculate INDEX: ABC: 0.1 MEGA: 0.3 NGL: 0.4 TRX: 0.2

For every date in a log and for every traded ticker, please print daily values for open price (price of the first deal in the day), close price (price of the last deal in the day), highest price, lowest price, daily traded volume (sum of price*number_traded)   Please also print daily values for INDEX

Some tickers may have no trades in a day, that should be mentioned in daily aggregates as e.g. ‘N/A', for index calculations please use the last price known (can be from any previous dates) As index consists of all market tickers, calculation is possible only after all market prices are available on the first traded day

**Verification.xlsx :** Excel spreadsheet containg verification of the results
