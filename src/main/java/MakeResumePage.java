import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MakeResumePage {
    private final WebDriver driver;

    public MakeResumePage(WebDriver driver) {
        this.driver = driver;
    }

    By nameLocator = By.xpath("//input[@name='firstName[0].string']");
    By surnameLocator = By.xpath("//input[@name='lastName[0].string']");
    By telephoneLocator = By.xpath("//input[@name='phone[0].formatted']");
    By cityLocator = By.xpath("//input[@name='area[0].string']");
    By dayLocator = By.xpath("//input[@placeholder='День']");
    By monthLocator = By.xpath("//select[@name='birthday[0].date']");
    By yearLocator = By.xpath("//input[@placeholder='Год']");

    By errorNameLocator = By.xpath("//div[.='Только буквы и дефис']");
    By errorTelephoneLocator = By.xpath("//div[.='Номер указан некорректно']");
    By errorEmptyFieldLocator = By.xpath("//div[.='Обязательное поле']");
    By errorDateLocator = By.xpath("//div[.='Некорректная дата']");
    By earlyDateLocator = By.xpath("//div[.='Слишком рано']");
    By youngYearLocator = By.xpath("//div[.='Вы слишком молоды']");

    @Step("Ввод имени")
    public MakeResumePage typeName(String name) {
        driver.findElement(nameLocator).sendKeys(name);
        return this;
    }

    @Step("Ввод фамилии")
    public MakeResumePage typeSurname(String surname) {
        driver.findElement(surnameLocator).sendKeys(surname);
        return this;
    }

    @Step("Ввод номера телефона")
    public MakeResumePage typeTelephone(String telephone) {
        driver.findElement(telephoneLocator).sendKeys(telephone);
        return this;
    }

    @Step("Ввод города проживания")
    public MakeResumePage typeCity(String city) {
        driver.findElement(cityLocator).sendKeys(city);
        return this;
    }

    @Step("Ввод дня рождения")
    public MakeResumePage typeDay(String name) {
        driver.findElement(dayLocator).sendKeys(name);
        return this;
    }

    @Step("Выбор месяца рождения из выпадающего списка")
    public MakeResumePage selectMonth(String value) {
        try {
            Thread.sleep(5000);
            Select dropdown = new Select(driver.findElement(monthLocator));
            dropdown.selectByIndex(2);
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return this;
    }

    @Step("Ввод года рождения")
    public MakeResumePage typeYear(String name) {
        driver.findElement(yearLocator).sendKeys(name);
        return this;
    }

    @Step("Очистить поле Имя")
    public MakeResumePage clearFieldName() {
        driver.findElement(nameLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(nameLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END));
        driver.findElement(nameLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    @Step("Очистить поле Фамилия")
    public MakeResumePage clearFieldSurname() {
        driver.findElement(surnameLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(surnameLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END,Keys.BACK_SPACE));
        driver.findElement(surnameLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    @Step("Очистить поле Город")
    public MakeResumePage clearFieldCity() {
        driver.findElement(cityLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(cityLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END,Keys.BACK_SPACE));
        driver.findElement(cityLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    @Step("Очистить поле Номер телефона")
    public MakeResumePage clearFieldTelephone() {
        driver.findElement(telephoneLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(telephoneLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END,Keys.BACK_SPACE));
        driver.findElement(telephoneLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    @Step("Очистить поле День Рождения")
    public MakeResumePage clearFieldDay() {
        driver.findElement(dayLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(dayLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END,Keys.BACK_SPACE));
        driver.findElement(dayLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    @Step("Очистить поле Год рождения")
    public MakeResumePage clearFieldYear() {
        driver.findElement(yearLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(yearLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END,Keys.BACK_SPACE));
        driver.findElement(yearLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    @Step("Очистить Месяц Рождения из выпадающего списка")
    public MakeResumePage clearSelectMonth() {
        try {
            Thread.sleep(5000);
            Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='birthday[0].date']")));
            dropdown.selectByIndex(0);
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return this;
    }

    @Step("Поиск ошибки в Имени")
    public boolean isSearchErrorName() {
        Boolean isPresent = driver.findElements(errorNameLocator).size() > 0;
        return isPresent;
    }

    @Step("Поиск ошибки Обязательное поле")
    public boolean isSearchErrorEmptyField() {
        Boolean isPresent = driver.findElements(errorEmptyFieldLocator).size() > 0;
        return isPresent;
    }

    @Step("Поиск ошибки в поле Номер Телефона")
    public boolean isSearchErrorTelephone() {
        Boolean isPresent = driver.findElements(errorTelephoneLocator).size() > 0;
        return isPresent;
    }

    @Step("Поиск ошибки Некорректная дата")
    public boolean isSearchErrorDate() {
        Boolean isPresent = driver.findElements(errorDateLocator).size() > 0;
        return isPresent;
    }

    @Step("Поиск ошибки Слишком рано")
    public boolean isSearchErrorEarlyDate() {
        Boolean isPresent = driver.findElements(earlyDateLocator).size() > 0;
        return isPresent;
    }

    @Step("Поиск ошибки Вы слишком молоды")
    public boolean isSearchErrorYoungYear() {
        Boolean isPresent = driver.findElements(youngYearLocator).size() > 0;
        return isPresent;
    }

}
