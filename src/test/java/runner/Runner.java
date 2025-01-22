package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@login",
        features = {"src/test/resources/features"},
        glue = {"steps", "runner"},
        plugin = {
            "pretty",
            "summary",
            "json:target/reports/report.json",
            "html:target/reports/report.html"
        },
        monochrome = true
)
public class Runner {

}
