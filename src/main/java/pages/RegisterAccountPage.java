package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class RegisterAccountPage {
	
	private ElementUtils elementUtils;
	WebDriver driver;
	
	public RegisterAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstnamefield;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastnamefield;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailfield;
	
	@FindBy(xpath="//input[@name='telephone']")
	private WebElement telephoneField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordfield;
	
	@FindBy(xpath="//input[@name='confirm']")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continuebutton;
	
	
	@FindBy(xpath="//input[@name='newsletter'][@value=1]")
	private WebElement newsletter;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//input[@name='firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath="//input[@name='lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath="//input[@type='email']/following-sibling::div")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath="//input[@name='telephone']/following-sibling::div")
	private WebElement telephoneWarningMessage;
	
	@FindBy(xpath="//input[@name='password']/following-sibling::div")
	public WebElement passwordWarningMessage;
	
	public void enterFirstName(String firstNameText)
	{
		elementUtils.typeTextIntoElement(firstnamefield, firstNameText, 30);
		
	}

	public void enterLastName(String lastNameText)
	{
		elementUtils.typeTextIntoElement(lastnamefield, lastNameText, 30);
	}
	
	public void enterEmail(String emailText)
	{
		elementUtils.typeTextIntoElement(emailfield, emailText, 30);
		
	}
	public void enterTelephoneField(String telephone)
	{
		elementUtils.typeTextIntoElement(telephoneField, telephone, 30);
	}
	public void enterPassword(String password)
	{
		elementUtils.typeTextIntoElement(passwordfield, password, 30);
		
	}
	public void enterConfirmPassword(String confirmPassword)
	{
		elementUtils.typeTextIntoElement(confirmPasswordField, confirmPassword, 30);
		
	}
	public void clickOnPrivacyPolicy()
	{
		elementUtils.clickOnElement(privacyPolicy, 30);
		
	}
	public AccountSuccessPage clickOnContinueButton()
	{
		elementUtils.clickOnElement(continuebutton, 30);
		
		return new AccountSuccessPage(driver);
	}
	public void clickOnNewsLetter()
	{
		elementUtils.clickOnElement(newsletter, 30);
	}
	public String getWarningMessageText()
	{
		return elementUtils.getTextFromElement(warningMessage, 30);
		
	}
	public String firstNameWarningMessageText()
	{
		return elementUtils.getTextFromElement(firstNameWarningMessage, 30);
		
	}
	public String lastNameWarningMessageText()
	{
		return elementUtils.getTextFromElement(lastNameWarningMessage, 30);
		
	}
	public String emailWarningMessageText()
	{
		return elementUtils.getTextFromElement(emailWarningMessage, 30);
		
	}
	public String telephoneWarningMessageText()
	{
		return elementUtils.getTextFromElement(telephoneWarningMessage, 30);
		
	}
	public String passwordWarningMessageText()
	{
		return elementUtils.getTextFromElement(passwordWarningMessage, 30);
		
	}
}
