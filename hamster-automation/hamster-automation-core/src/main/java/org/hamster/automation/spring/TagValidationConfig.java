/**
 * 
 */
package org.hamster.automation.spring;

import java.util.List;

import org.hamster.automation.validation.DefaultTagValidator;
import org.hamster.automation.validation.RegexTagValidation;
import org.hamster.automation.validation.TagValidation;
import org.hamster.automation.validation.TagValidationRequiredLevel;
import org.hamster.automation.validation.TagValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * Provides default tag validation configuration for Spring-based tests.
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class TagValidationConfig {

    /**
     * must have version (since)
     * 
     * @return RegexTagValidation for version validations
     */
    @Bean
    public TagValidation versionValidation() {
        return new RegexTagValidation("version", "\\@([A-Za-z0-9]+-)?[0-9]+\\.[0-9]+(\\.[0-9]+)?",
                TagValidationRequiredLevel.MANDATORY);
    }

    /**
     * must have bounded JIRA ticket
     * 
     * @return RegexTagValidation for JIRA validations
     */
    @Bean
    public TagValidation jiraValidation() {
        return new RegexTagValidation("version", "\\@[A-Za-z]+-[0-9]+", TagValidationRequiredLevel.OPTIONAL);
    }

    /**
     * Only allows Scenario with valid tags, sub class can override this method and provide their own tag validations.
     * 
     * @return the tag validator
     */
    @Bean
    @Primary
    public TagValidator tagValidator(@Autowired List<TagValidation> tagValidations) {
        return new DefaultTagValidator(tagValidations);
    }

}
