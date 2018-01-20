/**
 * 
 */
package org.hamster.automation.validation;

import java.util.Collection;
import java.util.regex.Pattern;

import com.google.common.base.Preconditions;

/**
 *
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class RegexTagValidation implements TagValidation {

    private final String name;
    private final Pattern regexPattern;
    private final RequiredLevel requiredLevel;

    public RegexTagValidation(String name, String regex, RequiredLevel requiredLevel) {
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(regex);
        Preconditions.checkNotNull(requiredLevel);
        this.name = name;
        this.regexPattern = Pattern.compile(regex);
        this.requiredLevel = requiredLevel;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.validation.TagValidation#validate(java.lang.String)
     */
    @Override
    public TagValidationResult validate(String tagName) {
        return regexPattern.matcher(tagName).matches() ? TagValidationResult.ACCEPTED : TagValidationResult.REJECTED;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.validation.TagValidation#count(java.util.Collection)
     */
    @Override
    public int count(Collection<String> tags) {
        int[] count = new int[1];
        tags.forEach(s -> {
            if (validate(s) == TagValidationResult.ACCEPTED) {
                count[0]++;
            }
        });
        return count[0];
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return the requiredLevel
     */
    @Override
    public RequiredLevel getRequiredLevel() {
        return requiredLevel;
    }

}
