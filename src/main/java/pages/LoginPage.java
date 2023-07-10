package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {
	
	private ElementUtils elementUtils;
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement  loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement warningMessage;

	public void enterEmailAddress(String validemail)
	{
		elementUtils.typeTextIntoElement(emailField, validemail, 30);
		
	}
	
	public void enterPasswordAddress(String validpassword)
	{
		elementUtils.typeTextIntoElement(passwordField, validpassword, 30);
		
	}
	
	public AccountPage clickOnLoginButton()
	{
		elementUtils.clickOnElement(loginButton, 30);
		return new AccountPage(driver);
	}
	public String getWarningMessageText() {
		
		return elementUtils.getTextFromElement(warningMessage, 30);
	   
	}
	
	
}
