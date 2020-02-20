import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeneralPage {
    private final WebDriver driver;

    public GeneralPage(WebDriver driver) {
        this.driver = driver;
    }

    By linkEnterLocator = By.linkText("Войти");

    @Step("Нажатие на кнопку Войти")
    public LoginPage clickEnterButton(){
        driver.findElement(linkEnterLocator).click();
        return new LoginPage(driver);
    }
}
