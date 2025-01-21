package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import support.Esperas;

public class Hooks {

    @Before
    public void start() throws Exception {
        final String BROWSER_COMANDO = System.getProperty("browser");
        DriverManager.Browsers browser;
        boolean headless;
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
            headless = true;
        } else {
            browser = DriverManager.Browsers.FIREFOX;
            headless = false;
        }

        DriverManager.getDriver(browser, headless);
        DriverManager.driver.get("https://automationpratice.com.br");
        DriverManager.driver.manage().window().maximize();
        Esperas.esperarPaginaCarregarCompletamente();
    }

    @After
    public void stop() {
        DriverManager.quitDriver();
    }
}
