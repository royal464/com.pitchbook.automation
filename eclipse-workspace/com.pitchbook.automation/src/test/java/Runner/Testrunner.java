package Runner;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "Features",glue= {"StepDefination"},
dryRun=false,
plugin = { "pretty", "html:target/cucumber", "json:target/cucumber.json",
"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" })
public class Testrunner {
	

}
