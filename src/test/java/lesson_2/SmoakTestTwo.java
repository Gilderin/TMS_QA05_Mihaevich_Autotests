package lesson_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SmoakTestTwo {

    @Test
    public void testOne() {
        //  1.Открыть сайт https://www.3crkp.by/информация/полезно-знать/медицинские-калькуляторы/расчет-скф
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.3crkp.by/информация/полезно-знать/медицинские-калькуляторы/расчет-скф");
        //  2.Выбрать женский пол из выпадающего списка
        //WebElement sex = driver.findElement(By.name("sex"));
        //Select woman = new Select(sex);
        //woman.selectByIndex(1);
        //  3.Ввести Креатенин = 80
        WebElement createnin = driver.findElement(By.id("oCr"));
        createnin.sendKeys("80");
        //  4.Ввести Возраст = 38 годам
        WebElement age = driver.findElement(By.id("oAge"));
        age.sendKeys("38");
        //  5.Ввести Вес = 55 кг
        WebElement weight = driver.findElement(By.id("oWeight"));
        weight.sendKeys("55");
        //  6.Ввести Рост = 163 см
        WebElement height = driver.findElement(By.id("oHeight"));
        height.sendKeys("163");
        //  7.Нажать на кнопку ‘Рассчитать’
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();
        //  8.Проверить результаты: ‘MDRD: 74 (мл/мин/1,73кв.м)’
        WebElement mdrd = driver.findElement(By.id("oHeight"));
        //  9.Проверить результаты: ‘ХБП: 2 стадия (при наличии почечного повреждения)’
        WebElement xbp = driver.findElement(By.id("oHeight"));
        //  10.Проверить результаты: ‘Cockroft-Gault: 70 (мл/мин)’
        WebElement cockroftGault = driver.findElement(By.id("oHeight"));
        //  11.Проверить результаты: ‘Поверхность тела:1.58 (кв.м)’
        WebElement sizeBody = driver.findElement(By.id("oHeight"));
        //  12.Закрыть окно браузера
        driver.quit();


        // 5. Проверить, что значение в поле ‘ИМТ’ равно 17.32
        WebElement IMT = driver.findElement(By.name("result"));
        String imtText = IMT.getAttribute("value");
        if (!imtText.equals("17.32")) {
            System.out.println("IMT не соответствует. Равно = " + imtText);
        }
        // 6. Проверить, что статус равен ’Пониженный вес’
        WebElement status = driver.findElement(By.id("resline"));
        String statusText = status.getText();
        if (!statusText.equals("Пониженный вес")) {
            System.out.println("Status not correct. Status = " + statusText);
        } else {
            System.out.println("Status is correct");
        }
        // 7. Закрыть окно браузера

    }
}
