import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class NameMakeResumePageTest {
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
    @Description(value="Тест проверяет наличие ошибки при вводе чисел и букв")
    @Epic(value="Имя")
    public void numberNameError() {
        makeresumepage.typeName("1Test");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    @Description(value="Тест проверяет наличие ошибки если Имя заканчивается на дефис")
    @Epic(value="Имя")
    public void defisLastNameError() {
        makeresumepage.typeName("Test-");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    @Description(value="Тест проверяет наличие ошибки если Имя начинается на дефис")
    @Epic(value="Имя")
    public void defisFirstNameError() {
        makeresumepage.typeName("-Test");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    @Description(value="Тест проверяет отсутствие ошибки если дефис находится среди букв имени")
    @Epic(value="Имя")
    public void defisMiddleName() {
        makeresumepage.typeName("Test-Test");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    @Description(value="Тест проверяет наличие ошибки при вводе пробела")
    @Epic(value="Имя")
    public void spaceNameError() {
        makeresumepage.typeName(" ");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorEmptyField();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    @Description(value="Тест проверяет наличие ошибки при вводе Enter")
    @Epic(value="Имя")
    public void enterNameError() {
        makeresumepage.typeName("\n");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorEmptyField();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    @Description(value="Тест проверяет отсутствие ошибки при вводе корректных данных")
    @Epic(value="Имя")
    public void withoutNameError() {
        makeresumepage.typeName("Test Test");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = false;
        assertEquals(expected,actual);
    }

}