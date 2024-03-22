package objects.blog;

import objects.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.AutoTool;

import static utils.AutoTool.getSetupValue;

public class BlogScreen extends BaseScreen {
    @FindBy(how = How.NAME, using = "q")
    WebElement search;

    @FindBy(how = How.XPATH, using = "//*[@href=\"https://crediviva.com.pa/\"]")
    WebElement link_crediviva;


    @FindBy(how = How.XPATH, using = "//*[@href=\"https://crediviva.com.pa/blog/\" and @class=\"ekit-menu-nav-link menu-link\"]")
    WebElement link_blog;




    public void goWebPage () {
        AutoTool.getDriver().get(getSetupValue("urlWebPage"));
    }

    public void setClave(String clave){
        search.sendKeys(clave);
        search.sendKeys(Keys.RETURN);
    }

    public void clickLinkCrediviva(){
        link_crediviva.click();
    }

    public void clickLinkBlog(){
        link_blog.click();
    }


}
