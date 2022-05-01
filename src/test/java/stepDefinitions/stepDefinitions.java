package stepDefinitions;

//import org.apache.logging.log4j.core.util.Assert;
//import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pageObject.LoginPage;
import pageObject.portalHomePage;
import resources.base;

public class stepDefinitions extends base{
@Given("^Initialize the browser with chrome$")
public void initialize_the_browser_with_chrome() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	 driver =initializeDriver();
}

@Given("^Navigate to \"([^\"]*)\" site$")
public void navigate_to_site(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.get(arg1);
}

@Given("^Click on Login link in home page$")
public void click_on_Login_link_in_home_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	pageObject.LandingPage l=new pageObject.LandingPage(driver);
	if(l.getPopUpSize()>0)
	{
		l.getPopUp().click();
	}
((WebElement) l.getLogin()).click();
}

@When("^Click enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
public void click_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	LoginPage lp=new LoginPage(driver);
	lp.getEmail().sendKeys(arg1);
	lp.getPassword().sendKeys(arg2);

	
	
	((WebElement) lp.getLogin()).click();
}

@Then("^Verify that user in successfully logged in$")
public void verify_that_user_in_successfully_logged_in() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   portalHomePage p=new portalHomePage(driver);
   Assert.assertTrue((((WebElement) p.getSearchBox()).isDisplayed()));

}
@And("^close browsers$")
public void close_browser() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   driver.quit();
}
}
