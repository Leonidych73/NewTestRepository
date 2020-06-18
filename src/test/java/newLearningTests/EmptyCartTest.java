package newLearningTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmptyCartTest extends WebDriverSettings {
    @Test
    public void ifExist() throws InterruptedException {
        driver.get("https://www.rozetka.com.ua/");
        //driver.findElement(By.xpath("//a[@class='header-actions__button header-actions__button_type_basket header-actions__button_state_active']//*[local-name()='svg']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='header-actions__button header-actions__button_type_basket']//*[local-name()='svg']"))).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='cart-modal__dummy']")).getText().contains("Корзина пуста"));

    }


}