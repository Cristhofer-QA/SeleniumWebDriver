package support;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.Scenario;
import runner.DriverManager;

public class Screenshot extends DriverManager {

    public static void adicionarScreenshotEmCenario(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "ERRO");
    }
}
