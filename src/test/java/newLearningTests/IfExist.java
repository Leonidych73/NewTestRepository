package newLearningTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IfExist extends WebDriverSettings {
    @Test
    public void ifExist () throws InterruptedException {
        driver.get("https://www.rozetka.com.ua/");
        driver.findElement(By.xpath("//div[@class='header-topline']//li[1]//a[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[@class='c-i no-margin']//h2[@class='c-i-service-title']")));
        int i=driver.findElements(By.xpath("//article[@class='c-i no-margin']//h2[@class='c-i-service-title']")).size();
        Assert.assertTrue(i!=0);
        /*if (i == 0)
            System.out.println("Element is not present");
        else
            System.out.println("Element is present");
        System.out.println(i);*/
    };

}
