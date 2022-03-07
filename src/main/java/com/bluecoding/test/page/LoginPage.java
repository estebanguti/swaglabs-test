package com.bluecoding.test.page;

import com.bluecoding.test.model.Login;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userNameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id="login-button")
    private WebElement loginButton;
    @FindBy(css="[data-test='error']")
    private WebElement error;

    public void goTo(String url) {
        driver.get(url);
    }

    public void login(Login login) {
        userNameInput.sendKeys(login.getUsername());
        passwordInput.sendKeys(login.getPassword());
        loginButton.click();
    }

    public String getErrorContent() {
        wait.until((d) -> error.isDisplayed());
        return error.getText();
    }

    @Override
    public boolean isLoaded() {
        return wait.until((d) -> userNameInput.isDisplayed());
    }

}
