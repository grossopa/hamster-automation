/**
 * 
 */
package org.hamster.automation.spring;

import org.hamster.automation.driver.DefaultDriverProvider;
import org.hamster.automation.driver.DriverProvider;
import org.hamster.automation.driver.DriverType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * Provides default driver configuration for Spring-based tests.
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class DriverConfig {

    /**
     * Selenium Executable driver path
     */
    protected @Value("${automation.driver.path}") String driverPath;

    /**
     * the driver type
     * 
     * @see DriverType
     */
    protected @Value("${automation.driver.type}") String driverType;

    @Bean
    @Primary
    public DriverProvider driverProvider() {
        return new DefaultDriverProvider(driverPath);
    }

    @Autowired
    private DriverProvider driverProvider;

    @Bean
    @Primary
    public RemoteWebDriver remoteWebDriver() {
        return driverProvider.build(DriverType.valueOf(driverType));
    }
}
