package newLearningTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class ScrollTest extends WebDriverSettings {
    @Test
    public void ifScroll() throws InterruptedException {
        driver.get("https://www.spotify.com/");
        String text = driver.findElement(By.xpath("//a[@class='mh-footer-secondary svelte-1ouzkfx'][contains(text(),'Privacy Policy')]")).getText();
        System.out.println(text);
        //Скрол вниз страницы
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0, 5000);");
        if( driver.findElement(By.xpath("//a[@class='mh-footer-secondary svelte-1ouzkfx'][contains(text(),'Privacy Policy')]")).isDisplayed()) {
            System.out.println("Element is Visible");
        }else{
            System.out.println("Element is InVisible");
        }
    }
}

