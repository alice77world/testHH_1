import io.qameta.allure.Step;
import org.apache.bcel.generic.Select;
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
    By dayLocator = By.xpath("//input[@name='birthday[0].date']");
    By monthLocator = By.xpath("//select[@name='birthday[0].date']");

    By errorNameLocator = By.xpath("//div[.='Только буквы и дефис']");
    By errorTelephoneLocator = By.xpath("//div[.='Номер указан некорректно']");
    By errorEmptyFieldLocator = By.xpath("//div[.='Обязательное поле']");
    By errorDayLocator = By.xpath("//div[.='Некорректная дата']");


    @Step
    public MakeResumePage typeName(String name) {
        driver.findElement(nameLocator).sendKeys(name);
        return this;
    }

    @Step
    public MakeResumePage typeSurname(String surname) {
        driver.findElement(surnameLocator).sendKeys(surname);
        return this;
    }

    @Step
    public MakeResumePage typeTelephone(String telephone) {
        driver.findElement(telephoneLocator).sendKeys(telephone);
        return this;
    }

    @Step
    public MakeResumePage typeCity(String city) {
        driver.findElement(cityLocator).sendKeys(city);
        return this;
    }

    @Step
    public MakeResumePage typeDay(String name) {
        driver.findElement(dayLocator).sendKeys(name);
        return this;
    }

    @Step
    public MakeResumePage selectMonth(String month) {
        driver.findElement(monthLocator).sendKeys(month);
        return this;
    }

    @Step
    public MakeResumePage clearFieldName() {
        driver.findElement(nameLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(nameLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END));
        driver.findElement(nameLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    @Step
    public MakeResumePage clearFieldSurname() {
        driver.findElement(surnameLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(surnameLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END,Keys.BACK_SPACE));
        driver.findElement(surnameLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    @Step
    public MakeResumePage clearFieldCity() {
        driver.findElement(cityLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(cityLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END,Keys.BACK_SPACE));
        driver.findElement(surnameLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    @Step
    public MakeResumePage clearFieldTelephone() {
        driver.findElement(telephoneLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(telephoneLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END,Keys.BACK_SPACE));
        driver.findElement(telephoneLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    @Step
    public boolean isSearchErrorName() {
        Boolean isPresent = driver.findElements(errorNameLocator).size() > 0;
        return isPresent;
    }

    @Step
    public boolean isSearchErrorEmptyField() {
        Boolean isPresent = driver.findElements(errorEmptyFieldLocator).size() > 0;
        return isPresent;
    }

    @Step
    public boolean isSearchErrorTelephone() {
        Boolean isPresent = driver.findElements(errorTelephoneLocator).size() > 0;
        return isPresent;
    }

    @Step
    public boolean isSearchErrorDay() {
        Boolean isPresent = driver.findElements(errorDayLocator).size() > 0;
        return isPresent;
    }

    @Step
    public boolean isSearchErrorMonth() {
        Boolean isPresent = driver.findElements(errorDayLocator).size() > 0;
        return isPresent;
    }

}
