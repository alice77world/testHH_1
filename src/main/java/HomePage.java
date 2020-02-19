import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By createResumeLocator = By.linkText("Создать резюме");

    @Step
    public MakeResumePage clickButtonCreateResume() {
        driver.findElement(createResumeLocator).click();
        return new MakeResumePage(driver);
    }

}
