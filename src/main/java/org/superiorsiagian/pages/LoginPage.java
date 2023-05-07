package org.superiorsiagian.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver newDriver) {
        this.driver = newDriver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//h2[normalize-space()='Login Page']")
    private WebElement loginTitle;

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement flashMessage;

    @FindBy(xpath = "//a[@class='close']")
    private WebElement closeFlashBtn;

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void typeUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void typePassword(String password) {
        passwordField.sendKeys(password);
    }

    public boolean isLoginTitleVisible() {
        return loginTitle.isDisplayed();
    }

    public String getFlashMessage() {
        return flashMessage.getText();
    }

    public boolean isFlashMessageCorrect(String field) {
        return this.getFlashMessage().contains(field);
    }

    public void closeFlashMessage() {
        closeFlashBtn.click();
    }
}
