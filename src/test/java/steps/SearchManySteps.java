package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import extentreports.ExtentManager;
import extentreports.ExtentTestManager;

public class SearchManySteps extends BaseSteps{
	
	protected Scenario sc;
	protected String scenarioName;
	@Before
	public void before(Scenario sc) {
		this.sc = sc;
		scenarioName = sc.getName();
		ExtentTestManager.startTest(scenarioName);
		ExtentTestManager.logInfo("Scenario started : "+scenarioName);
	}
	
	@After
	public void after(Scenario sc) {
		if(sc.isFailed()) {
			ExtentTestManager.logFail(sc.getName()+" : Failed");
			ExtentTestManager.addScreenShotsOnFailure();
		}
		else {
			ExtentTestManager.logPass(sc.getName()+" : Passed");
		}
		
		ExtentManager.getReporter().flush();
		stopWebDriver();
	}
	
	@Given("^launch browser '(.*?)'$")
	public void launch_browser_edge(String browserName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ExtentTestManager.logInfo("launching : "+browserName);
		startWebDriver(browserName);
		startPage();
	}

	@When("^user navigates to '(.*?)'$")
	public void user_navigates_to_https_google_com(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    ExtentTestManager.logInfo("Navigating to : "+url);
		navigate(url);
	}

	@Then("^user enters search from term '(.*?)'$")
	public void user_enters_search_from_term_HEllo(String query) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    ExtentTestManager.logInfo("Entering search term : "+query);
		gPage.enterSearch(query);
	}

	@Then("^Clicks on search button$")
	public void clicks_on_search_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ExtentTestManager.logInfo("clicking on search button");
		WebElement btn = gPage.searchBtn;
		wait.until(ExpectedConditions.elementToBeClickable(btn));
		gPage.clickBtn();
	    Assert.fail();
	    
	}

	
}
