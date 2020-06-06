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
        WebElement sex = driver.findElement(By.id("oSex"));
        Select woman = new Select(sex);
        woman.selectByVisibleText("женский");
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
        WebElement mdrd = driver.findElement(By.id("txtMDRD"));
        String mdrdValue = mdrd.getText();
        if (!mdrdValue.equals("MDRD: 74 (мл/мин/1,73кв.м)")) {
            System.out.println("Value of MDRD not correct. MDRD = " + mdrdValue);
        } else {
            System.out.println("Value of MDRD  correct.");
        }
        //  9.Проверить результаты: ‘ХБП: 2 стадия (при наличии почечного повреждения)’
        WebElement xbp = driver.findElement(By.id("txtMDRD1"));
        String xbpValue = xbp.getText();
        if (!xbpValue.equals("ХБП: 2 стадия (при наличии почечного повреждения)")) {
            System.out.println("Value of ХБП not correct. ХБП = " + xbpValue);
        } else {
            System.out.println("Value of ХБП  correct.");
        }
        //  10.Проверить результаты: ‘Cockroft-Gault: 70 (мл/мин)’
        WebElement cockroftGault = driver.findElement(By.id("txtCG"));
        String cockroftGaultValue = cockroftGault.getText();
        if (!cockroftGaultValue.equals("Cockroft-Gault: 70 (мл/мин)")) {
            System.out.println("Value of Cockroft-Gault not correct. Cockroft-Gault = " + cockroftGaultValue);
        } else {
            System.out.println("Value of Cockroft-Gault  correct.");
        }
        //  11.Проверить результаты: ‘Поверхность тела:1.58 (кв.м)’
        WebElement sizeBody = driver.findElement(By.id("txtBSA"));
        String sizeBodyValue = sizeBody.getText();
        if (!sizeBodyValue.equals("Поверхность тела:1.58 (кв.м)")) {
            System.out.println("Value of Поверхность тела not correct. Cockroft-Gault = " + sizeBodyValue);
        } else {
            System.out.println("Value of Поверхность тела  correct.");
        }
        //  12.Закрыть окно браузера
        driver.quit();
    }
}
