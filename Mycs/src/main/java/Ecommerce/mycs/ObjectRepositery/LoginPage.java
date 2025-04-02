package Ecommerce.mycs.ObjectRepositery;
/**
 * @author Gurup
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.mycs.generic.baseclass.BaseClass;

public class LoginPage extends BaseClass{
	
WebDriver driver;
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(name="email")
private WebElement loginEmail;

@FindBy(id="exampleInputPassword1")
private WebElement loginPassword;

@FindBy(name="login")
private WebElement loginButton;

@FindBy(xpath="//a[contains(text(),'Admin Login')]")
private WebElement adminLoginLink;

public WebElement getadminLoginLink() {
	return adminLoginLink;
}

public WebElement getLoginEmail() {
	return loginEmail;
}

public WebElement getLoginPassword() {
	return loginPassword;
}

public WebElement getLoginButton() {
	
	return loginButton;
}
/**
 * 
 * @param email
 * @param password
 * @throws InterruptedException
 */
public void loginTOApplication(String email,String password) throws InterruptedException {
	loginEmail.sendKeys(email);
	wLib.getJsScrollAmount(driver, 100);
	loginPassword.sendKeys(password);
	loginButton.click();
}






}
