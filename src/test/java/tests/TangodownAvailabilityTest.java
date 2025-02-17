package tests;

import model.StockPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TangodownAvailabilityTest extends BaseTest{
    @Test
    public void testVerifyAvailability() {
        String stockMessage = new StockPage(getDriver())
                .selectBlackExtensionFromList()
                .verifyOutOfStockNessage();
        Assert.assertEquals(stockMessage, "Currently Out of Stock");
    }
}
