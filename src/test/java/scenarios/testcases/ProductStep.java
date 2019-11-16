package scenarios.testcases;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageobjects.LoginProductPageObjects;
import scenarios.base.StepManager;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProductStep extends StepManager {
    private LoginProductPageObjects LoginProduct;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    private String PriceBeforeAddingToText;
    private String PriceAfterAddingToText;


    public ProductStep() throws Exception {
        super("product");
        LoginProduct = PageFactory.initElements(this.driver, LoginProductPageObjects.class);
    }

    @Given("^user is at landing page for the login process$")
    public void userIsAtLandingPageForTheLoginProcess() {
        getUrl();
    }

    @When("^user sign in website$")
    public void userSignInWebsite() throws IOException {
        elementClick(LoginProduct.SignButton);
        File src = new File("C:/Users/Sevo/Desktop/login.xlsx");
        FileInputStream fis = new FileInputStream(src);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        getElement(LoginProduct.Email).sendKeys(cell.getStringCellValue());
        Row row2 = sheet.getRow(0);
        Cell cell2 = row.getCell(1);
        getElement(LoginProduct.Password).sendKeys(cell2.getStringCellValue());
        elementClick(LoginProduct.LoginButton);
    }


    @Then("^user shows homepage$")
    public void userShowsHomepage() {
        getElement(LoginProduct.MyBasketIcon).isDisplayed();
    }

    @When("^user search products$")
    public void userSearchProducts() {
        getElement(LoginProduct.SearchBar).sendKeys("Bilgisayar");
        elementClick(LoginProduct.SearchIcon);
        PageScrolldown();
        elementClick(LoginProduct.SecondPage);
        waitElemntCssControl(LoginProduct.SecondPage, "class", "active");


    }

    @And("^user open second page and selects one product$")
    public void userOpenSecondPageAndSelectsOneProduct() {
        PageScrollup();
        List<WebElement> allElements = driver.findElements(By.className("column"));
        Random rand = new Random();
        int randInt = rand.nextInt(allElements.size());
        allElements.get(randInt).findElement(By.className("lazy")).click();
        PriceBeforeAddingToText = getElement(LoginProduct.PriceBeforeAddingtoCart).getText();

    }

    @Then("^user adds product to cart$")
    public void userAddsProductToCart() {
        elementClick(LoginProduct.AddToChartButton);
    }

    @And("^user controls accuracy of product price in basket$")
    public void userControlsAccuracyOfProductPriceInBasket() {
        PriceAfterAddingToText = getElement(LoginProduct.PriceAfterAddingtoCart).getText();
        Assert.assertNotEquals(PriceBeforeAddingToText, PriceAfterAddingToText);

    }

    @And("^user increases the product quantity and sees that the number of products is (\\d+)$")
    public void userIncreasesTheProductQuantityAndSeesThatTheNumberOfProductsIs(int arg0) {

    }

    @And("^user deletes the product from the basket and checks that the basket is empty\\.$")
    public void userDeletesTheProductFromTheBasketAndChecksThatTheBasketIsEmpty() {
    }

}
