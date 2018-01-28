package org.hamster.automation.react;

import org.hamster.automation.react.base.ReactElement;
import org.hamster.automation.spring.AbstractTestSteps;
import org.hamster.automation.spring.TestConfig;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

/**
 *
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@RunWith(Cucumber.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class ButtonSteps extends AbstractTestSteps {
    
    @Configuration
    public static class AutomationTestConfig extends TestConfig {
        
    }
    
    @Before
    public void before(Scenario scenario) {
        super.before(scenario);
    }

    @Autowired
    private RemoteWebDriver driver;


    @Given("^A React button with anchor \"([^\"]*)\"$")
    public void a_React_button_with_anchor(String id) throws Throwable {
        driver.navigate().to("http://localhost:3000");
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ReactElement.getXpath(id))));
        System.out.println(element);
    }

    @When("^I move my mouse to hover it$")
    public void i_move_my_mouse_to_hover_it() throws Throwable {
    }

    @Then("^the button css will change to \"([^\"]*)\"$")
    public void the_button_css_will_change_to(String id) throws Throwable {
    }

    //
    // @Given("^A React button with anchor '(.*?)'$")
    // public void given(String id) {
    //
    // }
    //
    // @When("^I move my mouse to hover it$")
    // public void hover() {
    //
    // }
    //
    // @Then("^the button css will change to '(.*?)'$")
    // public void then() {
    //
    // }

}
