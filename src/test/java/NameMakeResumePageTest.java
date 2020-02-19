import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class NameMakeResumePageTest {
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
    public void numberNameError() {
        makeresumepage.typeName("1Test");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void defisLastNameError() {
        makeresumepage.typeName("Test-");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void defisFirstNameError() {
        makeresumepage.typeName("-Test");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void defisMiddleName() {
        makeresumepage.typeName("Test-Test");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    public void spaceNameError() {
        makeresumepage.typeName(" ");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorEmptyField();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void enterNameError() {
        makeresumepage.typeName("\n");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorEmptyField();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void withoutNameError() {
        makeresumepage.typeName("Test Test");
        makeresumepage.typeSurname("Иванов");
        boolean actual = makeresumepage.isSearchErrorName();
        boolean expected = false;
        assertEquals(expected,actual);
    }

}