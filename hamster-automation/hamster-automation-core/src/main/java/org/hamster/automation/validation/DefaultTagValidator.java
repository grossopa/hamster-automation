/**
 * 
 */
package org.hamster.automation.validation;

import static java.text.MessageFormat.format;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;

import cucumber.api.Scenario;

/**
 * Contains following validation methods to ensure each scenario:<br>
 * 1. Must have tag(s) to indicate the applicable environments<br>
 * 2. Must have tag(s) to indicate a version number (since)<br>
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class DefaultTagValidator implements TagValidator {

    private static final Logger log = LoggerFactory.getLogger(DefaultTagValidator.class);

    /**
     * Registered tag validations, the validation logic will be performed before each test scenario in order to detect invalid tags.
     */
    private final List<TagValidation> validations;

    /**
     * Constructor
     * 
     * @param tagValidation
     *            validations need to be applied to each scenario
     */
    public DefaultTagValidator(List<TagValidation> validations) {
        this.validations = ImmutableList.copyOf(validations);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.validation.TagValidator#validateTags(cucumber.api.Scenario)
     */
    @Override
    public void validateTags(Scenario scenario) {
        Collection<String> tagNames = scenario.getSourceTagNames();

        // validate whether required tags are present
        validations.forEach(v -> {
            boolean[] exist = new boolean[1];
            tagNames.forEach(t -> {
                if (v.validate(t) == TagValidationResult.ACCEPTED) {
                    exist[0] = true;
                }
            });
            if (!exist[0]) {
                if (TagValidationRequiredLevel.MANDATORY == v.getRequiredLevel()) {
                    throw new AssertionError(format("Missing mandatory tag type \"{0}\" for Scenario \"{1}\"", v.getName(), scenario.getName()));
                } else if (TagValidationRequiredLevel.WARNING == v.getRequiredLevel()) {
                    log.info("Missing necessary tag type \"{}\" for Scenario \"{}\"", v.getName(), scenario.getName());
                }
            }
        });

        // validate whether tags are legal
        scenario.getSourceTagNames().forEach(t -> {
            boolean[] validated = new boolean[1];
            validations.forEach(v -> {
                if (v.validate(t) == TagValidationResult.ACCEPTED) {
                    validated[0] = true;
                }
            });
            if (!validated[0]) {
                throw new AssertionError(format("Invalid tag \"{0}\" detected for Scenario \"{1}\"", t, scenario.getName()));
            }
        });
    }

}
