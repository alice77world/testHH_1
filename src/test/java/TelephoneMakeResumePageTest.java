import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class TelephoneMakeResumePageTest {
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
    }

    /*@AfterClass
    public static void runAfterClass() {
        makeresumepage.closeMakeResumePage();
    }*/

    @Test
    public void letterTelephoneError() {
        makeresumepage.typeTelephone("Test");
        makeresumepage.typeName("Иван");
        boolean actual = makeresumepage.isSearchErrorTelephone();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void letterWithNumberTelephoneError() {
        makeresumepage.typeTelephone("Test12");
        makeresumepage.typeName("Иван");
        boolean actual = makeresumepage.isSearchErrorTelephone();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void ShortTelephoneError() {
        makeresumepage.typeTelephone("12");
        makeresumepage.typeName("Иван");
        boolean actual = makeresumepage.isSearchErrorTelephone();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void LessTelephoneError() {
        makeresumepage.typeTelephone("712");
        makeresumepage.typeName("Иван");
        boolean actual = makeresumepage.isSearchErrorTelephone();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void withoutTelephoneError() {
        makeresumepage.typeTelephone("9345678901");
        makeresumepage.typeName("Иван");
        boolean actual = makeresumepage.isSearchErrorTelephone();
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    public void longTelephoneError() {
        makeresumepage.typeTelephone("23456789012");
        makeresumepage.typeName("Иван");
        boolean actual = makeresumepage.isSearchErrorTelephone();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void tooLongTelephoneError() {
        makeresumepage.typeTelephone("1234567890123456789");
        makeresumepage.typeName("Иван");
        boolean actual = makeresumepage.isSearchErrorTelephone();
        boolean expected = true;
        assertEquals(expected,actual);
    }

}