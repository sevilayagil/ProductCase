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
    @FindBy(how = How.CLASS_NAME, using = "myBasket")
    public WebElement MyBasketIcon;
    @FindBy(how = How.ID, using = "searchData")
    public WebElement SearchBar;
    @FindBy(how = How.CLASS_NAME, using = "iconSearch")
    public WebElement SearchIcon;
    @FindBy(how = How.CSS, using = "div#contentListing > div > div > div:nth-of-type(2) > div:nth-of-type(4) > a:nth-of-type(2)")
    public WebElement SecondPage;
    @FindBy(how = How.CLASS_NAME, using = "column")
    public WebElement ProductArea;
    @FindBy(how = How.CLASS_NAME, using = "btnAddBasket")
    public WebElement AddToChartButton;
    @FindBy(how = How.CLASS_NAME, using = "newPrice")
    public WebElement PriceBeforeAddingtoCart;
    @FindBy(how = How.CLASS_NAME, using = "priceArea")
    public WebElement PriceAfterAddingtoCart;
    @FindBy(how = How.CLASS_NAME, using = "spinnerUp")
    public WebElement IncreasetoCart;
    @FindBy(how = How.CLASS_NAME, using = "spinnerField")
    public WebElement SpinnerField;
    @FindBy(how = How.CLASS_NAME, using = "removeProd")
    public WebElement RemoveProdut;



}
