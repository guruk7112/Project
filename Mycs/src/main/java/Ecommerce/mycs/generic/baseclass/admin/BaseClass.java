package Ecommerce.mycs.generic.baseclass.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Ecommerce.mycs.ObjectRepositery.AdminLoginPage;
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

	@BeforeSuite(groups = { "end to end", "smoke", "dataflow" })
	public void conigBS() throws SQLException {
		dLib.connectToDataBase();

	}

	@BeforeClass(groups = { "end to end", "smoke", "dataflow" })
	public void configBC() throws IOException {
		String browser = pLib.getDataFromProperties("browser");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		String url = pLib.getDataFromProperties("adminurl");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@BeforeMethod(groups = { "end to end", "smoke", "dataflow" })
	public void configBM() throws IOException {

		String adminun = pLib.getDataFromProperties("adminun");
		String adminpassword = pLib.getDataFromProperties("adminpassword");

		AdminLoginPage admin = new AdminLoginPage(driver);
		admin.adminLogin(adminun, adminpassword);
	}

	@AfterMethod(groups = { "end to end", "smoke", "dataflow" })
	public void configAM() {
		AdminLoginPage logout = new AdminLoginPage(driver);
		logout.getAdminLogoutCarot().click();
		logout.getAdminLogout().click();
	}

	@AfterClass(groups = { "end to end", "smoke", "dataflow" })
	public void configAC() {
		driver.quit();

	}

	@AfterSuite(groups = { "end to end", "smoke", "dataflow" })
	public void configAS() throws SQLException {
		dLib.closeConnections();
	}

}
