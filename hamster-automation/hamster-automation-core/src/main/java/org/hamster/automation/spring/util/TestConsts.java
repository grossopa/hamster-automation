/**
 * 
 */
package org.hamster.automation.spring.util;

import org.hamster.automation.driver.DriverType;
import org.hamster.automation.spring.TestConfig;

/**
 * Contains constants for {@link TestConfig}
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public interface TestConsts {

    /**
     * Core properties are collected in this file, duplicated properties with {@link TestConsts#PROPERTIES_ENVIRONMENT} will be overridden.
     */
    String PROPERTIES_CORE = "config/automation.properties";

    /**
     * Environmental properties, will override duplicated properties defined in {@link TestConsts#PROPERTIES_CORE}<br>
     * 
     * Placeholder environment sample values : LOCAL, DEVELOPMENT, UAT, PRODUCTION
     */
    String PROPERTIES_ENVIRONMENT = "config/automation.env.${environment}.properties";

    /**
     * Driver properties, will override duplicated properties defined in {@link TestConsts#PROPERTIES_DRIVER}<br>
     * 
     * @see DriverType for all available values
     */
    String PROPERTIES_DRIVER = "config/automation.driver.${driver}.properties";

    String DRIVER_NA = "na";
}
