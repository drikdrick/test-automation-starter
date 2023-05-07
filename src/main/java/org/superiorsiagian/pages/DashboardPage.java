package org.superiorsiagian.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver newDriver) {
        this.driver = newDriver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//a[@class='button secondary radius']")
    private WebElement logoutBtn;

    public boolean isLogoutBtnVisible() {
        return logoutBtn.isDisplayed();
    }
}
