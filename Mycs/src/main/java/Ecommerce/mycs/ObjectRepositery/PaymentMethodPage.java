package Ecommerce.mycs.ObjectRepositery;
/**
 * @author Gurup
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodPage {
	WebDriver driver;

	public PaymentMethodPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[contains(@value,'Debit / Credit card')]")
	private WebElement radioDCcard;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement paySubmitButton;
	
	public WebElement getPaySubmitButton() {
		return paySubmitButton;
	}
	
	public WebElement getRadioDCcard() {
		return radioDCcard;
	}
}
