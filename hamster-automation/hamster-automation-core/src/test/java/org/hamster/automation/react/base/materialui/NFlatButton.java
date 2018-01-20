/**
 * 
 */
package org.hamster.automation.react.base.materialui;

import org.hamster.automation.react.base.ReactElement;
import org.openqa.selenium.WebElement;

/**
 *
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class NFlatButton extends ReactElement {

    /**
     * @param element
     */
    public NFlatButton(WebElement element) {
        super(element);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hamster.automation.react.base.ReactElement#getAnchorXPath()
     */
    @Override
    public String getAnchorXPath() {
        return "//*[@class='']";
    }

}
