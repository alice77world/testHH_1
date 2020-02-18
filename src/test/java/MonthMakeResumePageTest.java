import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class MonthMakeResumePageTest {

    @Test
    public void TooBigDayError() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Айгуль\\IdeaProjects\\testHH\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ufa.hh.ru/");
        GeneralPage generalpage = new GeneralPage(driver);
        LoginPage loginPage = generalpage.clickEnterButton();
        loginPage.typeUsername("arapovaalica@yandex.ru");
        loginPage.typePassword("2251764");
        HomePage homepage = loginPage.submitLogin();
        MakeResumePage makeresumepage = homepage.clickButtonCreateResume();
        makeresumepage.clearFieldName(); //очищаем поля
        makeresumepage.clearFieldSurname();
        makeresumepage.clearFieldCity();
        makeresumepage.clearFieldTelephone();
        makeresumepage.selectMonth("января");
        boolean actual = makeresumepage.isSearchErrorDay();
        boolean expected = true;
        assertEquals(expected,actual);
        driver.quit();
    }

}