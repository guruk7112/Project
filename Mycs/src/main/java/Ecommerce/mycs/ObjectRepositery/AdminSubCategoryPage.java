package Ecommerce.mycs.ObjectRepositery;
/**
 * @author Gurup
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSubCategoryPage {

	WebDriver driver;
	public AdminSubCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@name='category']")
	private WebElement subcategoryTf;
	
	@FindBy(xpath="//input[contains(@class,'span8 tip')]")
	private WebElement subcatTf;
	
	public WebElement getSubcatTf() {
		return subcatTf;
	}
	public WebElement getSubcategoryTf() {
		return subcategoryTf;
	}
	
}
