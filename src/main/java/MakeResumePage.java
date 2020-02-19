import io.qameta.allure.Step;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

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
    By femLocator = By.xpath("//button[.='Женский']");
    By maleLocator = By.xpath("//button[.='Мужской']");
    By expHaveLocator = By.xpath("//span[.='Есть опыт работы']");
    By expHaventLocator = By.xpath("//span[.='Нет опыта работы']");


    By errorNameLocator = By.xpath("//div[.='Только буквы и дефис']");
    By errorTelephoneLocator = By.xpath("//div[.='Номер указан некорректно']");
    By errorEmptyFieldLocator = By.xpath("//div[.='Обязательное поле']");
    By errorDateLocator = By.xpath("//div[.='Некорректная дата']");
    By earlyDateLocator = By.xpath("//div[.='Слишком рано']");
    By youngYearLocator = By.xpath("//div[.='Вы слишком молоды']");


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
    public MakeResumePage selectMonth(String value) {
        driver.findElement(monthLocator).click();
        driver.findElement(By.xpath("//select/option[text()=value]")).click();
        return this;
    }

    @Step
    public MakeResumePage typeYear(String name) {
        driver.findElement(yearLocator).sendKeys(name);
        return this;
    }

/*
    @Step
    public MakeResumePage selectMonth(String month) {
        driver.findElement(monthLocator).sendKeys(month);
        return this;
    }*/

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
        driver.findElement(cityLocator).sendKeys(Keys.BACK_SPACE);
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
    public MakeResumePage clearFieldDay() { //переделать
        driver.findElement(dayLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(dayLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END,Keys.BACK_SPACE));
        driver.findElement(dayLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    @Step
    public MakeResumePage clearFieldYear() { //переделать
        driver.findElement(yearLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(yearLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END,Keys.BACK_SPACE));
        driver.findElement(yearLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    @Step
    public MakeResumePage clearSelectMonth() { //переделать
        driver.findElement(monthLocator).click();
        driver.findElement(By.xpath("//select/option[text()='']")).click();
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
    public boolean isSearchErrorDate() {
        Boolean isPresent = driver.findElements(errorDateLocator).size() > 0;
        return isPresent;
    }

    @Step
    public boolean isSearchErrorEarlyDate() {
        Boolean isPresent = driver.findElements(earlyDateLocator).size() > 0;
        return isPresent;
    }

    @Step
    public boolean isSearchErrorYoungYear() {
        Boolean isPresent = driver.findElements(youngYearLocator).size() > 0;
        return isPresent;
    }

    @Step
    public MakeResumePage closeMakeResumePage() {
        driver.quit();
        return this;
    }
}
