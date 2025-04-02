package Ecommerce.mycs.ObjectRepositery;
/**
 * @author Gurup
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminCategoryPage {

	WebDriver driver;
	public AdminCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="category")
	private WebElement categoryTf;
	
	@FindBy(name="submit")
	private WebElement createButton;
	
	public WebElement getCreateButton() {
		return createButton;
	}

	public WebElement getCategoryTf() {
		return categoryTf;
	}
	
}
