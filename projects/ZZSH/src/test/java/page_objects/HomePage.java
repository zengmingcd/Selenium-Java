package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_objects.SearchResultPage;

public class HomePage {
    private final String TITLE = "Homepage";
    protected WebDriver driver;
    private By search_key = By.id("search_key");
    private By search_btn = By.id("search-btn");
    public HomePage(WebDriver driver){
        this.driver = driver;
        if (!driver.getTitle().equals(TITLE)){
            throw new IllegalStateException("This is not Homepage, Current page is " + driver.getCurrentUrl());
        }
    }

    /*
     * Search
     */
    public SearchResultPage doSearch(String search_key_str){
        driver.findElement(search_key).sendKeys(search_key_str);
        driver.findElement(search_btn).click();
        return new SearchResultPage(driver);
    }
}
