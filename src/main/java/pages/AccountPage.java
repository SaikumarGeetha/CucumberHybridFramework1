package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class AccountPage {
	
	private ElementUtils elementUtils;
	
	WebDriver driver;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	
	@FindBy(linkText="Edit your account information")
	private WebElement editAccountPage;
	
	public boolean verifyLoginSuccessfull()
	{
		return elementUtils.displayStatusOfElement(editAccountPage, 30);
		//return editAccountPage.isDisplayed();
		
	}

}
