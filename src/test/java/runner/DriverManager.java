package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver driver;

    public enum Browsers {
        FIREFOX,
        CHROME;
    }

    protected static void getDriver(Browsers browser, boolean headless) {
        switch (browser) {
            case FIREFOX -> {
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                if (headless){
                    options.addArguments("--headless");
                }
                driver = new FirefoxDriver(options);
            }
            case CHROME -> {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                if (headless){
                    options.addArguments("--headless");
                }
                driver = new ChromeDriver(options);
            }
        }
    }

    protected static void quitDriver() {
        driver.quit();
        driver = null;
    }

}