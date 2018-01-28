package org.hamster.automation.driver;

import org.hamster.automation.driver.DriverType.DriverAction;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.remote.service.DriverService.Builder;
import org.openqa.selenium.safari.SafariDriverService;

/**
 * Get the corresponding {@link DriverService.Builder} by Driver type.
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class GetDriverBuilderAction implements DriverAction<Void, Builder<?, ?>> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyChrome(java.lang.Object)
     */
    @Override
    public Builder<?, ?> applyChrome(Void t) {
        return new ChromeDriverService.Builder();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyEdge(java.lang.Object)
     */
    @Override
    public Builder<?, ?> applyEdge(Void t) {
        return new EdgeDriverService.Builder();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyFirefox(java.lang.Object)
     */
    @Override
    public Builder<?, ?> applyFirefox(Void t) {
        return new GeckoDriverService.Builder();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyIE(java.lang.Object)
     */
    @Override
    public Builder<?, ?> applyIE(Void t) {
        return new InternetExplorerDriverService.Builder();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyOpera(java.lang.Object)
     */
    @Override
    public Builder<?, ?> applyOpera(Void t) {
        return new OperaDriverService.Builder();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applySafari(java.lang.Object)
     */
    @Override
    public Builder<?, ?> applySafari(Void t) {
        return new SafariDriverService.Builder();
    }

}