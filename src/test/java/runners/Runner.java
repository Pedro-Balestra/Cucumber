package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        features = "src/test/resources/features/aprenderCucumber.feature",
        glue = "steps",
        tags = "not @ignore"
)
public class Runner {
}
