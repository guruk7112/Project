package com.Ecommerce.Mycs.UserModules;

/**
 * @author Gurup
 */

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ecommerce.mycs.ObjectRepositery.AdminLoginPage;
import Ecommerce.mycs.ObjectRepositery.ChangePasswordPage;
import Ecommerce.mycs.ObjectRepositery.HomePage;
import Ecommerce.mycs.ObjectRepositery.LoginPage;
import Ecommerce.mycs.ObjectRepositery.MyWishListPage;
import Ecommerce.mycs.ObjectRepositery.MycartPage;
import Ecommerce.mycs.ObjectRepositery.OrderHistoryPage;
import Ecommerce.mycs.ObjectRepositery.PaymentMethodPage;
import Ecommerce.mycs.ObjectRepositery.PendingOrdersPage;
import Ecommerce.mycs.ObjectRepositery.ProductCategoryPage;
import Ecommerce.mycs.generic.baseclass.BaseClass;
public class OrderTest extends BaseClass {
	/* user placing order */
	@Test(groups = "end to end",priority=4)
	public void placeOrderTest() throws Exception {
		String bilingAdress = eLib.getDataFromXlsx("entire", 1, 1);
		String bilingState = eLib.getDataFromXlsx("entire", 1, 3);
		String bilingCity = eLib.getDataFromXlsx("entire", 1, 5);
		String bilingPincode = eLib.getDataFromXlsx("entire", 1, 7);

		String shippingAdress = eLib.getDataFromXlsx("entire", 1, 2);
		String shippingState = eLib.getDataFromXlsx("entire", 1, 4);
		String shippingCity = eLib.getDataFromXlsx("entire", 1, 6);
		String shippingPincode = eLib.getDataFromXlsx("entire", 1, 8);

		MycartPage cart = new MycartPage(driver);
		cart.getBooksCategory().click();
		
		ProductCategoryPage category = new ProductCategoryPage(driver);
		category.getSellerAddToCart().click();
		wLib.getAllertAccept(driver);
		cart.increaseQuantity();
		cart.getUpdateShoppingCartButton().click();
		wLib.getAllertAccept(driver);
		cart.billingAdress(bilingAdress, bilingState, bilingCity, bilingPincode);
		wLib.getAllertAccept(driver);
		cart.shippingAdress(shippingAdress, shippingState, shippingCity, shippingPincode);
		wLib.getAllertAccept(driver);
		cart.getCheckoutButton().click();
		
		PaymentMethodPage pay = new PaymentMethodPage(driver);
		pay.getRadioDCcard().click();
		pay.getPaySubmitButton().click();
		
		OrderHistoryPage history = new OrderHistoryPage(driver);
		WebElement order = history.getOrderVerification();
		
		String ord = order.getText();
		System.out.println(ord);
		String book = eLib.getDataFromXlsx("verify", 1, 0);
		Assert.assertEquals(book, ord);
	}
	/* removing product from the Mycart page */

	@Test(groups = "smoke",priority=-1)
	public void removeProductTest() throws Exception {		
		HomePage home = new HomePage(driver);
		String product = eLib.getDataFromXlsx("verify", 1, 1);
		home.getSearchTextFiled().sendKeys(product, Keys.ENTER);
		
		ProductCategoryPage category = new ProductCategoryPage(driver);
		WebElement addButton = category.getAddToCart();
		wLib.getWebDriverWaitClickable(driver, 20, addButton);
		addButton.click();
		wLib.getAllertAccept(driver);
		
		MycartPage cart = new MycartPage(driver);
		cart.getRemoveCheckBoc().click();
		cart.getUpdateShoppingCartButton().click();
		wLib.getAllertAccept(driver);
		wLib.getAllertAccept(driver);
		String empty = cart.getEmpty().getText();
		Assert.assertFalse(empty.isEmpty());
		
	}

	/* verifying the product in wishlistPage */
	 
	@Test(groups = "dataflow",priority=1)
	public void productInWishListTest() throws Exception {
		HomePage home = new HomePage(driver);
		String product = eLib.getDataFromXlsx("verify", 2, 1);
		home.getSearchTextFiled().sendKeys(product, Keys.ENTER);
		
		ProductCategoryPage produc = new ProductCategoryPage(driver);
		produc.getWishList2().click();
		
		MyWishListPage wish = new MyWishListPage(driver);
		String productWish = wish.getwishVerify().getText();

		Assert.assertEquals(product, productWish);

	}
	/* placing order and verify in pending order*/

	@Test(retryAnalyzer = Ecommerce.mycs.generic.ListenereUtility.RetryAnalyzer.class, groups = "end to end",priority=2)
	public void orderPlacedInTodaysOrder() throws Exception {
		String product = eLib.getDataFromXlsx("verify", 2, 1);
		HomePage home = new HomePage(driver);
		home.getSearchTextFiled().sendKeys(product, Keys.ENTER);
		
		ProductCategoryPage category = new ProductCategoryPage(driver);
		category.getAddToCart().click();
		wLib.getAllertAccept(driver);
		
		MycartPage cart = new MycartPage(driver);
		cart.getCheckoutButton().click();
		
		PaymentMethodPage pay = new PaymentMethodPage(driver);
		pay.getRadioDCcard().click();
		pay.getPaySubmitButton().click();
		wLib.getMoveandClick(driver, cart.getLogoutLink());
		home.getAdminLoginLink().click();
		String adminun = pLib.getDataFromProperties("adminun");
		String adminpassword = pLib.getDataFromProperties("adminpassword");
		
		AdminLoginPage admin = new AdminLoginPage(driver);
		admin.adminLogin(adminun, adminpassword);
		
		ChangePasswordPage board = new ChangePasswordPage(driver);
		board.getOrderManagement().click();
		board.getTodaysOrder().click();
		
		PendingOrdersPage order = new PendingOrdersPage(driver);
		String user = eLib.getDataFromXlsx("verify", 1, 4);
		order.getOrderSearchTf().sendKeys(user);

		board.getAdminLogout().click();
		String url = pLib.getDataFromProperties("urlhome");
		driver.navigate().to(url);
		String email = pLib.getDataFromProperties("email");
		String password = pLib.getDataFromProperties("password");
		home.getUserLoginLink().click();
		LoginPage login=new LoginPage(driver);
		login.loginTOApplication(email, password);
		
		
	}

}
