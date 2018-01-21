/**
 * 
 */
package org.hamster.automation.validation;

import cucumber.api.Scenario;

/**
 * Validate tags of a scenario
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public interface TagValidator {
    
    /**
     * validate tags of a scenario
     * 
     * @param scenario
     */
    void validateTags(Scenario scenario);

}
