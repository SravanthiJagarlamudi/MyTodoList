package com.inetBanking.testCases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.base.BaseClass;

public class TC_TodoAddItem_001 extends BaseClass {

	@Test(priority = 1, description = "to check if the page is navigated properly", groups = "regression")
	public void testNavigateToTodosPage() throws IOException {
		try {
			logger.info("navigate test started");
			driver.findElement(By.xpath("//div[text()='Labs']")).click();
			logger.info("Labs tab is clicked on");
			driver.findElement(By.linkText("Angular 2.0")).click();
			logger.info("Angular 2.0 link is clicked on");
			// Clicking on the Labs tab
			/*
			 * driver.findElement(By.xpath("//div[text()='Labs']")).click();
			 * logger.info("Labs tab is clicked on");
			 * driver.findElement(By.linkText("Angular 2.0")).click();
			 * logger.info("Angular 2.0 link is clicked on");
			 */
			String actualTitle = driver.getTitle();
			String expectedTitle = "Angular2 • TodoMVC";
			String actualCurrentUrl = driver.getCurrentUrl();
			String expectedCurrentUrl = "/examples/angular2";
			// Thread.sleep(3000);
			Assert.assertTrue(
					actualTitle.equalsIgnoreCase(expectedTitle) && actualCurrentUrl.contains(expectedCurrentUrl));
			logger.info("Test case is PASSED");
		} catch (Exception ex) {
			logger.error("Test case is FAILED. " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	// public void navigateToAngular(){
	// driver.findElement(By.xpath("//div[text()='Labs']")).click();
	// logger.info("Labs tab is clicked on");
	// driver.findElement(By.linkText("Angular 2.0")).click();
	// logger.info("Angular 2.0 link is clicked on");
	// }

	// Adding a TO-DO item
	@Test(priority = 2, dataProvider = "NewItemsList", description = "Adding a TO-DO item", groups = { "regression" })
	public void addItem(String newitem) throws Exception {
		try {
			boolean itemfound = false, flag1 = false, flag2 = false;
			logger.info("navigate test started");

			String actualTitle = driver.getTitle();
			String expectedTitle = "Angular2 • TodoMVC";
			String actualCurrentUrl = driver.getCurrentUrl();
			String expectedCurrentUrl = "/examples/angular2";
			if (actualTitle.equalsIgnoreCase(expectedTitle) && actualCurrentUrl.contains(expectedCurrentUrl)) {
				// Thread.sleep(3000);
				// Explicit wait until the I/P textBox is visible
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//input[@placeholder='What needs to be done?']")));

				// Display the items in the to-Do list
				List<WebElement> todosItemList = driver.findElements(By.xpath("//div[@class='view']//label"));

				int beforeAddingItems_Count = todosItemList.size();
				logger.info("Count of Lists before adding new item: " + beforeAddingItems_Count);

				WebElement elmt = driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']"));
				elmt.clear();
				elmt.sendKeys(newitem); // Type the item
				elmt.sendKeys(Keys.ENTER); // Click ENTER

				List<WebElement> todosItemLis1t = driver.findElements(By.xpath("//div[@class='view']//label"));
				int afterAddingItems_Count = todosItemLis1t.size();
				logger.info("Count of Lists After adding new item: " + afterAddingItems_Count);

				logger.info("newitem added is " + newitem);
				for (int i = 0; i < todosItemLis1t.size(); i++) {
					String listeditemname = todosItemLis1t.get(i).getText();
					logger.info("listeditemanme is " + listeditemname);

					if (listeditemname.equalsIgnoreCase(newitem)) {
						itemfound = true;
						break;
					}

				}

				if (itemfound) {
					logger.info("Newly aded List item is: " + newitem);
					flag1 = true;
				} else {
					logger.info("New Item added is not found in the list");
				}
				if (afterAddingItems_Count == beforeAddingItems_Count + 1) {
					flag2 = true;
				}

			}
			Assert.assertTrue(flag1 && flag2);
			logger.info("Test case is PASSED");
		} catch (Exception ex) {
			logger.error("Test case is FAILED. " + ex.getMessage());
			CaptureScreen(driver, "OpenBrowser");
			ex.printStackTrace();
		}

	}

	// Adding a TO-DO item
	@Test(enabled= false , priority = 3, dataProvider = "NewItemsListWithNull", description = "Adding a TO-DO item with NULL/empty values", groups = {
			"regression" })
	public void addItemwithNullorEmpty(String newitem) throws Exception {
		try {
			boolean itemfound = false, flag = false;
			logger.info("navigate test started");

			String actualTitle = driver.getTitle();
			String expectedTitle = "Angular2 • TodoMVC";
			String actualCurrentUrl = driver.getCurrentUrl();
			String expectedCurrentUrl = "/examples/angular2";
			if (actualTitle.equalsIgnoreCase(expectedTitle) && actualCurrentUrl.contains(expectedCurrentUrl)) {
				// Thread.sleep(3000);
				// Explicit wait until the I/P textBox is visible
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//input[@placeholder='What needs to be done?']")));

				// Display the items in the to-Do list
				List<WebElement> todosItemList = driver.findElements(By.xpath("//div[@class='view']//label"));

				int beforeAddingItems_Count = todosItemList.size();
				logger.info("Count of Lists before adding new item: " + beforeAddingItems_Count);

				WebElement elmt = driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']"));
				elmt.clear();
				elmt.sendKeys(newitem); // Type the item
				elmt.sendKeys(Keys.ENTER); // Click ENTER

				List<WebElement> todosItemLis1t = driver.findElements(By.xpath("//div[@class='view']//label"));
				int afterAddingItems_Count = todosItemLis1t.size();
				logger.info("Count of Lists After adding new item: " + afterAddingItems_Count);

				logger.info("newitem added is " + newitem);

				if (afterAddingItems_Count == beforeAddingItems_Count) {
					flag = true;
				}

			}
			Assert.assertTrue(flag);
			logger.info("Test case is PASSED");
		} catch (Exception ex) {
			logger.error("Test case is FAILED. " + ex.getMessage());
			CaptureScreen(driver, "OpenBrowser");
			ex.printStackTrace();
		}

	}

	// Adding a TO-DO item
	@Test(priority = 4, dataProvider = "NewItemsBeginswithSpaces", description = "Adding a TO-DO item with leading and trailing spaces", groups = {
			"regression" })
	public void addItemBeginswithSpaces(String newitem) throws Exception {
		try {
			boolean itemfound = false, flag1 = false, flag2 = false;
			logger.info("navigate test started");

			String actualTitle = driver.getTitle();
			String expectedTitle = "Angular2 • TodoMVC";
			String actualCurrentUrl = driver.getCurrentUrl();
			String expectedCurrentUrl = "/examples/angular2";
			if (actualTitle.equalsIgnoreCase(expectedTitle) && actualCurrentUrl.contains(expectedCurrentUrl)) {
				// Thread.sleep(3000);
				// Explicit wait until the I/P textBox is visible
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//input[@placeholder='What needs to be done?']")));

				// Display the items in the to-Do list
				List<WebElement> todosItemList = driver.findElements(By.xpath("//div[@class='view']//label"));

				int beforeAddingItems_Count = todosItemList.size();
				logger.info("Count of Lists before adding new item: " + beforeAddingItems_Count);

				WebElement elmt = driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']"));
				elmt.clear();
				elmt.sendKeys(newitem); // Type the item
				elmt.sendKeys(Keys.ENTER); // Click ENTER

				List<WebElement> todosItemLis1t = driver.findElements(By.xpath("//div[@class='view']//label"));
				int afterAddingItems_Count = todosItemLis1t.size();
				logger.info("Count of Lists After adding new item: " + afterAddingItems_Count);

				logger.info("newitem added is " + newitem);
				for (int i = 0; i < todosItemLis1t.size(); i++) {
					String listeditemname = todosItemLis1t.get(i).getText();
					logger.info("listeditemanme is " + listeditemname);
					newitem = newitem.trim();
					if (listeditemname.equalsIgnoreCase(newitem)) {
						itemfound = true;
						break;
					}

				}

				if (itemfound) {
					logger.info("Newly aded List item is: " + newitem);
					flag1 = true;
				} else {
					logger.info("New Item added is not found in the list");
				}
				if (afterAddingItems_Count == beforeAddingItems_Count + 1) {
					flag2 = true;
				}

			}
			Assert.assertTrue(flag1 && flag2);
			logger.info("Test case is PASSED");
		} catch (Exception ex) {
			logger.error("Test case is FAILED. " + ex.getMessage());
			CaptureScreen(driver, "OpenBrowser");
			ex.printStackTrace();
		}

	}

	@Test(priority = 5, dependsOnMethods = {
			"addItem" }, description = "to check if the footercount is updated", groups = "regression")
	public void checkFootercount() {

		int countofitemsadded = getItemData_DataProivder().length + NewItemsBeginswithSpaces_DataProvider().length;
		logger.info("count of dataprovider elemts is " + countofitemsadded);
		String footercount = driver.findElement(By.tagName("strong")).getText();
		logger.info("count of footer is " + footercount);
		//return (footercount.equals(String.valueOf(countofitemsadded)));
		 Assert.assertEquals(footercount, String.valueOf(countofitemsadded));

	}

	@DataProvider(name = "NewItemsList")
	public Object[][] getItemData_DataProivder() {

		return new Object[][] { { "Buy Bread" }, { "StandUP Meeting" }, { "Money^%^%" }, { "123Car" }, { "Laptop" },
				{ "Laptop123" }, { "Fix JIRA bugs" }, { "Buy Bread" } };

	}

	@DataProvider(name = "NewItemsListWithNull")
	public Object[][] getItemDataWithNull_DataProivder() {

		return new Object[][] { { null }, { " " } };

	}

	@DataProvider(name = "NewItemsBeginswithSpaces")
	public Object[][] NewItemsBeginswithSpaces_DataProvider() {

		return new Object[][] { { "  Mobile recharge" }, { "      Goto ATM" } };

	}

}