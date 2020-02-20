import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class MonthMakeResumePageTest {
    private static MakeResumePage makeresumepage;

    @BeforeClass
    public static void runBeforeClass() { //действия перед всеми тестами
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://ufa.hh.ru/");
        GeneralPage generalpage = new GeneralPage(driver);
        LoginPage loginPage = generalpage.clickEnterButton();
        HomePage homepage = loginPage.loginAs("arapovaalica@yandex.ru","2251764");
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

    @Test
    @Description(value="Тест проверяет отсутствие ошибки при вводе корректных данных(дня, месяца,года)")
    @Epic(value="Месяц рождения")
    public void withoutMonthError() {
        makeresumepage.typeDay("12"); //нужно заполнить месяц и год
        makeresumepage.selectMonth("февраля");
        makeresumepage.typeYear("1997");
        makeresumepage.typeName("Иван");
        boolean actual = makeresumepage.isSearchErrorDate();
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    @Description(value="Тест проверяет наличие ошибки, если месяц рождения не выбран")
    @Epic(value="Месяц рождения")
    public void withMonthError() {
        makeresumepage.typeDay("12"); //нужно заполнить месяц и год
        makeresumepage.typeYear("1997");
        makeresumepage.typeName("Иван");
        boolean actual = makeresumepage.isSearchErrorDate();
        boolean expected = true;
        assertEquals(expected,actual);
    }

}