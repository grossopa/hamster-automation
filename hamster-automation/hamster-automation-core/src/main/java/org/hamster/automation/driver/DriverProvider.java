/**
 * 
 */
package org.hamster.automation.driver;

import org.hamster.automation.driver.DriverType.DriverAction;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService.Builder;

/**
 * Registers driver with executable drivers.
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public interface DriverProvider {

    /**
     * Builds the {@link RemoteWebDriver} with default settings.
     * 
     * @param driverType
     * @return
     */
    RemoteWebDriver build(DriverType driverType);

    /**
     * Builds the {@link RemoteWebDriver} by driver type and customized configured builders.
     * 
     * @param driverType
     *            the desired driver type
     * @param enrichBuilderAction
     *            to enrich the builder
     * @return the built DriverService
     */
    RemoteWebDriver build(DriverType driverType, DriverAction<Builder<?, ?>, Void> enrichBuilderAction);

    /**
     * Builds the {@link RemoteWebDriver} by driver type and customized configured builders and options.
     * 
     * @param driverType
     * @param enrichBuilderAction
     * @param getOptionsAction
     * @return
     */
    RemoteWebDriver build(DriverType driverType, DriverAction<Builder<?, ?>, Void> enrichBuilderAction,
            DriverAction<Void, Capabilities> getOptionsAction);

}
