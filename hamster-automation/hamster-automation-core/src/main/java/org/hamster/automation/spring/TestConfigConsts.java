/**
 * 
 */
package org.hamster.automation.spring;

/**
 * Contains constants for {@link TestConfig}
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public interface TestConfigConsts {
    
    String PROPERTIES_CORE = "config/automation.properties";
    String PROPERTIES_ENVIRONMENT = "config/automation.env.${environment}.properties";
    String PROPERTIES_DRIVER = "config/automation.driver.${driver}.properties";
    
    String DRIVER_NA = "na";
}
