package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        monochrome = false,
        features = "src/test/resources/features/alugarFilme.feature",
        glue = "steps"
)
public class RunnerTest {
}
