package Ecommerce.mycs.generic.baseclass;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import Ecommerce.mycs.ObjectRepositery.LoginPage;
import Ecommerce.mycs.ObjectRepositery.MycartPage;
import Ecommerce.mycs.generic.DatabaseUtility.DatabaseUtility;
import Ecommerce.mycs.generic.FileUtility.ExcelUtility;
import Ecommerce.mycs.generic.FileUtility.JsonUtility;
import Ecommerce.mycs.generic.FileUtility.PropertiesUtility;
import Ecommerce.mycs.generic.WebDriverUtility.JavaUtility;
import Ecommerce.mycs.generic.WebDriverUtility.WebDriverUtility;
/**
 * @author Gurup
 */
public class BaseClass {
	public PropertiesUtility pLib = new PropertiesUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JsonUtility jLib = new JsonUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility JvLib = new JavaUtility();
	public DatabaseUtility dLib = new DatabaseUtility();
	public WebDriver driver;

	@BeforeSuite(groups= { "end to end","smoke","dataflow" })
	public void conigBS() throws SQLException {
		dLib.connectToDataBase();

	}
	//@Parameters("browser")
	@BeforeClass(groups= { "end to end","smoke","dataflow" })
	public void configBC() throws IOException {//public void configBC(String browse)
		String browser =System.getProperty("browser",pLib.getDataFromProperties("browser"));// String browser = browse;

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if(browser.equals("safari")) {
			driver=new SafariDriver();
		}else {
			driver = new ChromeDriver();
		}
		String url = pLib.getDataFromProperties("url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@BeforeMethod(groups= { "end to end","smoke","dataflow" })
	public void configBM() throws IOException, InterruptedException {
		String email = System.getProperty("email",pLib.getDataFromProperties("email"));
		String password =System.getProperty("password", pLib.getDataFromProperties("password"));

		LoginPage login = new LoginPage(driver);
		login.loginTOApplication(email, password);
	}

	@AfterMethod(groups= { "end to end","smoke","dataflow" })
	public void configAM() {
		MycartPage cart = new MycartPage(driver);
		cart.getLogoutLink().click();
	}

	@AfterClass(groups= { "end to end","smoke","dataflow" })
	public void configAC() {
		driver.quit();
	}

	@AfterSuite(groups= { "end to end","smoke","dataflow" })
	public void configAS() throws SQLException {
		dLib.closeConnections();
	}

}
