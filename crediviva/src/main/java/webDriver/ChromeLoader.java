package webDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.AutoTool;

public class ChromeLoader implements DriverLoaderInterface{
    public void loadDriver() {
        String driverPath = "Drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        if(AutoTool.getDriver()==null||!AutoTool.getDriver().getClass().toString().equals("class org.openqa.selenium.chrome.ChromeDriver")) {
            AutoTool.setDriver(new ChromeDriver(options));
            System.out.println("Es chrome: "+AutoTool.getDriver().getClass().toString().equals("class org.openqa.selenium.chrome.ChromeDriver"));
        }
    }
}
