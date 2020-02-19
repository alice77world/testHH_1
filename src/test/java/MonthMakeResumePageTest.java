import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class MonthMakeResumePageTest {
    private static MakeResumePage makeresumepage;
    public WebDriver driver;

    @BeforeClass
    public static void runBeforeClass() { //действия перед всеми тестами
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://ufa.hh.ru/");
        GeneralPage generalpage = new GeneralPage(driver);
        LoginPage loginPage = generalpage.clickEnterButton();
        loginPage.typeUsername("arapovaalica@yandex.ru");
        loginPage.typePassword("2251764");
        HomePage homepage = loginPage.submitLogin();
        makeresumepage = homepage.clickButtonCreateResume();
    }

    @Before
    public void runBeforeEveryTest() {
        makeresumepage.clearFieldName();
        makeresumepage.clearFieldSurname();
        makeresumepage.clearFieldTelephone();
        makeresumepage.clearFieldCity();
        makeresumepage.clearFieldDay();
        makeresumepage.clearSelectMonth();
        makeresumepage.clearFieldYear();
    }

    /*@AfterClass
    public static void runAfterClass() {
        makeresumepage.closeMakeResumePage();
    }*/

    @Test
    public void withoutMonthError() {
        makeresumepage.typeDay("12"); //нужно заполнить месяц и год
        makeresumepage.selectMonth("марта");
        makeresumepage.typeYear("1997");
        makeresumepage.typeName("Иван");
        boolean actual = makeresumepage.isSearchErrorDate();
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    public void withMonthError() {
        makeresumepage.typeDay("12"); //нужно заполнить месяц и год
        makeresumepage.selectMonth("");
        makeresumepage.typeYear("1997");
        makeresumepage.typeName("Иван");
        boolean actual = makeresumepage.isSearchErrorDate();
        boolean expected = true;
        assertEquals(expected,actual);
    }

}