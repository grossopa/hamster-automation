/**
 * 
 */
package org.hamster.automation.driver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.remote.service.DriverService.Builder;

/**
 * Registers driver with executable drivers and provides a getter function to get the {@link RemoteWebDriver} instance.
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public interface DriverProvider {

    /**
     * registers web driver
     * 
     * @param webDriver
     */
    <DS extends DriverService, B extends Builder<?, ?>> void register(DriverService.Builder<DS, B> builder);

    RemoteWebDriver getWebDriver();
}
