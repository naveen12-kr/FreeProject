package Runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags= {},features={"src/test/resources/Features/"},glue= {"StepDefinations"},
monochrome = true, dryRun = false, strict = true)


public class ProjectRunner {

}
