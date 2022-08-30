package com.inetBanking.testCases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.base.BaseClass;

public class TC_Updateitem_002 extends BaseClass {
	//
	// /*@Test(priority = 1, description = "to check if the page is navigated
	// properly", groups = "regression")
	// public void testNavigateToTodosPage() throws IOException {
	// try {
	// logger.info("navigate test started");
	// driver.findElement(By.xpath("//div[text()='Labs']")).click();
	// logger.info("Labs tab is clicked on");
	// driver.findElement(By.linkText("Angular 2.0")).click();
	// logger.info("Angular 2.0 link is clicked on");
	// // Clicking on the Labs tab
	// /*
	// * driver.findElement(By.xpath("//div[text()='Labs']")).click();
	// * logger.info("Labs tab is clicked on");
	// * driver.findElement(By.linkText("Angular 2.0")).click();
	// * logger.info("Angular 2.0 link is clicked on");
	// */
	// String actualTitle = driver.getTitle();
	// String expectedTitle = "Angular2 • TodoMVC";
	// String actualCurrentUrl = driver.getCurrentUrl();
	// String expectedCurrentUrl = "/examples/angular2";
	// // Thread.sleep(3000);
	// Assert.assertTrue(
	// actualTitle.equalsIgnoreCase(expectedTitle) &&
	// actualCurrentUrl.contains(expectedCurrentUrl));
	// logger.info("Test case is PASSED");
	// } catch (Exception ex) {
	// logger.error("Test case is FAILED. " + ex.getMessage());
	// ex.printStackTrace();
	// }
	//
	// }
	//
	// public void navigateToAngular() {
	// driver.findElement(By.xpath("//div[text()='Labs']")).click();
	// logger.info("Labs tab is clicked on");
	// driver.findElement(By.linkText("Angular 2.0")).click();
	// logger.info("Angular 2.0 link is clicked on");
	// }*/

	@Test(priority = 6, dataProvider = "ItemtobeEdited", description = "Editing a TO-DO item", groups = {
			"regression" })
	public void editItem(String itemtobeedited, String itemafterediting) throws IOException {
		String itemtobeEdited = "WebElement";

		try {
			
			// Boolean txtenabled =
			// driver.findElement(By.xpath("(//label)[1]")).isEnabled();
			// WebElement e =
			WebElement e = driver
					.findElement(By.xpath("//*[@class='todo-list']//label[text()='" + itemtobeedited + "']"));
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='todo-list']//label[text()='"
			// + itemtobeedited + "']")));
			
			String itemValueBeforeUpdate = e.getText();

			logger.info("Before updating element is: " + itemValueBeforeUpdate);

			Actions act = new Actions(driver);
			act.moveToElement(e).doubleClick().build().perform();

			WebElement f = driver.findElement(By.xpath("//*[@class='todo-list']//input[@class='edit']"));

			// f.clear();
			// f.sendKeys(itemafterediting);
			f.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), itemafterediting);
			act.sendKeys(Keys.ENTER).perform();
			// act.sendKeys(Keys.ESCAPE).perform();
			// driver.findElement(By.xpath("//*[@class='todo-list']//input[@class='edit']")).sendKeys("3456");

			

			String itemValueAfterUpdate = e.getText();
			logger.info("After updateing element is: " + itemValueAfterUpdate);

			Assert.assertTrue(!itemValueBeforeUpdate.equals(itemValueAfterUpdate));
			logger.info("Test case is PASSED");
		} catch (Exception ex) {
			logger.error("Test case is FAILED. " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	@DataProvider(name = "ItemtobeEdited")
	public Object[][] getItemtobeEdited() {

		String editingData[][] = { { "Buy Bread", "Buy Bread at 8AM " },
				{ "StandUP Meeting", "StandUP Meeting at 10AM " }, { "Laptop", "Laptop Updated" } };
		return editingData;
	}

}
