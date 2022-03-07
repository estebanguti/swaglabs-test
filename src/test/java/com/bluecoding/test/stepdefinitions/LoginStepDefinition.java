package com.bluecoding.test.stepdefinitions;

import com.bluecoding.test.datamanager.LoginDataManager;
import com.bluecoding.test.model.Login;
import com.bluecoding.test.page.InventoryPage;
import com.bluecoding.test.page.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginStepDefinition {

    @Autowired
    private WebDriver driver;
    @Autowired
    private LoginDataManager loginDataManager;
    @Autowired
    private LoginPage loginPage;
    @Autowired
    private InventoryPage inventoryPage;
    @Value("${testdata.login_users}")
    private String usersFile;
    @Value("${base.url}")
    private String url;
    private List<Login> loginList;

    @Before
    public void setUp() {
        loginPage.goTo(url);
    }

    @Given("I have multiple users")
    public void givenAllTheUsers() throws IOException {
        loginList = loginDataManager.convertJsonToLoginDtos(usersFile);
    }

    @When("I set the next credentials for user {string}")
    public void iSetTheNextCredentials(String userName) {
        Login login = loginList.stream().filter(login1 -> userName.equals(login1.getUsername()))
                .findFirst().orElse(null);
        loginPage.login(login);
    }

    @Then("The user should be logged")
    public void theUserShouldBeLogged() {
        assertThat(inventoryPage.isLoaded()).isTrue();
    }

    @Then("There should be an error displayed")
    public void thereShouldBeAnErrorDisplayed() {
        assertThat(loginPage.getErrorContent()).contains("Sorry, this user has been locked out.");
    }

}
