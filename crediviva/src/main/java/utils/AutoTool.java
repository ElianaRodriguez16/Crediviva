package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class AutoTool {
    public static WebDriver webDriver = null;
    static Wait<WebDriver> wait;
    private static Properties properties=null;

    /**Sets the kind of WebDriver to use in a ThreadLocal object and initialize a Wait object in a generic way. This is a setup method and should be called from the loader classes, like ChromeLoader.
     * @param selectedDriver Kind of web driver to be used.
     */
    public static void setDriver(WebDriver selectedDriver) {
        webDriver = selectedDriver;
        setFluentWait();
    }

    private static void setFluentWait() {
        wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(1000))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
    }

    public static void waitForElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**Returns the WebDriver object stored in the ThreadLocal object.
     * @return A WebDriver object.
     */
    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void waitPageLoad() {
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
    }

    public static void closeDriver() {
        AutoTool.getDriver().close();
    }

    /**Loads the contents of a file into a Properties object, allowing easier later access to it's contents.
     * The file could be used to store configuration parameters for the tests.
     * The file's path in this case is: "src/test/resources/config.properties" and its contents are arranged in a "Key-Value" manner.
     */
    public static void loadSetupValues() {
        try {
            InputStream input = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(input);
        } catch (Exception exp) {
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**Returns a value contained in a Properties object.
     * @param value The Key parameter of the requested Value.
     * @return The Value stored for the requested Key.
     */
    public static String getSetupValue(String value) {
        return properties.getProperty(value);
    }
}
