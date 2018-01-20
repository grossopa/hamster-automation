/**
 * 
 */
package org.hamster.automation;

import java.util.List;

import org.hamster.automation.validation.RegexTagValidation;
import org.hamster.automation.validation.RequiredLevel;
import org.hamster.automation.validation.TagValidation;
import org.junit.BeforeClass;

import com.beust.jcommander.internal.Lists;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

/**
 * Abstract class for all steps
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public abstract class AbstractTestSteps {

    @BeforeClass
    public static void beforeClass() {

    }

    @Before
    public void before(Scenario scenario) {
    }

    /**
     * registers tag validations, the validation will be performed before each test scenario in order to detect invalid
     * tags.
     */
    protected abstract void registerTagValidations();

    /**
     * constructs default tag validations
     * 
     * @return
     */
    protected List<TagValidation> defaultTagValidations() {
        List<TagValidation> result = Lists.newArrayList();
        result.add(environmentValidation());
        result.add(versionValidation());
        result.add(typeValidation());
        return result;
    }

    /**
     * must have applicable environment(s)
     */
    protected TagValidation environmentValidation() {
        return new RegexTagValidation("environment", "ALL|LOCAL|SIT|DEV|INT|UAT|PROD", RequiredLevel.MANDATORY);
    }

    /**
     * must have version (since) 
     */
    protected TagValidation versionValidation() {
        return new RegexTagValidation("version", "([A-Za-z0-9]+-)?[0-9]+.[0-9]+(.[0-9]+)?", RequiredLevel.MANDATORY);
    }

    /**
     * optional for testing type
     */
    protected TagValidation typeValidation() {
        return new RegexTagValidation("type", "feature|regression", RequiredLevel.OPTIONAL);
    }

}
