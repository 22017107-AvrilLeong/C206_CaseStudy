import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class RateMainTest {

    private ArrayList<Rate> rateList;

    @Before
    public void setUp() {
        rateList = new ArrayList<>();
        rateList.add(new Rate("Singapore Dollar", "SGD", 3.1));
        rateList.add(new Rate("Australian Dollar", "AUS", 2.1));
        rateList.add(new Rate("Ringgit", "RM", 2.1));
    }

    @Test
    public void testAddRate() {
        RateMain.addRate(rateList);
        assertEquals(4, rateList.size());

        Rate addedRate = rateList.get(3);
        assertEquals("US Dollar", addedRate.getCurrencyName());
        assertEquals("USD", addedRate.getUniqueCurrencyCode());
        assertEquals(1.0, addedRate.getExchangeRate(), 0.01);
    }

    @Test
    public void testDelRate() {
        RateMain.delRate(rateList, "SGD");
        assertEquals(2, rateList.size());

        boolean found = false;
        for (Rate rate : rateList) {
            if (rate.getUniqueCurrencyCode().equals("SGD")) {
                found = true;
                break;
            }
        }
        assertFalse(found);
    }

    @Test
    public void testViewRate() {
        // Assuming viewRate method prints to the console
        // Redirect system out to capture console output
        // You can use a testing library like System Rules for this purpose

        // Test the viewRate method
        // This test only checks if the method executes without errors
        RateMain.viewRate(rateList);

        // Restore system out after test
        // Again, use System Rules for this purpose
    }

    // Add more test cases for other rate management methods as needed
}

