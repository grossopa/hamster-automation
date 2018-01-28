/**
 * 
 */
package org.hamster.automation.driver;

import java.util.Objects;

import org.hamster.automation.driver.BuildDriverAction.BuildDriverParam;
import org.hamster.automation.driver.DriverType.DriverAction;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.remote.service.DriverService.Builder;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;
import org.openqa.selenium.safari.SafariOptions;

/**
 * Builds the driver by {@link DriverService.Builder} with {@link Capabilities}
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class BuildDriverAction implements DriverAction<BuildDriverParam, RemoteWebDriver> {

    /**
     * Params holder for {@link BuilderDriverAction}
     *
     * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
     * @since 1.0
     */
    public static class BuildDriverParam {
        private final Builder<?, ?> builder;
        private final Capabilities capabilities;

        /**
         * Constructor
         * 
         * @param builder
         *            non-null DriverService.builder
         * @param capabilities
         *            a.k.a option in selenium-${browser}-driver
         */
        public BuildDriverParam(Builder<?, ?> builder, Capabilities capabilities) {
            Objects.requireNonNull(builder);
            Objects.requireNonNull(capabilities);
            this.builder = builder;
            this.capabilities = capabilities;
        }

        /**
         * @return the builder
         */
        public Builder<?, ?> getBuilder() {
            return builder;
        }

        /**
         * @return the capabilities
         */
        public Capabilities getCapabilities() {
            return capabilities;
        }

        /**
         * create an instance of {@link BuilderDriverParam}
         * 
         * @param builder
         * @param capabilities
         * @return the instance of {@link BuilderDriverParam}
         */
        public static final BuildDriverParam of(Builder<?, ?> builder, Capabilities capabilities) {
            return new BuildDriverParam(builder, capabilities);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyChrome(java.lang.Object)
     */
    @Override
    public RemoteWebDriver applyChrome(BuildDriverParam t) {
        return new ChromeDriver((ChromeDriverService) t.getBuilder().build(), (ChromeOptions) t.getCapabilities());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyEdge(java.lang.Object)
     */
    @Override
    public RemoteWebDriver applyEdge(BuildDriverParam t) {
        return new EdgeDriver((EdgeDriverService) t.getBuilder().build(), (EdgeOptions) t.getCapabilities());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyFirefox(java.lang.Object)
     */
    @Override
    public RemoteWebDriver applyFirefox(BuildDriverParam t) {
        return new FirefoxDriver((GeckoDriverService) t.getBuilder().build(), (FirefoxOptions) t.getCapabilities());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyIE(java.lang.Object)
     */
    @Override
    public RemoteWebDriver applyIE(BuildDriverParam t) {
        return new InternetExplorerDriver((InternetExplorerDriverService) t.getBuilder().build(),
                (InternetExplorerOptions) t.getCapabilities());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyOpera(java.lang.Object)
     */
    @Override
    public RemoteWebDriver applyOpera(BuildDriverParam t) {
        return new OperaDriver((OperaDriverService) t.getBuilder().build(), (OperaOptions) t.getCapabilities());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applySafari(java.lang.Object)
     */
    @Override
    public RemoteWebDriver applySafari(BuildDriverParam t) {
        return new SafariDriver((SafariDriverService) t.getBuilder().build(), (SafariOptions) t.getCapabilities());
    }

}
