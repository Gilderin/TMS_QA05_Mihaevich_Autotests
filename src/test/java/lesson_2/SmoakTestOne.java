package lesson_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SmoakTestOne {
    @Test
    public void testOne() {
        //1. Открыть сайт https://www.3crkp.by/информация/полезно-знать/медицинские-калькуляторы/расчет-имт
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.3crkp.by/информация/полезно-знать/медицинские-калькуляторы/расчет-имт");
        // 2. Ввести Рост = 183 см
        WebElement height = driver.findElement(By.name("ht"));
        height.sendKeys("183");
        // 3. Ввести Вес = 58 кг
        WebElement weight = driver.findElement(By.name("mass"));
        weight.sendKeys("53");
        // 4. Нажать на кнопку ‘Рассчитать’
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();
        // 5. Проверить, что значение в поле ‘ИМТ’ равно 17.32
        WebElement IMT = driver.findElement(By.name("result"));
        String imtText = IMT.getAttribute("value");
        if (!imtText.equals("17.32")) {
            System.out.println("IMT не соответствует. Равно = " + imtText);
        }
        // 6. Проверить, что статус равен ’Пониженный вес’
        WebElement status = driver.findElement(By.id("resline"));
        String statusText=status.getText();
        if(!statusText.equals("Пониженный вес")){
            System.out.println("Status not correct. Status = "+statusText);
        }else{
            System.out.println("Status is correct");
        }
        // 7. Закрыть окно браузера
        driver.quit();
    }
}
