package runner;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import report.TestReportManager;
import report.TestReportVariables;
import support.Esperas;
import support.Screenshot;

public class Hooks {

    static TestReportVariables testExecutionVariables = new TestReportVariables();
    private static Instant startTime;

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
            testExecutionVariables.incrementError();
        }
        if (scenario.getStatus() == Status.PASSED) {
            testExecutionVariables.incrementSuccess();
        }
        testExecutionVariables.incrementTotal();
        DriverManager.quitDriver();
    }

    @BeforeAll
    public static void beforeAll() {
        startTime = Instant.now();
    }

    @AfterAll
    public static void afterAll() {
        Instant endTime = Instant.now();
        long duration = Duration.between(startTime, endTime).toSeconds();
        testExecutionVariables.setTempoExecucao(duration);
        try {
            TestReportManager.saveReport(testExecutionVariables);
        } catch (IOException e) {
            throw new RuntimeException("\n***** Erro ao salvar o relatório de testes: " + e.getMessage());
        }
    }
}
