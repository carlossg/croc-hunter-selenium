package org.csanchez.selenium.example;

import static org.junit.Assert.assertNotNull;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExampleTest {

    private final static String URL = System.getProperty("url");
    private final static String SELENIUM_URL = System.getProperty("selenium.url", "http://localhost:4444/wd/hub");
    private final static String SELENIUM_BROWSER = System.getProperty("selenium.browser", "chrome");
    private final static int SLEEP = Integer.parseInt(System.getProperty("sleep", "10000"));

    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        assertNotNull(URL);
        DesiredCapabilities capabilities = new DesiredCapabilities(SELENIUM_BROWSER, "", Platform.ANY);
        this.driver = new RemoteWebDriver(new URL(SELENIUM_URL), capabilities);
    }

    @Test
    public void test() throws Exception {
        // And now use this to visit Google
        driver.get(URL);
        // Alternatively the same thing can be done like this
        // driver.navigate().to(URL);

        Thread.sleep(SLEEP);

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        // (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
        //     public Boolean apply(WebDriver d) {
        //         return ! d.findElement(By.name("release")).getText().isEmpty();
        //     }
        // });

        Thread.sleep(SLEEP);
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null)
            driver.quit();
    }
}