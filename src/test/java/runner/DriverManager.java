package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    private static WebDriver driver;

    public enum Browsers {
        FIREFOX,
        CHROME;
    }

    protected static void startDriver(Browsers browser) {
        //Verifica se é para executar no modo headless e se está sendo executado via pipeline
        //Caso seja executado via pipeline, o próprio drivermanager vai fazer a gestão dos drivers.
        final boolean IS_HEADLESS = Boolean.parseBoolean(System.getProperty("headless", "false"));
        final boolean IS_PIPELINE = Boolean.parseBoolean(System.getenv("is_pipeline"));

        switch (browser) {
            case FIREFOX -> {
                if (IS_PIPELINE) {
                    WebDriverManager.firefoxdriver().setup();
                } else {
                    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                }
                FirefoxOptions options = new FirefoxOptions();
                if (IS_HEADLESS) {
                    options.addArguments("--headless");
                }
                driver = new FirefoxDriver(options);
            }
            case CHROME -> {
                if (IS_PIPELINE) {
                    WebDriverManager.chromedriver().setup();
                } else {
                    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                }
                ChromeOptions options = new ChromeOptions();
                if (IS_HEADLESS) {
                    options.addArguments("--headless");
                }
                driver = new ChromeDriver(options);
            }
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    protected static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
