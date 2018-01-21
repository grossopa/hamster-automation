/**
 * 
 */
package org.hamster.automation.validation;

import static java.text.MessageFormat.format;

import java.util.List;

import com.beust.jcommander.internal.Lists;

import cucumber.api.Scenario;

/**
 * validates all tags
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class DefaultTagValidator implements TagValidator {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.validation.TagValidator#validateTags(cucumber.api.Scenario)
     */
    @Override
    public void validateTags(Scenario scenario) {
        List<TagValidation> validations = getTagValidations();
        scenario.getSourceTagNames().forEach(t -> {
            boolean[] validated = new boolean[1];
            validations.forEach(v -> {
                if (v.validate(t) == TagValidationResult.ACCEPTED) {
                    validated[0] = true;
                }
            });

            if (!validated[0]) {
                throw new AssertionError(format("Invalid tag \"{0}\" detected.", t));
            }
        });
    }

    /**
     * Registers tag validations, the validation will be performed before each test scenario in order to detect invalid
     * tags.
     */
    protected List<TagValidation> getTagValidations() {
        return defaultTagValidations();
    }

    /**
     * constructs default tag validations
     * 
     * @return default validations as list
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
