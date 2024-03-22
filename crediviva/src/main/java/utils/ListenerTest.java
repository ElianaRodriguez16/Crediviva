package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static utils.AutoTool.getDriver;

public class ListenerTest implements ITestListener {
    @Override
    public void onTestFailure(ITestResult tr) {
        // TODO Auto-generated method stub
        System.out.println("The name of the testcase failed is :"+tr.getName());
        takeScreenshot(tr.getName());
    }

    @Override
    public void onTestSuccess(ITestResult tr) {

        System.out.println("The name of the testcase success is :"+tr.getName());
        takeScreenshot(tr.getName());
    }

    private void takeScreenshot(String testName) {
        try {

            byte[] screenshot = ((org.openqa.selenium.TakesScreenshot) getDriver()).getScreenshotAs(org.openqa.selenium.OutputType.BYTES);

            String screenshotPath = "./Screenshots/" + testName + ".png";
            Files.write(Paths.get(screenshotPath), screenshot);

            Reporter.log("<br><img src='" + screenshotPath + "' height='400' width='600'/><br>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
