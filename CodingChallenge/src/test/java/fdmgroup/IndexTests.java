package fdmgroup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IndexTests {

	@Test
    public void testUpdate() {
        Index index = new Index("INDEX");

        // Update with ticker "ABC" and price 10.0
        index.update("ABC", 10.0);
        assertEquals(0.0, index.getOpenPrice(), 0.0001);
        assertEquals(0.0, index.getClosePrice(), 0.0001);
        assertEquals(0.0, index.getHighestPrice(), 0.0001);
        assertEquals(0.0, index.getLowestPrice(), 0.0001);

        // Update with ticker "MEGA" and price 20.0
        index.update("MEGA", 20.0);
        assertEquals(0.0, index.getOpenPrice(), 0.0001);
        assertEquals(0.0, index.getClosePrice(), 0.0001);
        assertEquals(0.0, index.getHighestPrice(), 0.0001);
        assertEquals(0.0, index.getLowestPrice(), 0.0001);

        // Update with ticker "NGL" and price 15.0
        index.update("NGL", 15.0);
        assertEquals(0.0, index.getOpenPrice(), 0.0001);
        assertEquals(0.0, index.getClosePrice(), 0.0001);
        assertEquals(0.0, index.getHighestPrice(), 0.0001);
        assertEquals(0.0, index.getLowestPrice(), 0.0001);

        // Update with ticker "TRX" and price 5.0
        index.update("TRX", 5.0);
        assertEquals(14.0, index.getOpenPrice(), 0.0001);
        assertEquals(14.0, index.getClosePrice(), 0.0001);
        assertEquals(14.0, index.getHighestPrice(), 0.0001);
        assertEquals(14.0, index.getLowestPrice(), 0.0001);
	}

}
