/**
 * 
 */
package org.hamster.automation;

import org.hamster.automation.validation.DefaultTagValidator;
import org.hamster.automation.validation.TagValidator;
import org.junit.BeforeClass;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

/**
 * Abstract class for all steps
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public abstract class AbstractTestSteps {
    
    private TagValidator tagValidator = new DefaultTagValidator();
    
    @BeforeClass
    public static void beforeClass() {

    }

    @Before
    public void before(Scenario scenario) {
        tagValidator.validateTags(scenario);
    }

}
