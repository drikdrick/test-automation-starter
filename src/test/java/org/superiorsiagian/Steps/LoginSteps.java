package org.superiorsiagian.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.superiorsiagian.pages.DashboardPage;
import org.superiorsiagian.pages.LoginPage;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginSteps {
    WebDriver webDriver;
    LoginPage loginPage;

    DashboardPage dashboardPage;

    @Given("I open browser and navigate to {string}")
    public void iOpenBrowserAndNavigateTo(String url) {
        //TODO
        //Change the following driverpath according to your chrome driver location
        String driverPath = "C:\\Users\\fedrick.siagian\\DevLand\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        this.loginPage = new LoginPage(webDriver);
        this.dashboardPage = new DashboardPage(webDriver);


        webDriver.get(url);
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        this.webDriver.close();
        this.webDriver.quit();
    }

    @And("I enter {string} as password")
    public void iEnterAsPassword(String password) {
        this.loginPage.typePassword(password);
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        assertThat("I am not on login page", this.loginPage.isLoginTitleVisible());
    }

    @When("I enter {string} as username")
    public void iEnterAsUsername(String username) {
        this.loginPage.typeUsername(username);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        this.loginPage.clickLoginBtn();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        assertThat("I am not logged in", this.dashboardPage.isLogoutBtnVisible());
    }

    @Then("I should see error message about {string}")
    public void iShouldSeeErrorMessageAbout(String field) {
        assertThat("Error message is not correct", this.loginPage.isFlashMessageCorrect(field));
    }

    @And("I close error message")
    public void iCloseErrorMessage() {
        this.loginPage.closeFlashMessage();
    }
}
