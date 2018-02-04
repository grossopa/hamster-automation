package org.hamster.automation.react;

import org.hamster.automation.react.base.ReactElement;
import org.hamster.automation.spring.AbstractTestSteps;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
public class ButtonSteps extends AbstractTestSteps {
    
    @Before
    public void before(Scenario scenario) {
        super.before(scenario);
    }

    @Given("^A React button with anchor \"([^\"]*)\"$")
    public void a_React_button_with_anchor(String id) throws Throwable {
        driver.navigate().to(baseUrl);
        
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

}
