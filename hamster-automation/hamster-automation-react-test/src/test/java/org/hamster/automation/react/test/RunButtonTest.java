/**
 * 
 */
package org.hamster.automation.react.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 *
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@RunWith(Cucumber.class)
// @ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
// jsonUsageReport = "target/cucumber-usage.json",
// usageReport = true,
// overviewReport= true,
// overviewChartsReport= true,
// coverageReport= true,
// detailedReport= true,
// detailedAggregatedReport= true,
// outputFolder = "target")"html:target/cucumber-html-reports",
@CucumberOptions(plugin = { "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
        "junit:target/cucumber-results.xml" }, glue = "org.hamster.automation.react.steps", features = "src/test/resources/features/react")
public class RunButtonTest {

}
