package Ecommerce.mycs.ObjectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="product")
	private WebElement searchTextFiled;
	
	@FindBy(xpath="//a[@href='admin']")
	private WebElement adminLoginLink;
	
	@FindBy(xpath="//a[@href='login.php']")
	private WebElement userLoginLink;
	
	public WebElement getUserLoginLink() {
		return userLoginLink;
	}

	public WebElement getAdminLoginLink() {
		return adminLoginLink;
	}

	public WebElement getSearchTextFiled() {
		return searchTextFiled;
	}

}
