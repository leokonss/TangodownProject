package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Utils;

import java.util.List;

public class StockPage extends BasePage {
    @FindBy(xpath = "//select[@class='form-select form-select--small']")
    private WebElement stockDropdownList;

    @FindBy(xpath = "//select[@class='form-select form-select--small']/option")
    private List<WebElement> stockOtionsList;

    @FindBy(xpath = "//dt[@class='productView-info-name sku-label']")
    private WebElement sku;

    public StockPage(WebDriver driver) {
        super(driver);
    }

    public StockPage selectBlackExtensionFromList() {
        stockDropdownList.click();
        List<WebElement> options = getListOfStockOptions();
        for (WebElement option : options) {
            String optionName = option.getText();
            if (optionName.contains("Black (Currently Out of Stock)")) {
                Utils.log("Black extension is found.");
                option.click();
                sku.click();
                break;
            }
        }
        return this;
    }

    public String verifyOutOfStockNessage() {
        return getWait5().until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[@class='alertBox productAttributes-message']/p"))).getText();
    }

    public List<WebElement> getListOfStockOptions() {
        return stockOtionsList;
    }
}
