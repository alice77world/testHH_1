import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Айгуль\\IdeaProjects\\testHH\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://ufa.hh.ru/");

        GeneralPage generalpage = new GeneralPage(driver);
        LoginPage loginPage = generalpage.clickEnterButton();

        HomePage homepage = loginPage.loginAs("arapovaalica@yandex.ru","12341234");
        MakeResumePage makeresumepage = homepage.clickButtonCreateResume();

        makeresumepage.clearFieldName(); //очищаем поля
        makeresumepage.clearFieldSurname();
        makeresumepage.clearFieldCity();

        makeresumepage.typeName("1Test"); //это должны быть тесты
        makeresumepage.typeName("Test-");
        makeresumepage.typeName("-Test");
        makeresumepage.typeName("Test-Test");
        makeresumepage.typeName(" ");
        makeresumepage.typeName("\n");
        makeresumepage.typeName("\t");
        makeresumepage.typeName("Test Test");

    }
}
