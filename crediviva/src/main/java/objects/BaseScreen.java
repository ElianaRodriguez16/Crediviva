package objects;

import org.openqa.selenium.support.PageFactory;
import utils.AutoTool;

public class BaseScreen {
    public BaseScreen(){
        PageFactory.initElements(AutoTool.getDriver(), this);
    }
}
