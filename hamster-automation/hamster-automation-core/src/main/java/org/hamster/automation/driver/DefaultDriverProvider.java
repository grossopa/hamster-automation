/**
 * 
 */
package org.hamster.automation.driver;

import java.io.File;
import java.util.Objects;

import org.hamster.automation.driver.DriverType.DriverAction;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService.Builder;

/**
 * Default implementation of {@link DriverProvider}
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class DefaultDriverProvider implements DriverProvider {

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
     * @see org.hamster.automation.driver.DriverProvider#build(org.hamster.automation.driver.DriverType,
     * org.hamster.automation.driver.DriverType.DriverAction)
     */
    @Override
    public RemoteWebDriver build(DriverType driverType, DriverAction<Builder<?, ?>, Void> enrichBuilderAction,
            DriverAction<Void, Capabilities> getOptionsAction) {
        Objects.requireNonNull(driverType);
        Builder<?, ?> builder = driverType.apply(new GetDriverBuilderAction(), null);
        builder.usingDriverExecutable(driverFile).usingAnyFreePort();
        if (enrichBuilderAction != null) {
            driverType.apply(enrichBuilderAction, builder);
        }

        if (getOptionsAction == null) {
            getOptionsAction = new DefaultGetOptionsAction();
        }

        Capabilities option = driverType.apply(getOptionsAction, null);

        return driverType.apply(new BuildDriverAction(), BuildDriverAction.BuildDriverParam.of(builder, option));

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverProvider#build(org.hamster.automation.driver.DriverType)
     */
    @Override
    public RemoteWebDriver build(DriverType driverType) {
        return build(driverType, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverProvider#build(org.hamster.automation.driver.DriverType,
     * org.hamster.automation.driver.DriverType.DriverAction)
     */
    @Override
    public RemoteWebDriver build(DriverType driverType, DriverAction<Builder<?, ?>, Void> enrichBuilderAction) {
        return build(driverType, enrichBuilderAction, null);
    }

}
