package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver=null;
	public ElementUtils(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void clickOnElement(WebElement element,long durationInSeconds)
	{
		WebElement webElement =waitForElement(element, durationInSeconds);
		webElement.click();
	}
	
	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds)
	{
		
		WebElement webElement =waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds)
	{
		WebElement webElement=null;
		
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement =wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return webElement;
	}
	public void selectOptionInDropDown(WebElement element,String dropDpwnOptionText,long durationInSeconds)
	{
		WebElement webElement=waitForElement(element,durationInSeconds);
		
		Select select=new Select(element);
		select.selectByVisibleText(dropDpwnOptionText);
	}
	public void acceptAlert(long dirationInSeconds)
	{
		Alert alert = waitForAlert(dirationInSeconds);
		alert.accept();
	}
	public void dismissAlert(long durationInSeconds)
	{
		Alert alert=waitForAlert(durationInSeconds);
		alert.dismiss();
		
	}
	public Alert waitForAlert(long dirationInSeconds)
	{
		
		Alert alert=null;
		try 
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(dirationInSeconds));
			alert=wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		
		return alert;
		
	}
	public void mouseHoverElement(WebElement element, long duartionInSeconds)
	{
		
		WebElement webElement=visibilityOfElement(element,duartionInSeconds);
		Actions actions=new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}
	public WebElement visibilityOfElement(WebElement element, long duartionInSeconds)
	{
		WebElement webElement=null;
		try 
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duartionInSeconds));
			 webElement=wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
		
	}
	public void javaScriptClick(WebElement element, long duartionInSeconds)
	{
		WebElement webElement=visibilityOfElement(element,duartionInSeconds);
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();", webElement);
		
	}
	public void javaScriptType(WebElement element, long duartionInSeconds,String textToBeTyped)
	{
		WebElement webElement=visibilityOfElement(element,duartionInSeconds);
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textToBeTyped+"';", webElement);
	}
	public String getTextFromElement(WebElement element, long duartionInSeconds)
	{
		WebElement webElement =waitForElement(element,duartionInSeconds);
		return webElement.getText();
	}
	public boolean displayStatusOfElement(WebElement element, long duartionInSeconds)
	{
		try
		{
		WebElement webElement=visibilityOfElement(element,duartionInSeconds);
		return webElement.isDisplayed();
		}
		catch(Throwable e)
		{
			return false;
			
		}
	}
}
