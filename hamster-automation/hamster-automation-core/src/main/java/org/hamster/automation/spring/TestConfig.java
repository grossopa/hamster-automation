package org.hamster.automation.spring;

import org.hamster.automation.driver.DefaultDriverProvider;
import org.hamster.automation.driver.DriverProvider;
import org.hamster.automation.driver.DriverType;
import org.hamster.automation.validation.DefaultTagValidator;
import org.hamster.automation.validation.TagValidator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Uses in a Spring Test environment
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@Configuration
@PropertySource(TestConfigConsts.PROPERTIES_CORE)
@PropertySource(value = TestConfigConsts.PROPERTIES_ENVIRONMENT, ignoreResourceNotFound = true)
@PropertySource(value = TestConfigConsts.PROPERTIES_DRIVER, ignoreResourceNotFound = true)
public class TestConfig {

    protected @Value("${automation.driver.path}") String driverPath;
    protected @Value("${automation.driver.type}") String driverType;
    protected @Value("${automation.app.baseurl}") String baseUrl;
    
    @Bean
    public DriverProvider driverProvider() {
        return new DefaultDriverProvider(driverPath);
    }
    
    @Autowired
    private DriverProvider driverProvider;
    
    @Bean
    public RemoteWebDriver remoteWebDriver() {
        return driverProvider.build(DriverType.valueOf(driverType));
    }
    
    @Bean
    public TagValidator tagValidator() {
        return new DefaultTagValidator();
    }

}
