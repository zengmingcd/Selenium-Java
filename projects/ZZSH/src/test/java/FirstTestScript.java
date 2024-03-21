import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTestScript {
    @Test
    public void testClickSearchBtn(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://zzsuitablehome.ca/");

        String title = driver.getTitle();
        assertEquals("Homepage", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement search_key = driver.findElement(By.id("search_key"));
        WebElement search_btn = driver.findElement(By.className("btn"));

        search_key.sendKeys("type:tenant,tenant_phone:123456,tenant_name:ZZSuitableHome");
        search_btn.click();

        WebElement result_content = driver.findElement(By.className("title"));
        String content = result_content.getText();
        assertEquals("Ops! We do not find any review record!", content);
        assertEquals("Ops? We do not find any review record!", content);

        driver.quit();
    }
}
