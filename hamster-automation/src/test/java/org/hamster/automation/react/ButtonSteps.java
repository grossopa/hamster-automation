/**
 * 
 */
package org.hamster.automation.react;

import org.hamster.automation.react.base.ReactElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class ButtonSteps {

    private WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "D:\\automation\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.navigate().to("http://localhost:3000");
    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("^A React button with anchor \"([^\"]*)\"$")
    public void a_React_button_with_anchor(String id) throws Throwable {
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
