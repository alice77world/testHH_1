import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class FieldTelephoneMakeResumePageTest {

    @Test
    public void LettersTelephoneError() {
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
        makeresumepage.typeTelephone("Test");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
        driver.quit();
    }

    @Test
    public void LettersAndNumbersTelephoneError() {
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
        makeresumepage.typeTelephone("Test12");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
        driver.quit();
    }

    @Test
    public void TwoNumbersTelephoneError() {
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
        makeresumepage.typeTelephone("12");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
        driver.quit();
    }

    @Test
    public void ThreeNumbersTelephoneError() {
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
        makeresumepage.typeTelephone("+712");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
        driver.quit();
    }

    @Test
    public void WithoutTelephoneError() {
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
        makeresumepage.typeTelephone("+12345678901");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = false;
        assertEquals(expected,actual);
        driver.quit();
    }

    @Test
    public void WrongNumbersTelephoneError() {
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
        makeresumepage.typeTelephone("+123456789012");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
        driver.quit();
    }

    @Test
    public void TomuchNumbersTelephoneError() {
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
        makeresumepage.typeTelephone("+1234567890123456789");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
        driver.quit();
    }

    @Test
    public void ToMuchNumbersTelephoneError() {
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
        makeresumepage.typeTelephone("+1234567890123456789");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
        driver.quit();
    }



}