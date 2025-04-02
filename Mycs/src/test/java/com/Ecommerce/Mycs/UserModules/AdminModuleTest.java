package com.Ecommerce.Mycs.UserModules;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
/**
 * @author Gurup
 */
import org.testng.annotations.Test;

import Ecommerce.mycs.ObjectRepositery.AdminCategoryPage;
import Ecommerce.mycs.ObjectRepositery.AdminLoginPage;
import Ecommerce.mycs.ObjectRepositery.AdminSubCategoryPage;
import Ecommerce.mycs.ObjectRepositery.ChangePasswordPage;
import Ecommerce.mycs.ObjectRepositery.HomePage;
import Ecommerce.mycs.ObjectRepositery.InsertProductPage;
import Ecommerce.mycs.ObjectRepositery.LoginPage;
import Ecommerce.mycs.ObjectRepositery.ManageProductsPage;
import Ecommerce.mycs.ObjectRepositery.MycartPage;
import Ecommerce.mycs.ObjectRepositery.ProductCategoryPage;
import Ecommerce.mycs.generic.baseclass.admin.BaseClass;
/**
 * @author Gurup 
 */
public class AdminModuleTest extends BaseClass {

	/* admin can delete the product from manage product */
	@Test(groups = "smoke", priority = 1)
	public void adminDeleteProduct() throws Exception {

		ChangePasswordPage admin = new ChangePasswordPage(driver);	
		admin.getManageProduct().click();
		String productname = eLib.getDataFromXlsx("verify", 2, 1);
		
		ManageProductsPage product = new ManageProductsPage(driver);
		product.getManageTf().sendKeys(productname);
		product.getDeleteProduct().click();
		wLib.getAllertDismiss(driver);

	}

	/* create and verify the category present in sub category */

	@Test(retryAnalyzer = Ecommerce.mycs.generic.ListenereUtility.RetryAnalyzer.class, groups = "dataflow", priority = 2)
	public void adminCategoryTest() throws Exception {
		
		ChangePasswordPage dashboard = new ChangePasswordPage(driver);
		dashboard.getCreateCategory().click();

		String categoryName = eLib.getDataFromXlsx("verify", 1, 2);		
		AdminCategoryPage category = new AdminCategoryPage(driver);
		category.getCategoryTf().sendKeys(categoryName);
		category.getCreateButton().click();		
		dashboard.getSubcategoryLink().click();
		
		AdminSubCategoryPage subcat = new AdminSubCategoryPage(driver);
		WebElement subcatDD = subcat.getSubcategoryTf();
		
		int increase = (int) eLib.getDataFromXlsxNumberic("entire", 4, 0);
		wLib.getSelectByIndex(subcatDD, increase);
		
		String sub = eLib.getDataFromXlsx("verify", 1, 3);
		subcat.getSubcatTf().sendKeys(sub);
		category.getCreateButton().click();
	}

	@Test(groups = "end to end", priority = 3)
	public void insertProductTest() throws Exception {
		String name = eLib.getDataFromXlsx("product", 1, 0);
		String company = eLib.getDataFromXlsx("product", 2, 0);
		String privcebd = eLib.getDataFromXlsx("product", 3, 0);
		String price = eLib.getDataFromXlsx("product", 4, 0);
		String shipping = eLib.getDataFromXlsx("product", 5, 0);
		
		ChangePasswordPage dashboard = new ChangePasswordPage(driver);
		dashboard.getInsertProduct().click();
		
		AdminSubCategoryPage subcat = new AdminSubCategoryPage(driver);
		WebElement subcatDD = subcat.getSubcategoryTf();
		int increase = (int) eLib.getDataFromXlsxNumberic("entire", 4, 0);
		wLib.getSelectByIndex(subcatDD, increase);
		
		InsertProductPage insert = new InsertProductPage(driver);
		wLib.getSelectByIndex(insert.getSub1(), 0);

		insert.insertProduct(name, company, privcebd, price, shipping);
		String homep = pLib.getDataFromProperties("urlhome");
		driver.navigate().to(homep);
		
		HomePage home = new HomePage(driver);
		String productname = eLib.getDataFromXlsx("verify", 1, 1);
		home.getSearchTextFiled().sendKeys(productname, Keys.ENTER);
		
		ProductCategoryPage category = new ProductCategoryPage(driver);
		String productB = category.getProductVerify().getText();
		Assert.assertEquals(productB, productname);
		String admin = pLib.getDataFromProperties("admindb");
		driver.navigate().to(admin);

	}

	@Test(groups = "end to end",priority=4)
	public void modifyProductAndaddToCartTest() throws Exception {
		ChangePasswordPage dashboard = new ChangePasswordPage(driver);
		dashboard.getManageProduct().click();
		
		ManageProductsPage product = new ManageProductsPage(driver);
		String productm = eLib.getDataFromXlsx("verify", 2, 1);
		product.getManageTf().sendKeys(productm);
		product.getEdit3().click();
		
		InsertProductPage insert = new InsertProductPage(driver);
		String beforeDiscount = eLib.getDataFromXlsx("product", 6, 0);
		insert.getProductPricebd().sendKeys(beforeDiscount);
		String home = pLib.getDataFromProperties("url");
		driver.get(home);
		String email = pLib.getDataFromProperties("email");
		String password = pLib.getDataFromProperties("password");
		
		LoginPage user = new LoginPage(driver);
		user.loginTOApplication(email, password);
		
		HomePage search = new HomePage(driver);
		String produ = eLib.getDataFromXlsx("verify", 2, 1);
		search.getSearchTextFiled().sendKeys(produ, Keys.ENTER);
		
		ProductCategoryPage category = new ProductCategoryPage(driver);
		category.getAddToCart().click();
		driver.switchTo().alert().accept();
		category.getCartBox().click();
		category.getAddToCartBoxButton().click();
		
		String producntName = category.getVerifyProductName().getText();
		String actual = eLib.getDataFromXlsx("verify", 2, 1);
		Assert.assertEquals(producntName, actual);
		
		MycartPage cart = new MycartPage(driver);
		cart.getLogoutLink().click();
		

	}

}
