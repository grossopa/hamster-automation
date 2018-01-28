/**
 * 
 */
package org.hamster.automation.driver;

import org.hamster.automation.driver.DriverType.DriverAction;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariOptions;

/**
 * returns simple option for each driver types.
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class DefaultGetOptionsAction implements DriverAction<Void, Capabilities> {

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyChrome(java.lang.Object)
     */
    @Override
    public Capabilities applyChrome(Void t) {
        return new ChromeOptions();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyEdge(java.lang.Object)
     */
    @Override
    public Capabilities applyEdge(Void t) {
        return new EdgeOptions();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyFirefox(java.lang.Object)
     */
    @Override
    public Capabilities applyFirefox(Void t) {
        return new FirefoxOptions();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyIE(java.lang.Object)
     */
    @Override
    public Capabilities applyIE(Void t) {
        return new InternetExplorerOptions();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applyOpera(java.lang.Object)
     */
    @Override
    public Capabilities applyOpera(Void t) {
        return new OperaOptions();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.driver.DriverType.DriverAction#applySafari(java.lang.Object)
     */
    @Override
    public Capabilities applySafari(Void t) {
        return new SafariOptions();
    }

}
