import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class FieldNameMakeResumePageTest {

    @Test
    public void numberNameError() {
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
        makeresumepage.typeName("1Test");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
        driver.quit();
    }

    @Test
    public void defisLastNameError() {
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
        makeresumepage.typeName("Test-");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
        driver.quit();
    }

    @Test
    public void defisFirstNameError() {
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
        makeresumepage.typeName("-Test");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
        driver.quit();
    }

    @Test
    public void defisMiddleName() {
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
        makeresumepage.typeName("Test-Test");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = false;
        assertEquals(expected,actual);
        driver.quit();
    }

    @Test
    public void spaceNameError() {
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
        makeresumepage.typeName(" ");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorEmptyField();
        boolean expected = true;
        assertEquals(expected,actual);
        driver.quit();
    }

    @Test
    public void enterNameError() {
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
        makeresumepage.typeName("\n");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorEmptyField();
        boolean expected = true;
        assertEquals(expected,actual);
        driver.quit();
    }

    @Test
    public void withoutNameError() {
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
        makeresumepage.typeName("Test Test");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = false;
        assertEquals(expected,actual);
        driver.quit();
    }

}