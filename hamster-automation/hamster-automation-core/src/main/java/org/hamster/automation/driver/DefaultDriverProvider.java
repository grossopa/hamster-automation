/**
 * 
 */
package org.hamster.automation.driver;

import java.io.File;
import java.util.Objects;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.remote.service.DriverService.Builder;

/**
 * default implementation of {@link DriverProvider}
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class DefaultDriverProvider implements DriverProvider {

    private RemoteWebDriver webDriver;
    private final File driverFile;

    public DefaultDriverProvider(String driverFilePath) {
        Objects.requireNonNull(driverFilePath);
        this.driverFile = new File(driverFilePath);

        if (!driverFile.exists() || !driverFile.isFile()) {
            throw new AssertionError("Driver doesn't exist! Path : " + driverFilePath);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverProvider#register(org.openqa.selenium.remote.RemoteWebDriver)
     */
    @Override
    public <DS extends DriverService, B extends Builder<?, ?>> void register(DriverService.Builder<DS, B> builder) {
        builder.usingDriverExecutable(driverFile).usingAnyFreePort();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverProvider#getWebDriver()
     */
    @Override
    public RemoteWebDriver getWebDriver() {
        return webDriver;
    }

}
