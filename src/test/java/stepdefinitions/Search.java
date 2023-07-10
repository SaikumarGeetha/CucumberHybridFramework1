package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {

	
	private SearchResultsPage searchPage;
	private HomePage homePage;
	WebDriver driver;
	@Given("User opens the application")
	public void user_opens_the_application()
	{
		
	    driver=DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validproduct) 
	{
		homePage=new HomePage(driver);
		homePage.searchForValidProduct(validproduct);
	    
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() 
	{
		searchPage=homePage.clickOnSearchButtonContinue();
	   
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() 
	{
		
		Assert.assertTrue(searchPage.getValidSearchText());
		
	    
	}

	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidproduct) 
	{
	
		homePage=new HomePage(driver);
	    homePage.searchForinValidProduct(invalidproduct);
		
	}

	@Then("User should get a message no product matching")
	public void user_should_get_a_message_no_product_matching() 
	{
		
	    Assert.assertEquals("There is no product that matches the search criteria.",searchPage.noProductMatchingText());
	}

	@When("User do not enter any text into search field")
	public void user_do_not_enter_any_text_into_search_field() 
	{
		
		homePage=new HomePage(driver);
	}
}
