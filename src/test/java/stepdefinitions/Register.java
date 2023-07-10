package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterAccountPage;
import utils.CommonUtils;

public class Register 
{
	WebDriver driver;

	
	private AccountSuccessPage accountSuccessPage;
	private RegisterAccountPage registerAccountPage;
	
	@Given("User navigates to register page")
	public void user_navigates_to_register_page() 
	{
		
		driver=DriverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickonMyAccount();
		registerAccountPage=homePage.clickOnRegister();
		
	    
	}
	
	@When("User enters the details into the below fields")
	public void User_enters_the_details_into_the_below_fields(DataTable dataTable) 
	{
		Map<String, String> data = dataTable.asMap(String.class,String.class);
		
		registerAccountPage.enterFirstName(data.get("firstname"));
		registerAccountPage.enterLastName(data.get("lastname"));
		registerAccountPage.enterEmail(CommonUtils.getEmailTimeStamp());
		registerAccountPage.enterTelephoneField(data.get("telephone"));
		registerAccountPage.enterPassword(data.get("password"));
		registerAccountPage.enterConfirmPassword(data.get("password"));
		
	}

	@When("User enters the details into the below fields with duplicate email address")
	public void User_enters_the_details_into_the_below_fields_with_duplicate_email_address(DataTable dataTable) 
	{
		Map<String, String> data = dataTable.asMap(String.class,String.class);
		
		registerAccountPage.enterFirstName(data.get("firstname"));
		registerAccountPage.enterLastName(data.get("lastname"));
		registerAccountPage.enterEmail(data.get("email"));
		registerAccountPage.enterTelephoneField(data.get("telephone"));
		registerAccountPage.enterPassword(data.get("password"));
		registerAccountPage.enterConfirmPassword(data.get("password"));
				
	}
	@And ("User clicks on continue button")
	public void User_clicks_on_continue_button()
	{
		accountSuccessPage=registerAccountPage.clickOnContinueButton();
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() 
	{
		registerAccountPage.clickOnPrivacyPolicy();
	}

	@Then("User account should get successfully created")
	public void user_account_should_get_successfully_created() 
	{
		
	    Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getAccountSuccessPageText());
	}

	@When("User selects yes for newsletter")
	public void user_selects_yes_for_newsletter() 
	{
		registerAccountPage.clickOnNewsLetter();
	}

	@Then("User should proper warning message email already exists")
	public void user_should_proper_warning_message_email_already_exists()
	{
		
	    Assert.assertTrue(registerAccountPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details any field")
	public void user_dont_enter_any_details_any_field() 
	{
		
	}
	@Then("User should get proper warning message")
	public void User_should_get_proper_warning_message()
	{
		
		 Assert.assertEquals("First Name must be between 1 and 32 characters!",registerAccountPage.firstNameWarningMessageText());
		 Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerAccountPage.lastNameWarningMessageText());
		 Assert.assertEquals("E-Mail Address does not appear to be valid!", registerAccountPage.emailWarningMessageText());
		 Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerAccountPage.telephoneWarningMessageText());
		 Assert.assertEquals("Password must be between 4 and 20 characters!",registerAccountPage.passwordWarningMessageText() );
	}
}
