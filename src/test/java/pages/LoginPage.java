package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage {

    @FindBy(id="txtUsername")
    public WebElement userName;

    @FindBy(id="txtPassword")
    public WebElement password;

    @FindBy(id="btnLogin")
    public WebElement loginButton;

    //driver needs to be initialized through common methods
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
}
