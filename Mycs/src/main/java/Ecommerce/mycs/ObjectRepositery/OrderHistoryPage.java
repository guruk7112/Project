package Ecommerce.mycs.ObjectRepositery;
/**
 * @author Gurup
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {

	WebDriver driver;
	public OrderHistoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='product-details.php?pid=16']")
	private WebElement OrderVerification;
	
	public WebElement getOrderVerification() {
		return OrderVerification;
	}
	
	
}
