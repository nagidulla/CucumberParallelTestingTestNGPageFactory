package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage {
	
	@FindBy(name="q")
	public WebElement searchBox;
	
	@FindBy(name="btnK")
	public WebElement searchBtn;
	
	
	public void enterSearch(String query) {
		searchBox.sendKeys(query);
	}
	
	public void clickBtn() {
		searchBtn.click();
	}
	

}
