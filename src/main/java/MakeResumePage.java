import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.security.Key;

import static org.openqa.selenium.Keys.*;

public class MakeResumePage {
    private final WebDriver driver;

    public MakeResumePage(WebDriver driver) {
        this.driver = driver;
    }

    By nameLocator = By.xpath("//input[@name='firstName[0].string']");
    By surnameLocator = By.xpath("//input[@name='lastName[0].string']");
    By telephoneLocator = By.xpath("//input[@name='phone[0].formatted']");
    By cityLocator = By.xpath("//input[@name='area[0].string']");
    By dayBirthLocator = By.xpath("//input[@placeholder='День']");
    By monthBirthLocator = By.xpath("//input[@placeholder='Месяц']");
    By yearBirthLocator = By.xpath("//input[@placeholder='Год']");
    By maleLocator = By.xpath("//input[@value='male']");
    By femaleLocator = By.xpath("//input[@value='female']");



    public MakeResumePage typeName(String name) {
        driver.findElement(nameLocator).sendKeys(name);
        return this;
    }

    public MakeResumePage typeSurname(String surname) {
        driver.findElement(surnameLocator).sendKeys(surname);
        return this;
    }

    public MakeResumePage typeTelephone(String telephone) {
        driver.findElement(telephoneLocator).sendKeys(telephone);
        return this;
    }

    public MakeResumePage typeCity(String city) {
        driver.findElement(cityLocator).sendKeys(city);
        return this;
    }

    public MakeResumePage clearFieldName() {
        driver.findElement(nameLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(nameLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END));
        driver.findElement(nameLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    public MakeResumePage clearFieldSurname() {
        driver.findElement(surnameLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(surnameLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END,Keys.BACK_SPACE));
        driver.findElement(surnameLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    public MakeResumePage clearFieldCity() {
        driver.findElement(cityLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(cityLocator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END,Keys.BACK_SPACE));
        driver.findElement(surnameLocator).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    public boolean searchErrorName() {
        boolean result = driver.findElement(By.linkText("Только буквы и дефис")).isDisplayed();
        return result;
    }

    public boolean searchErrorSurname() {
        boolean result = driver.findElement(By.linkText("Только буквы и дефис")).isDisplayed();
        return result;
    }

    public boolean searchErrorTelephone() { //что здесь делать?
        boolean result = driver.findElement(By.linkText("Номер указан некорректно")).isDisplayed();
        return result;
    }

    public boolean searchErrorCity() {
        boolean result = driver.findElement(By.linkText("Только буквы и дефис")).isDisplayed();
        return result;
    }

}
