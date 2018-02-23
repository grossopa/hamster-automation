/**
 * 
 */
package org.hamster.automation.spring;

import org.hamster.automation.spring.context.loader.AppAnnotationConfigContextLoader;
import org.hamster.automation.validation.TagValidator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.Scenario;

/**
 * entry parent class for sub Scenario
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@ContextConfiguration(loader = AppAnnotationConfigContextLoader.class)
public abstract class AbstractTestSteps {
    
    /**
     * the root configuration class
     *
     * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
     * @since 1.0
     */
    @Configuration
    public static class AutomationTestConfig extends TestConfig {

    }

    protected @Value("${automation.app.baseurl}") String baseUrl;

    /**
     * current web driver
     */
    @Autowired
    protected RemoteWebDriver driver;

    /**
     * tag validator
     */
    @Autowired
    protected TagValidator tagValidator;

    /**
     * Due to Cucumber its own limitation of not allowing inheritance with hook defined e.g. {@link cucumber.api.java.Before}. Hence here has to be
     * child class to define the before method with the annotation {@link cucumber.api.java.Before}, same parameter and then simply involves this
     * method.
     * 
     * @param scenario
     *            the current execution scenario
     */
    public void before(Scenario scenario) {
        tagValidator.validateTags(scenario);
    }

}
