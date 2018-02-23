package org.hamster.automation.spring;

import org.hamster.automation.spring.util.TestConsts;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Facade of all predefined configuration and expected to be used in a Spring Test environment
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@PropertySource(TestConsts.PROPERTIES_CORE)
@PropertySource(value = TestConsts.PROPERTIES_ENVIRONMENT, ignoreResourceNotFound = true)
@PropertySource(value = TestConsts.PROPERTIES_DRIVER, ignoreResourceNotFound = true)
public class TestConfig {
    
    @Configuration
    public static class AppDriverConfig extends DriverConfig {

    }

    @Configuration
    public static class AppTagValidationConfig extends TagValidationConfig {

    }

}
