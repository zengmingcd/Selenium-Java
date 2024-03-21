package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
    private final String TITLE = "Search Result";
    protected WebDriver driver;
    private By result_title = By.className("title");
    private By search_result_notice = By.className("search_result_notice");
    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        if (!driver.getTitle().equals(TITLE)){
            throw new IllegalStateException("This is not Search Result page, Current page is " + driver.getCurrentUrl());
        }
    }

    public String getSearchResultTitle(){
        return driver.findElement(result_title).getText();
    }

    public String getSearchResultNotice(){
        return driver.findElement(search_result_notice).getText();
    }


}
