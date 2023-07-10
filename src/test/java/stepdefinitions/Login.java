package stepdefinitions;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login 
{
	
	private AccountPage accountpage;
	private LoginPage loginpage;
	WebDriver driver;
	@Given("User navigates to login page")
	public void user_navigates_to_login_page()
	{
		driver=DriverFactory.getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.clickonMyAccount();
		loginpage= homepage.clickOnLogin();
	}

	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String validemail)
	{
		
		loginpage.enterEmailAddress(validemail);
		 
	}
	@When("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String validpassword) 
	{
		loginpage.enterPasswordAddress(validpassword);
		
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() 
	{
		accountpage=loginpage.clickOnLoginButton();
		
	}

	@Then("User should login successfully")
	public void User_should_login_successfully()
	{
		
		Assert.assertTrue(accountpage.verifyLoginSuccessfull());
	}
	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field()
	{
		
		loginpage.enterEmailAddress(CommonUtils.getEmailTimeStamp());
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidpassword) 
	{
		loginpage.enterPasswordAddress(invalidpassword);
		
	}
	@Then("User should get proper warning message like invalid credentials")
	public void user_should_get_proper_warning_message_like_invalid_credentials()
	{	
	    Assert.assertTrue(loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() 
	{
		loginpage.enterEmailAddress("");
		
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		loginpage.enterPasswordAddress("");
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys();
	}
	
}
