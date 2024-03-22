package test.blog;

import org.testng.Assert;
import org.testng.annotations.Test;
import steps.blog.BlogMethods;
import test.MainWebTest;
import utils.AutoTool;

public class NavigateTheBlogSuccessfully extends MainWebTest {
    @Test
    public void NavigateBlogOK(){
        BlogMethods blog = new BlogMethods();

        blog.navigateToBlog();

        Assert.assertTrue(AutoTool.getDriver().getPageSource().contains("BLOG CREDIVIVA"));

    }
}
