/**
 * 
 */
package org.hamster.automation.react.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 *
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public abstract class ReactElement implements WebElement {
    
    private final WebElement element;
    
    public ReactElement(WebElement element) {
        this.element = element;
    }
    
    public abstract String getAnchorXPath();
    
    public static String getXpath(String id) {
        return "//*[@data-ntype=\'" + id + "\']";
    }

    /**
     * @param target
     * @return
     * @throws WebDriverException
     * @see org.openqa.selenium.TakesScreenshot#getScreenshotAs(org.openqa.selenium.OutputType)
     */
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return element.getScreenshotAs(target);
    }

    /**
     * 
     * @see org.openqa.selenium.WebElement#click()
     */
    public void click() {
        element.click();
    }

    /**
     * 
     * @see org.openqa.selenium.WebElement#submit()
     */
    public void submit() {
        element.submit();
    }

    /**
     * @param keysToSend
     * @see org.openqa.selenium.WebElement#sendKeys(java.lang.CharSequence[])
     */
    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }

    /**
     * 
     * @see org.openqa.selenium.WebElement#clear()
     */
    public void clear() {
        element.clear();
    }

    /**
     * @return
     * @see org.openqa.selenium.WebElement#getTagName()
     */
    public String getTagName() {
        return element.getTagName();
    }

    /**
     * @param name
     * @return
     * @see org.openqa.selenium.WebElement#getAttribute(java.lang.String)
     */
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    /**
     * @return
     * @see org.openqa.selenium.WebElement#isSelected()
     */
    public boolean isSelected() {
        return element.isSelected();
    }

    /**
     * @return
     * @see org.openqa.selenium.WebElement#isEnabled()
     */
    public boolean isEnabled() {
        return element.isEnabled();
    }

    /**
     * @return
     * @see org.openqa.selenium.WebElement#getText()
     */
    public String getText() {
        return element.getText();
    }

    /**
     * @param by
     * @return
     * @see org.openqa.selenium.WebElement#findElements(org.openqa.selenium.By)
     */
    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    /**
     * @param by
     * @return
     * @see org.openqa.selenium.WebElement#findElement(org.openqa.selenium.By)
     */
    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    /**
     * @return
     * @see org.openqa.selenium.WebElement#isDisplayed()
     */
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    /**
     * @return
     * @see org.openqa.selenium.WebElement#getLocation()
     */
    public Point getLocation() {
        return element.getLocation();
    }

    /**
     * @return
     * @see org.openqa.selenium.WebElement#getSize()
     */
    public Dimension getSize() {
        return element.getSize();
    }

    /**
     * @return
     * @see org.openqa.selenium.WebElement#getRect()
     */
    public Rectangle getRect() {
        return element.getRect();
    }

    /**
     * @param propertyName
     * @return
     * @see org.openqa.selenium.WebElement#getCssValue(java.lang.String)
     */
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }
    
    

}
