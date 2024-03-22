package webDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import utils.AutoTool;

public class FirefoxLoader implements DriverLoaderInterface{
    public void loadDriver() {
        String driverPath = "Drivers\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);

        if(AutoTool.getDriver()==null||!AutoTool.getDriver().getClass().toString().equals("class org.openqa.selenium.firefox.FirefoxDriver")) {
            AutoTool.setDriver(new FirefoxDriver());
        }
    }
}
