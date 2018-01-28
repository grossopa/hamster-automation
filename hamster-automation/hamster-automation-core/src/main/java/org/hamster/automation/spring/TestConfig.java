package org.hamster.automation.spring;

import javax.annotation.PostConstruct;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.junit.Cucumber;

/**
 * Uses in a Spring Test environment
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
@RunWith(Cucumber.class)
@ContextConfiguration
@PropertySource(TestConfigConsts.PROPERTIES_CORE)
@PropertySource(value = TestConfigConsts.PROPERTIES_ENVIRONMENT, ignoreResourceNotFound = true)
@PropertySource(value = TestConfigConsts.PROPERTIES_DRIVER, ignoreResourceNotFound = true)
public class TestConfig {

    protected @Value("${automation.driver.path}") String driverPath;
    protected @Value("${automation.driver.classtype}") String classType;
    protected @Value("${automation.app.baseurl}") String baseUrl;

    @PostConstruct
    public void init() {

    }

}
