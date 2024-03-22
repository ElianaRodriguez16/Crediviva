package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import utils.AutoTool;
import webDriver.DriverFactory;

import static utils.AutoTool.loadSetupValues;

public class MainWebTest {

    @BeforeSuite
    public void config(){
        loadSetupValues();
    }

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        DriverFactory.setDriver(browser);
    }

    @AfterSuite
    public void cleanUp(){
        AutoTool.closeDriver();
    }
}
