package ca.zzsh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstScript {
    public static void Main(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://zzsuitablehome.ca/");
        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement search_key = driver.findElement(By.name("search_key"));
        WebElement submit_btn = driver.findElement(By.id("search-btn"));

        search_key.sendKeys("type:tenant,tenant_phone:123456,tenant_name:ZZSuitableHome");
        submit_btn.click();

        WebElement result_title = driver.findElement(By.className("title"));
        System.out.println(result_title.getText());

        driver.quit();

    }
}
