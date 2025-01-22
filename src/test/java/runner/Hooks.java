package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import support.Esperas;
import support.Screenshot;

public class Hooks {

    @Before
    public void start() throws Exception {
        final String BROWSER_COMANDO = System.getProperty("browser");
        DriverManager.Browsers browser;
        if (BROWSER_COMANDO != null) {
            final String BROWSER_COMANDO_FORMATADO = BROWSER_COMANDO.trim().toUpperCase();
            switch (BROWSER_COMANDO_FORMATADO) {
                case "FIREFOX" ->
                    browser = DriverManager.Browsers.FIREFOX;
                case "CHROME" ->
                    browser = DriverManager.Browsers.CHROME;
                default ->
                    throw new IllegalArgumentException("***** Navegadores disponíveis: FIREFOX e CHROME");
            }
        } else {
            browser = DriverManager.Browsers.FIREFOX;
        }
        DriverManager.startDriver(browser);
        DriverManager.getDriver().get("https://automationpratice.com.br");
        DriverManager.getDriver().manage().window().maximize();
        Esperas.esperarPaginaCarregarCompletamente();
    }

    @After
    public void stop(Scenario scenario) {
        if (scenario.isFailed()) {
            Screenshot.adicionarScreenshotEmCenario(scenario);
        }
        DriverManager.quitDriver();
    }
}
