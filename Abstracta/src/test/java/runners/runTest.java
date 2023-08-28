package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/search.feature",glue = {"stepDefinitions"})
public class runTest extends AbstractTestNGCucumberTests {
}
