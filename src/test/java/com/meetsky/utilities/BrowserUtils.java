//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.meetsky.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
    public BrowserUtils() {
    }

    public static void sleep(int second) {
        second *= 1000;

        try {
            Thread.sleep((long)second);
        } catch (InterruptedException var2) {
        }

    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle) {
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();
        Iterator var3 = allWindowsHandles.iterator();

        while(var3.hasNext()) {
            String each = (String)var3.next();
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    public static void verifyURLContains(String expectedInURL) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    public static List<String> dropdownOptionsAsString(WebElement dropdownElement) {
        Select select = new Select(dropdownElement);
        List<WebElement> actualOptionsAsWebElement = select.getOptions();
        List<String> actualOptionsAsString = new ArrayList();
        Iterator var4 = actualOptionsAsWebElement.iterator();

        while(var4.hasNext()) {
            WebElement each = (WebElement)var4.next();
            actualOptionsAsString.add(each.getText());
        }

        return actualOptionsAsString;
    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {
        Iterator var2 = radioButtons.iterator();

        while(var2.hasNext()) {
            WebElement each = (WebElement)var2.next();
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                each.click();
            }
        }

    }

    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        Iterator var2 = Driver.getDriver().getWindowHandles().iterator();

        do {
            if (!var2.hasNext()) {
                Driver.getDriver().switchTo().window(origin);
                return;
            }

            String handle = (String)var2.next();
            Driver.getDriver().switchTo().window(handle);
        } while(!Driver.getDriver().getTitle().equals(targetTitle));

    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            WebElement el = (WebElement)var2.next();
            elemTexts.add(el.getText());
        }

        return elemTexts;
    }

    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList();
        Iterator var3 = elems.iterator();

        while(var3.hasNext()) {
            WebElement el = (WebElement)var3.next();
            elemTexts.add(el.getText());
        }

        return elemTexts;
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep((long)(seconds * 1000));
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), (long)timeToWaitInSec);
        return (WebElement)wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), (long)timeout);
        return (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), (long)timeout);
        return (WebElement)wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), (long)timeout);
        return (WebElement)wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState", new Object[0]).equals("complete");
            }
        };

        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable var4) {
            var4.printStackTrace();
        }

    }

    public static void verifyElementDisplayed(By by) {
        try {
            Assert.assertTrue("Element not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException var2) {
            var2.printStackTrace();
            Assert.fail("Element not found: " + by);
        }

    }

    public static void verifyElementNotDisplayed(By by) {
        try {
            Assert.assertFalse("Element should not be visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException var2) {
            var2.printStackTrace();
        }

    }

    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException var2) {
            var2.printStackTrace();
            Assert.fail("Element not found: " + element);
        }

    }

    public static void waitForStaleElement(WebElement element) {
        int y = 0;

        while(y <= 15) {
            if (y == 1) {
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException var6) {
                    ++y;

                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException var5) {
                        var5.printStackTrace();
                    }
                } catch (WebDriverException var7) {
                    ++y;

                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException var4) {
                        var4.printStackTrace();
                    }
                }
            }
        }

    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", new Object[]{element});
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();", new Object[]{element});
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", new Object[]{element});
    }

    public static void doubleClick(WebElement element) {
        (new Actions(Driver.getDriver())).doubleClick(element).build().perform();
    }

    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", new Object[]{element, attributeName, attributeValue});
    }

    public static void highlight(WebElement element) {
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", new Object[]{element});
        waitFor(1);
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", new Object[]{element});
    }

    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else if (element.isSelected()) {
            element.click();
        }

    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        int i = 0;

        while(i < timeout) {
            try {
                element.click();
                return;
            } catch (WebDriverException var4) {
                waitFor(1);
                ++i;
            }
        }

    }

    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        jse.executeScript(command, new Object[]{element});
    }

    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        jse.executeScript(command, new Object[0]);
    }

    public static void clickWithWait(By by, int attempts) {
        int counter = 0;

        while(counter < attempts) {
            try {
                clickWithJS(Driver.getDriver().findElement(by));
                break;
            } catch (WebDriverException var4) {
                var4.printStackTrace();
                ++counter;
                waitFor(1);
            }
        }

    }

    public static void waitForPresenceOfElement(By by, long time) {
        (new WebDriverWait(Driver.getDriver(), time)).until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
