import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class CityMakeResumePageTest {
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
    }

    @Test
    @Description(value="Тест проверяет отсутствие ошибки при вводе корректных данных")
    @Epic(value="Город")
    public void withoutCityError() {
        makeresumepage.typeCity("Омск"); //не получилось выбрать из списка
        makeresumepage.typeName("Иван");
        makeresumepage.typeSurname("Иванов");
        makeresumepage.typeTelephone("9345678901");
        boolean actual = makeresumepage.isSearchErrorEmptyField();
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    @Description(value="Тест проверяет наличие ошибки при вводе Enter")
    @Epic(value="Город")
    public void enterCityError() {
        makeresumepage.typeCity("\n");
        makeresumepage.typeName("Иван");
        makeresumepage.typeSurname("Иванов");
        makeresumepage.typeTelephone("9345678901");
        boolean actual = makeresumepage.isSearchErrorEmptyField();
        boolean expected = true;
        assertEquals(expected,actual);
    }

}