package com.bluecoding.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class BasePage {

    @Autowired
    protected WebDriver driver;
    @Autowired
    protected WebDriverWait wait;

    @PostConstruct
    public void initElements() {
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isLoaded();

}
