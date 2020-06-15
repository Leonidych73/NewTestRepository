package newLearningTests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class LearningTests extends WebDriverSettings{
    @Test
    public void AutorizTest() throws InterruptedException {
        //driver.manage().window().setSize(new Dimension(600,600));  Не используем
        driver.get("https://www.rozetka.com.ua/");
        driver.findElement(By.xpath("//a[@class='header-topline__user-link link-dashed']")).click();
        Random random = new Random();
        int m = random.nextInt(100) + 1; // генерируем случайный номер тестера
        String email = "tester" + m + "@gmail.com";
        driver.findElement(By.xpath("//input[@id='auth_email']")).sendKeys(email); //вводим не валидный логин
        driver.findElement(By.id("auth_pass")).sendKeys("password");//вводим не валидный пароль
        driver.findElement(By.xpath("//button[@class='button button_size_large button_color_green auth-modal__submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='error-message error-message_type_tooltip error-message_type_text error-message_color_red']")));
        String massageError = driver.findElement(By.xpath("//p[@class='error-message error-message_type_tooltip error-message_type_text error-message_color_red']")).getText();
        System.out.println(massageError);
        Assert.assertTrue(massageError.equals("Пользователь с логином " + email + " не зарегистрирован"));

    }
    //@Ignore
    @Test
    public void titleTest() throws InterruptedException {
        driver.get("https://www.rozetka.com.ua/");
        String title = driver.getTitle(); //Переменная title для сравнения ожидаемая /факт
        Assert.assertEquals("Интернет-магазин ROZETKA™: официальный сайт самого популярного онлайн-гипермаркета в Украине", title); //Тайтл
    }
    //@Ignore
    @Test
    public void cartTest() throws InterruptedException {
        driver.get("https://www.rozetka.com.ua/");
        driver.findElement(By.xpath("//a[@class='header-actions__button header-actions__button_type_basket']//*[local-name()='svg']")).click(); //Открыть корзину
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(@class,'modal__close js-modal-close')]")).click(); //закрыть корзину
    }
    //@Ignore
    @Test
    public void menuTest() throws InterruptedException {
        driver.get("https://www.rozetka.com.ua/");
        driver.findElement(By.xpath("//span[@class='menu-toggler__text']")).click();

    }

}

