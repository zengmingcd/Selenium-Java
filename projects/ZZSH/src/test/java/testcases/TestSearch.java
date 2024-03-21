package testcases;

import org.checkerframework.checker.units.qual.N;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.HomePage;
import page_objects.SearchResultPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSearch {
    private final String NO_RESULT_TITLE_STR = "Ops! We do not find any review record!";
    private final String SEARCH_RESULT_NOTICE_STR = "Depending on the query conditions, different results may be obtained. You can adjust the query conditions to get more information.";

    @Test
    public void searchNoResult(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://zzsuitablehome.ca/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        HomePage hp = new HomePage(driver);
        SearchResultPage srp = hp.doSearch("type:tenant,tenant_phone:123456,tenant_name:ZZSuitableHome");
        assertEquals(NO_RESULT_TITLE_STR, srp.getSearchResultTitle());
        assertEquals(SEARCH_RESULT_NOTICE_STR, srp.getSearchResultNotice());
        driver.quit();
    }

    @Test
    public void searchWithResult(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://zzsuitablehome.ca/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        HomePage hp = new HomePage(driver);
        SearchResultPage srp = hp.doSearch("type:tenant,tenant_phone:123456,tenant_name:ZZSuitableHome");
        assertEquals("test", srp.getSearchResultTitle());
        assertEquals(SEARCH_RESULT_NOTICE_STR, srp.getSearchResultNotice());
        driver.quit();
    }
}
