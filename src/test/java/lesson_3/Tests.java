package lesson_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;


public class Tests extends BaseTest {

    @Test
    public void additionalTest() throws InterruptedException {
        //  1. Открыть страницу myfin.by
        driver.get("https://myfin.by/");

        //  2.Навестись на меню Курсы валют
        Thread.sleep(2000);
        WebElement exchangeRates = driver.findElement(By.linkText("Курсы валют"));
        Actions exchangeRatesPerform = new Actions(driver);
        exchangeRatesPerform.moveToElement(exchangeRates).perform();

        /// 3.Перейти в меню Курс bitcoin
        Thread.sleep(2000);
        WebElement ratesBitcoin = driver.findElement(By.linkText("Курс Bitcoin"));
        ratesBitcoin.click();

        //  4.Проверить что открылась соответствующая страница
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        assertTrue(driver.getTitle().contains("Биткоин"));
    }

    @Test
    public void homewokTestOne() {
        String weightValue = "40";
        String heightValue = "158";
        String siUnitsValue = "16.02";
        String usUnitsValue = "16.29";
        String ukUnitsValue = "101.73";
        String statusValue = "Your category is Underweight";

        //  1.Открыть сайт https://healthunify.com/bmicalculator/
        driver.get("https://healthunify.com/bmicalculator/");

        //  2.Ввести Weight 40 kg
        WebElement weight = driver.findElement(By.name("wg"));
        weight.sendKeys(weightValue);

        //  3.Ввести Height 158
        WebElement height = driver.findElement(By.name("ht"));
        height.sendKeys(heightValue);

        //  4.Нажать на кнопку ‘Calculate’
        WebElement calculate = driver.findElement(By.name("cc"));
        calculate.click();

        //  5.Проверить значение в поле 'SI Units’ 16.02
        WebElement siUnits = driver.findElement(By.name("si"));
        Assert.assertEquals(siUnits.getAttribute("value"), siUnitsValue);

        //  6.Проверить значение в поле 'US Units’ 16.29
        WebElement usUnits = driver.findElement(By.name("us"));
        Assert.assertEquals(usUnits.getAttribute("value"), usUnitsValue);

        //  7.Проверить значение в поле ’UK Units’ 101.73
        WebElement ukUnits = driver.findElement(By.name("uk"));
        ;
        Assert.assertEquals(ukUnits.getAttribute("value"), ukUnitsValue);

        //  8.Проверить статус "Your category is Underweight"
        WebElement status = driver.findElement(By.name("desc"));
        Assert.assertEquals(status.getAttribute("value"), statusValue);
    }

    @Test
    public void homewokTestTwo() {
        String weightValue = "70";
        String weightPound = "pounds";
        String heightFirstValue = "5";
        String heightSecondValue = "6";
        String siUnitsValue = "11.27";
        String usUnitsValue = "11.46";
        String ukUnitsValue = "71.58";
        String statusValue = "Your category is Normal";

        //  1.Открыть сайт https://healthunify.com/bmicalculator/
        driver.get("https://healthunify.com/bmicalculator/");

        //  2.Ввести Weight 70 pounds
        WebElement pounds = driver.findElement(By.name("opt1"));
        Select poundsValue = new Select(pounds);
        poundsValue.selectByVisibleText(weightPound);

        WebElement weight = driver.findElement(By.name("wg"));
        weight.clear();
        weight.sendKeys(weightValue);

        //  3.Ввести Height 5’ 6’’
        WebElement dropHeightFirst = driver.findElement(By.name("opt2"));
        Select heightFirst = new Select(dropHeightFirst);
        heightFirst.selectByValue(heightFirstValue);

        WebElement dropHeightSecond = driver.findElement(By.name("opt3"));
        Select heightSecond = new Select(dropHeightSecond);
        heightSecond.selectByValue(heightSecondValue);

        //  4.Нажать на кнопку ‘Calculate’
        WebElement calculate = driver.findElement(By.name("cc"));
        calculate.click();

        //  5.Проверить значение в поле 'SI Units’ 11.27
        WebElement siUnits = driver.findElement(By.name("si"));
        Assert.assertEquals(siUnits.getAttribute("value"), siUnitsValue);

        //  6.Проверить значение в поле 'US Units’  11.46
        WebElement usUnits = driver.findElement(By.name("us"));
        Assert.assertEquals(usUnits.getAttribute("value"), usUnitsValue);

        //  7.Проверить значение в поле ’UK Units’ 71.58
        WebElement ukUnits = driver.findElement(By.name("uk"));
        Assert.assertEquals(ukUnits.getAttribute("value"), ukUnitsValue);

        //  8.Проверить статус Your category is Normal
        WebElement status = driver.findElement(By.name("desc"));
        Assert.assertEquals(status.getAttribute("value"), statusValue);
    }
}
