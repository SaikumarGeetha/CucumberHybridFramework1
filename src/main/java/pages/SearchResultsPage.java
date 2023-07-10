package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class SearchResultsPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	public SearchResultsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validSearchText;
	
	@FindBy(xpath="//input[@value='Search']/following-sibling::p")
	private WebElement noProductMatching;
	
	public boolean getValidSearchText()
	{
		return elementUtils.displayStatusOfElement(validSearchText, 30);
		
	}
	
	public String noProductMatchingText()
	{
		return elementUtils.getTextFromElement(noProductMatching, 30);
		
	}

}
