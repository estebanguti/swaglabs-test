package com.bluecoding.test.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class InventoryPage extends BasePage {

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCar;
    @FindBy(id="inventory_container")
    private WebElement inventoryContainer;

    @Override
    public boolean isLoaded() {
        return wait.until((d) -> inventoryContainer.isDisplayed());
    }
}
