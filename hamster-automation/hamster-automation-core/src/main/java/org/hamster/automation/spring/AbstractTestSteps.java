/**
 * 
 */
package org.hamster.automation.spring;

import org.hamster.automation.validation.TagValidator;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.Scenario;

/**
 *
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class AbstractTestSteps {

    @Autowired
    private TagValidator tagValidator;

    /**
     * Due to Cucumber its own limitation of not allowing inheritance with hook defined e.g.
     * {@link cucumber.api.java.Before}. Hence here has to be child class to define the before method with the
     * annotation {@link cucumber.api.java.Before}, same parameter and then simply involves this method.
     * 
     * @param scenario
     *            the current execution scenario
     */
    public void before(Scenario scenario) {
        tagValidator.validateTags(scenario);
    }
}
