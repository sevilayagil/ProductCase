package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginProductPageObjects {
    @FindBy(how = How.CLASS_NAME, using = "btnSignIn")
    public WebElement SignButton;
    @FindBy(how = How.ID, using = "email")
    public WebElement Email;
    @FindBy(how = How.ID, using = "password")
    public WebElement Password;
    @FindBy(how = How.ID, using = "loginButton")
    public WebElement LoginButton;

}
