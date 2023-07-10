package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;



public class HomePage {
	
	private ElementUtils elementUtils;

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement selectLoginOption;
	
	@FindBy(linkText="Register")
	private WebElement selectingRegister;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchValidProduct;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchinValidProduct;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchContinueButton;
	
	public void clickonMyAccount()
	{
		elementUtils.clickOnElement(myAccountDropMenu, 30);
	}
	public LoginPage clickOnLogin()
	{
		elementUtils.clickOnElement(selectLoginOption, 30);
		return new LoginPage(driver);
	}
	public RegisterAccountPage clickOnRegister()
	{
		elementUtils.clickOnElement(selectingRegister, 30);
		return new RegisterAccountPage(driver);
	}
	public void searchForValidProduct(String validproduct)
	{
		elementUtils.typeTextIntoElement(searchValidProduct, validproduct, 30);
		
	}
	public SearchResultsPage clickOnSearchButtonContinue()
	{
		elementUtils.clickOnElement(searchContinueButton, 30);
		return new SearchResultsPage(driver);
	}
	public void searchForinValidProduct(String invalidproduct)
	{
		elementUtils.typeTextIntoElement(searchinValidProduct, invalidproduct, 30);
		
	}
	
	
}
