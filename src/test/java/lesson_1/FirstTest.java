package lesson_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class FirstTest {

    @Test
    public void testCalculate(){
        ChromeDriver driver= new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        WebElement weight=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/section/article/div/form/p[1]/input"));
        WebElement height=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/section/article/div/form/p[2]/select[1]"));
        WebElement calculate=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/section/article/div/form/p[3]/input[2]"));
        WebElement SIUnits=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/section/article/div/form/table[1]/tbody/tr[1]/td[2]/input"));
        weight.sendKeys("86");
        height.sendKeys("6′");
        calculate.click();
        SIUnits.equals("25.68");
        driver.quit();
    }
}
