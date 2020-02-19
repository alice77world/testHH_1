import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By usernameLocator = By.xpath("//input[@name='username']");
    By passwordLocator = By.xpath("//input[@name='password']");
    By loginButtonLocator = By.xpath("//input[@type='submit']");

    @Step
    public LoginPage typeUsername(String username) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    @Step
    public LoginPage typePassword(String password) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    @Step
    public HomePage submitLogin() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(loginButtonLocator).submit();
        return new HomePage(driver);
    }

    @Step
    public HomePage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}
