/**
 * 
 */
package org.hamster.automation.validation;

import java.util.Collection;

import cucumber.api.Scenario;

/**
 * Validates whether tag is legal and expected. The principle behind the check is to provide a consistent and managed
 * way for tag names thus allows QA developers to build defined test suites and avoid random tag names of confusion.
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public interface TagValidation {

    /**
     * Validates the tag name.
     * 
     * @param tagName tag name iterated from {@link Scenario}
     * @return validation result
     */
    TagValidationResult validate(String tag);
    
    /**
     * find matches count.
     * 
     * @param tags
     * @return
     */
    int count(Collection<String> tags);
    
    /**
     * 
     * @return name of the validation
     */
    String getName();
    
    /**
     * 
     * @return required level of the validation
     */
    RequiredLevel getRequiredLevel();
}
