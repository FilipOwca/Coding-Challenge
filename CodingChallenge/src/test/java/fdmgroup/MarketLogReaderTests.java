package fdmgroup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

class MarketLogReaderTests {
	
//	MarketLogReader marketLogReader;

	@Test
	void test_ReadMarketDataReads_CSV_FilesProperly() throws IOException {
		File file = new File("src/test/resources/testing-file.csv");
		
		List<Trade> trades = MarketLogReader.readMarketData(file); 
		
		assertNotNull(trades);
		assertEquals(3, trades.size());
		
		Trade trade1 = trades.get(0);
        assertEquals("2023-06-25", trade1.getDate().toString());
        assertEquals("AAPL", trade1.getTicker());
        assertEquals(150.0, trade1.getPrice());
        assertEquals(100, trade1.getTradeQuantity());
        
        Trade trade2 = trades.get(1);
        assertEquals("2023-06-25", trade2.getDate().toString());
        assertEquals("GOOGL", trade2.getTicker());
        assertEquals(1200.0, trade2.getPrice());
        assertEquals(50, trade2.getTradeQuantity());

        Trade trade3 = trades.get(2);
        assertEquals("2023-06-25", trade3.getDate().toString());
        assertEquals("FDM", trade3.getTicker());
        assertEquals(300.5, trade3.getPrice());
        assertEquals(200, trade3.getTradeQuantity());
	}
	
	@Test 
	void test_ReadMarketData_Throws_IOException(){
		File nonExistingFile = new File("src/main/resources/non-existing-file.csv");
		
		assertThrows(RuntimeException.class, () -> MarketLogReader.readMarketData(nonExistingFile));
	}

}
