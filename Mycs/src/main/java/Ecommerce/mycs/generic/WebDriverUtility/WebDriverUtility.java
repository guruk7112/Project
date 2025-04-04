package Ecommerce.mycs.generic.WebDriverUtility;
/**
 * @author Gurup
 */
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/* Javascript Executor */
	public void getJsclick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void getJsSendKeys(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Hello World';", element);
	}

	public void getJsScrollElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void getJsScrollAmount(WebDriver driver, int y) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0, " + y + ");"); // Scroll down by 500 pixels
	}

	public void getJsAlert(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('Hello, this is an alert!');");
	}

	public void getJsRefresh(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0);");
	}

	/* Actions class mouse Actions */

	public void getMovetoElement(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void getContextClick(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void getDoubleClick(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void getDragAndDrop(WebElement src, WebElement target, WebDriver driver) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, target).perform();
	}

	public void getScrollByamount(int xvertical, int yvertical, WebDriver driver) {
		Actions action = new Actions(driver);
		action.scrollByAmount(xvertical, yvertical).perform();
	}

	public void getScrollToElement(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.scrollToElement(element).perform();
	}

	public void getClickAnHold(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.clickAndHold(element).perform();
	}

	/* Syncronization */
	public void getWebDriverWaitClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void getWebDriverWaitVisible(WebDriver driver, int seconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void getFluentWaitClickable(WebDriver driver, int pooling, int withtimeout, WebElement element) {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(pooling));
		wait.withTimeout(Duration.ofSeconds(withtimeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void getFluentWaitVisible(WebDriver driver, int pooling, int withtimeout, WebElement element) {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(pooling));
		wait.withTimeout(Duration.ofSeconds(withtimeout));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/* TakesScreenShot */
	public void getTakesScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\eclipse\\entire\\Screenshots");
		FileHandler.copy(src, des);
	}

	public void getTakesScreenshotElement(WebDriver element) throws IOException {
		File src = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\eclipse\\entire\\Screenshots");
		FileHandler.copy(src, des);
	}

	/* java scritp executor */
	public void getJavaScriptExecutorClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0],click();" + element);
	}

	/* window handles */
	public void getWindowHandles(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		for (String win : child) {
			driver.switchTo().window(win);
		}
	}

	public void getAllertAccept(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		Alert al = driver.switchTo().alert();
		
		al.accept();
	}

	public void getAllertDismiss(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}
	public void getSelectByIndex(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void getMoveandClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).doubleClick().perform();
	}
}
