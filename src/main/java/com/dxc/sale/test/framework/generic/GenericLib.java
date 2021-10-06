package com.dxc.sale.test.framework.generic;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class GenericLib {

	final static Logger log = LogManager.getLogger(GenericLib.class);
	
	private ExtentTest test;
	private WebDriver driver;

	public GenericLib(WebDriver driver,ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public void launchApplication(String url) throws Exception {
		// Launch Browser
		try {
			test.log(Status.INFO, "launch Application");
			driver.get(url);
			//driver.manage().window().maximize();
		} catch (Exception e) {
			test.log(Status.INFO, "launch Application");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("LaunchAPP")));
			log.error("Error in launchApplication:",e);

		}
	}

	// Enter Value in edit field
	public void inputText(By by, String elementname, String data) throws Exception {
		try {
			test.log(Status.INFO, "Enter " + data + " in" + elementname + "field");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				//Actions actions = new Actions(driver);
				//actions.moveToElement(e1).click().build().perform();
				executor.executeScript("arguments[0].click();", e1);
				Thread.sleep(2000);
				e1.clear();
				
				e1.sendKeys(data);
				test.log(Status.PASS, data + " entered in " + elementname + " field Successfully.");
			}
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to enter " + data + " in" + elementname + " field.");
			log.error("Error in inputText:",e);
		}
	}

	
	public void inputTextInt(By by, String elementname, int data) throws Exception {
		try {
			test.log(Status.INFO, "Enter " + data + " in" + elementname + "field");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				//Actions actions = new Actions(driver);
				//actions.moveToElement(e1).click().build().perform();
				executor.executeScript("arguments[0].click();", e1);
				Thread.sleep(2000);
				e1.clear();
				Integer i = data;
				String j=i.toString();
				e1.sendKeys(j);
				test.log(Status.PASS, data + " entered in " + elementname + " field Successfully.");
			}
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to enter " + data + " in" + elementname + " field.");
			log.error("Error in inputText:",e);
		}
	}

	// Click Button
	public void clickButton(By by, String elementname) throws IOException {
		// Click Button
		try {
			test.log(Status.INFO, "Click on" + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
//				Actions actions = new Actions(driver);
//				actions.moveToElement(e1).click().build().perform();
				js.executeScript("arguments[0].click();", e1);
				test.log(Status.PASS, "Clicked on  " + elementname + " Successfully.");
			}
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to Click on " + elementname + ".");
			log.error("Error in clickbutton:",e);
		}
	}

	
	
	// Click Button
		public void clickAlert(By by, String elementname) throws IOException {
			// Click Button
			try {
				test.log(Status.INFO, "Click on" + elementname);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
				wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				WebElement e1 = driver.findElement(by);
				if (e1.isDisplayed()) {
//					Actions actions = new Actions(driver);
//					actions.moveToElement(e1).click().build().perform();
					
					js.executeScript("arguments[0].click();", e1);
					boolean foundAlert = false;
					   // WebDriverWait wait = new WebDriverWait(driver, 10);
					    try {
					    	driver.switchTo().alert().accept();
					    	driver.switchTo().alert().accept();
					        foundAlert = true;
					    } catch (NoAlertPresentException e) {
					        foundAlert = false;
					    }
					    System.out.println(foundAlert);
					
					test.log(Status.PASS, "Clicked on  " + elementname + " Successfully.");
				
				}
			} catch (Exception e) {
				//test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				test.log(Status.FAIL, "Failed to Click on " + elementname + ".");
				log.error("Error in clickAlert:");
			}
		}
	// Click Link
	public void clickLink(By by, String elementname) throws IOException {
		try {
			test.log(Status.INFO, "Click on" + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
//				Actions actions = new Actions(driver);
//				actions.moveToElement(e1).click().build().perform();
				js.executeScript("arguments[0].click();", e1);
				Thread.sleep(12000);
				test.log(Status.PASS, "Clicked on  " + elementname + " Successfully.");
			}
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to Click on " + elementname + ".");
			log.error("Error in clickLink:",e);
		}
	}
	
	public void arrowDown(By by) {
		try {
			WebElement e1 = driver.findElement(by);
			Actions act = new Actions(driver);
			act.click(e1).build().perform();
			act.click(e1).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
			.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void arrowUP(By by) {
		try {
			WebElement e1 = driver.findElement(by);
			Actions act = new Actions(driver);
			act.click(e1).build().perform();
			act.click(e1).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP)
			.sendKeys(Keys.ARROW_UP).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void scrollDown(By by) {
		try {
			WebElement e1 = driver.findElement(by);
			Actions act = new Actions(driver);
			act.click(e1).build().perform();
			act.click(e1).sendKeys(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void isEnabled(By by, String elementname) throws IOException {
		// Click Button
		try {
			test.log(Status.INFO, "Click on" + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isEnabled()) {
				test.log(Status.PASS, elementname + "isEnabled");
			} else {
				test.log(Status.FAIL, elementname + "isDisabled.");

			}
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, elementname + "isDisabled.");
			log.error("Error in isEnabled:",e);
		}
	}

	public void elementShouldContain(By by, String elementname, String data) throws Exception {
		try {
			test.log(Status.INFO, "Verify " + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				String actualString = e1.getText();
				assertTrue(actualString.contains(data));
				test.log(Status.PASS, data + " presents in element");
				
			}
		} catch (Exception e) {
			test.log(Status.FAIL, data + " is not present in element");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in ElementShouldContain:",e);
		}
	}
		
		public void elementContain(By by, String elementname) throws Exception {
			try {
				test.log(Status.INFO, "Verify " + elementname);
				//JavascriptExecutor js = (JavascriptExecutor) driver;
				//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
				WebElement e1 = driver.findElement(by);
				if (e1.isDisplayed()) {
					String caseNumber = e1.getText();
					//assertTrue(actualString.contains(data));
					test.log(Status.PASS, caseNumber + " presents in element");
				}
			} catch (Exception e) {
				test.log(Status.FAIL, elementname + " is not present in element");
				test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				log.error("Error in ElementShouldContain:",e);
			}
	}
		

		public void elementAlertContain() throws Exception {
			try {
				test.log(Status.INFO, "Verify Alert text");
				//JavascriptExecutor js = (JavascriptExecutor) driver;
				//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
				String alertMessage= driver.switchTo().alert().getText(); 

				System.out.println("Alert Message: "+alertMessage); 
				Thread.sleep(5000);
					test.log(Status.PASS, alertMessage + " presents in element");
				
			} catch (Exception e) {
				test.log(Status.FAIL," Alert is not present in element");
				//test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				log.error("Error in ElementShouldContain:",e);
			}
	}

	public void elementShouldNotContain(By by, String elementname, String data) throws Exception {
		try {
			test.log(Status.INFO, "Verify " + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				String actualString = e1.getText();
				assertFalse(actualString.contains(data));
				test.log(Status.PASS, data + " is not presents in element");
				
			}
		} catch (Exception e) {
			test.log(Status.FAIL, data + " is present in element");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in ElementShouldNotContain:",e);
		}
	}
	
	public void elementContain1(WebElement ele, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Verify " + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			WebElement e1 = driver.findElement((By) ele);
			if (e1.isDisplayed()) {
				String text = e1.getText();
				//assertTrue(actualString.contains(data));
				test.log(Status.PASS, text + " presents in element");
				
			}
		} catch (Exception e) {
			test.log(Status.FAIL, elementname + " is not present in element");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in ElementShouldContain:",e);
		}
}

	public void isDisabled(By by, String elementname) throws IOException {
		// Click Button
		try {
			test.log(Status.INFO, "Click on" + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isEnabled()) {
				test.log(Status.FAIL, elementname + "isEnabled");
			} else {
				test.log(Status.PASS, elementname + "isDisabled");
			}
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, elementname + "isDisabled.");
			log.error("Error in isDisabled:",e);
		}
	}

	// Click Image
	public void clickImage(By by, String elementname) throws IOException {
		try {
			test.log(Status.INFO, "Click on" + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(e1).click().build().perform();
				test.log(Status.PASS, "Clicked on  " + elementname + " Successfully.");
			}
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to Click on " + elementname + ".");
			log.error("Error in clickImage:",e);
		}
	}

	
	// Click Image
		public void click1(By by, String elementname) throws IOException {
			try {
				test.log(Status.INFO, "Click on" + elementname);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				//WebElement result = driver.findElement(By.xpath("//a[text()='View All Messages ']"));
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
				wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				WebElement e1 = driver.findElement(by);
				if (e1.isDisplayed()) {
					//Actions actions = new Actions(driver);
					executor.executeScript("arguments[0].click();", e1);
					Thread.sleep(12000);
					//actions.moveToElement(e1).click().build().perform();
					test.log(Status.PASS, "Clicked on  " + elementname + " Successfully.");
				}
			} catch (Exception e) {
				test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				test.log(Status.FAIL, "Failed to Click on " + elementname + ".");
				log.error("Error in clickImage:",e);
			}
		}

	// Click Element
	public void clickElement(By by, String elementname) throws IOException {
		try {
			test.log(Status.INFO, "Click on" + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
//				Actions actions = new Actions(driver);
//				actions.moveToElement(e1).click().build().perform();
				js.executeScript("arguments[0].click();", e1);
				test.log(Status.PASS, "Clicked on  " + elementname + " Successfully.");
			}
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to Click on " + elementname + ".");
			log.error("Error in clickElement:",e);
		}
	}

	public void scrollPageDown() throws Exception {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(100);
			test.log(Status.PASS, "page successfully scrolled down");
		} catch (Exception e) {
			test.log(Status.INFO, "unable to scroll page down");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("Switch")));
			log.error("Error in ScrollPageDown:",e);
		}
	}

	public void scrollPageUp() throws Exception {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-250)", "");

			Thread.sleep(100);
			test.log(Status.PASS, "page successfully scrolled up");
		} catch (Exception e) {
			test.log(Status.INFO, "unable to scroll page up");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("Switch")));
			log.error("Error in ScrollPageUp:",e);
		}
	}

	public void closeBrowser() throws Exception {
		try {
			test.log(Status.INFO, "Close current Browser");
			driver.close();
			test.log(Status.PASS, "Application closed Successfully");
		} catch (Exception e) {
			test.log(Status.INFO, "Failed to close current Browser");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("Close All Browser")));
			log.error("Error in closeBrowser:",e);
		}
	}

	public void closeAllBrowser() throws Exception {
		try {
			test.log(Status.INFO, "Close Application");
			driver.quit();
			test.log(Status.PASS, "Application Closed successfully");
		} catch (Exception e) {
			test.log(Status.INFO, "Failed to close Application");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("CloseApplication")));
			log.error("Error in closeAllBrowser:",e);
		}
	}

	public void confirmAlert() throws Exception {
		test.log(Status.INFO, "Accept Alert Popup");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alt = driver.switchTo().alert();
			Thread.sleep(1000);
			alt.accept();
			test.log(Status.PASS, "Alert Popup Accecpted successfully");
			

		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to Accecpt Alert");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("Accecpt Alert")));
			log.error("Error in confirmAlert:",e);
		}
	}

	public void dismissAlert() throws Exception {
		test.log(Status.INFO, "Dismiss Alert Popup");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alt = driver.switchTo().alert();
			Thread.sleep(1000);
			alt.dismiss();
			test.log(Status.PASS, "Dismissed Alert Popup successfully");
			
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to Dismiss Alert");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("Dismiss Alert")));
			log.error("Error in dismissAlert:",e);
		}
	}

	public void doubleClick(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Double click on" + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Actions builder = new Actions(driver);
				builder.doubleClick(e1).build().perform();
				test.log(Status.PASS, "Double clicked on  " + elementname + " Successfully.");
			}
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to doube click on " + elementname + ".");
			log.error("Error in doubleClick:",e);
		}
	}

	// Click link in webtable
	// Pass the xpath of table and then search all links inside table and click link
	public void clickLinkinWebTable(By by, String elementname, String link) throws IOException {
		try {
			test.log(Status.INFO, "Headers");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				WebElement webtable1 = driver.findElement(by);
				List<WebElement> links = webtable1.findElements(By.tagName("a"));
				int totallinks = links.size();

				List<String> value = new ArrayList<String>();
				for (int j = 0; j < totallinks; j++) {

					value.add(links.get(j).getText());
				}
				if (value.contains(link)) {
					test.log(Status.PASS, link + "clicked successfully ");

				}
			}
		} catch (Exception e) {
			test.log(Status.FAIL, link + "Link not found in table");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in ClickLinkinWebTable:",e);
		}

	}

	public void reloadPage() throws Exception {
		// Refresh
		try {
			test.log(Status.INFO, "Refresh Current Page");
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			test.log(Status.PASS, "Application closeCurrent page should refreshed Successfully");
		} catch (Exception e) {
			test.log(Status.INFO, "Failed to Refresh page");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("Close All Browser")));
			log.error("Error in reloadPage:",e);
		}
	}

	public void selectCheckbox(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Select " + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				if (e1.isSelected()) {
					test.log(Status.FAIL, elementname + " is already selected");
				
				} else {
					e1.click();
					Thread.sleep(2000);
					test.log(Status.PASS, elementname + " selected Successfully.");
					test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				}
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to select on " + elementname);
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in selectCheckbox:",e);
		}
	}

	public void unselectCheckbox(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Select " + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				if (e1.isSelected()) {
					e1.click();
					Thread.sleep(2000);
					test.log(Status.PASS, " checkbox Unchecked Successfully.");
					
				} else {
					test.log(Status.FAIL, "checkbox is already Unchecked");
					test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				}
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "checkbox is already Unchecked");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in unselectCheckbox:",e);
		}
	}

	public void selectByIndex(By by, String elementname, String data) throws Exception {
		try {
			test.log(Status.INFO, "Select " + elementname + " from the dropdown");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			// wait.until(ExpectedConditions.elementToBeSelected(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Select se = new Select(e1);
				int val = Integer.parseInt(data.trim());
				se.selectByIndex(val);
				test.log(Status.PASS, elementname + " is selected from dropdown Successfully.");
			}
		} catch (Exception e) {
			test.log(Status.PASS, "Failed to select " + elementname + " from the dropdown.");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in selectByIndex:",e);
		}
	}

	public void selectByText(By by, String elementname, String data) throws Exception {
		try {
			test.log(Status.INFO, "Select " + elementname + " from the dropdown");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			// wait.until(ExpectedConditions.elementToBeSelected(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Select se = new Select(e1);
				se.selectByVisibleText(data.trim());
				test.log(Status.PASS, elementname + " is selected from dropdown Successfully.");
			}
		} catch (Exception e) {
			test.log(Status.PASS, "Failed to select " + elementname + " from the dropdown.");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in selectByText:",e);
		}
	}

	public void verifyTitle(String Text) throws Exception {
		try {
			test.log(Status.INFO, "Verify title of page is" + Text);
			if (driver.getTitle().contains(Text))
				test.log(Status.PASS, "Verify title of page is " + Text);
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(Text)));
			test.log(Status.FAIL, "Verify title of page Edit_Filed_Value is Failed");
			log.error("Error in verifyTitle:",e);
		}
	}

	public void selectByValue(By by, String elementname, String data) throws Exception {
		try {
			test.log(Status.INFO, "Select " + elementname + " from the dropdown");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			// wait.until(ExpectedConditions.elementToBeSelected(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Select se = new Select(e1);
				se.selectByVisibleText(data.trim());
				test.log(Status.PASS, elementname + " is selected from dropdown Successfully.");
			}
		} catch (Exception e) {
			test.log(Status.PASS, "Failed to select " + elementname + " from the dropdown.");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in selectByValue:",e);
		}
	}

	public void selectWindow(String input) throws Exception {
		try {
			test.log(Status.INFO, "Switch control from current Window");
			int val = Integer.parseInt(input);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> it = handles.iterator();
			if (input.equalsIgnoreCase("1")) {
				input = "parent";
			} else {
				input = "Child";
			}
			while (it.hasNext()) {
				String parent = it.next();
				String child = it.next();
				driver.switchTo().window(input);
				Thread.sleep(2000);
				test.log(Status.PASS, "control should Switch from current window Successfully");
			}
		} catch (Exception e) {
			test.log(Status.INFO, "Failed to Pass control");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(input)));
			log.error("Error in selectWindow:",e);
		}
	}

	public void switchDefault() throws Exception {
		// Switch Default Window
		try {
			test.log(Status.INFO, "Switch Default Window");
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
			test.log(Status.PASS, "control should Switch to current window Successfully");
		} catch (Exception e) {
			test.log(Status.INFO, "Failed to Pass control");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("Switch")));
			log.error("Error in switchDefault:",e);
		}
	}
	
	

	public void frameByIndex(int Input) throws Exception {
		try {
			test.log(Status.INFO, "Switch in to Frame");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Input));
			driver.switchTo().frame(Input);
			Thread.sleep(2000);
			test.log(Status.PASS, "Switched in to frame successfully.");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to perform operation inside frame.");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("VISIBLE_TEXT")));
			log.error("Error in frameByIndex:",e);
		}
	}

	public void frameByelement(By by) throws Exception {
		try {
			test.log(Status.INFO, "Switch in to Frame");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
			WebElement e1 = driver.findElement(by);
			driver.switchTo().frame(e1);
			Thread.sleep(2000);
			test.log(Status.PASS, "Switched to WEBELEMENTNAME frame successfully.");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to locate WEBELEMENTNAME frame.");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("WEBELEMENTNAMEFrame")));
			log.error("Error in frameByelement:",e);
		}
	}

	public void waitTillElementEnable(By by) throws Exception {
		test.log(Status.INFO, "Wait until VISIBLE_TEXT is Enabled");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.elementToBeClickable(by));
			test.log(Status.PASS, "VISIBLE_TEXT is enabled in the page");
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("VISIBLE_TEXT")));
			test.log(Status.FAIL, "VISIBLE_TEXT is not-enabled in the page");
			log.error("Error in waitTillElementEnable:",e);
		}
	}

	public void waitTillElementVisible(By by) throws Exception {
		test.log(Status.INFO, "Wait until VISIBLE_TEXT is Enabled");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			test.log(Status.PASS, "VISIBLE_TEXT is enabled in the page");
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("VISIBLE_TEXTWait")));
			test.log(Status.FAIL, "VISIBLE_TEXT is not-enabled in the page");
			log.error("Error in waitTillElementVisible:",e);
		}
	}

	public void waitTillElementinVisible(By by) throws Exception {
		test.log(Status.INFO, "Wait until VISIBLE_TEXT is Enabled");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			test.log(Status.PASS, "VISIBLE_TEXT is enabled in the page");
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("VISIBLE_TEXTinWait")));
			test.log(Status.FAIL, "VISIBLE_TEXT is not-enabled in the page");
			log.error("Error in waitTillElementVisible:",e);
		}
	}

	protected String takeScreenShot(String methodName) {
		String path = "C:\\IAS\\IAS_Selenium\\Generated Tests\\Automation_Scripts\\Reports\\Screenshots\\CLASS_NAME\\"
				+ methodName + ".png";
		try {
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(path));
		} catch (Exception e) {
			log.error("Error in takeScreenShot:",e);
		}
		return path;
	}

	public void clickRadioButton(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Click " + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			// wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				if (e1.isSelected()) {
					test.log(Status.FAIL, elementname + " is already Clicked");
				} else {
					//e1.click();
					js.executeScript("arguments[0].click();", e1);

					test.log(Status.PASS, elementname + " Clicked Successfully.");
					
				}
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to CLick on " + elementname);
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in ClickRadioButton:",e);
		}
	}

	// Need to add this keyword in the Keyword List
	public void clickRadioButtonByValue(String data) throws Exception {

		try {
			test.log(Status.INFO, "Select Radio Button by name " + data + " .");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
			System.out.println("No " + radios.size());

			for (int i = 0; i < radios.size(); i++) {
				System.out.println("value  " + i + "   " + radios.get(i).getAttribute("value"));
				if (radios.get(i).getAttribute("value").contains(data)) {

					radios.get(i).click();
				}
				test.log(Status.PASS, data + " is Clicked Successfully.");
				
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Failed to Select " + data + " .");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(data)));
			log.error("Error in ClickRadioButton:",e);
		}
	}

	public void unCheckAll() throws Exception {
		int i = 0;
		try {
			test.log(Status.INFO, "UnCheck all Check boxes in the Page");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			List<WebElement> Check = driver.findElements(By.xpath("//input[@type='checkbox']"));
			for (i = 0; i < Check.size(); i++) {
				System.out.println("value  " + i + "   " + Check.get(i).getText());
				if (Check.get(i).isSelected()) {
					Check.get(i).click();
				}
			}
			test.log(Status.PASS, "All Check Boxes are UnChecked Successfully.");
		}catch (Exception e) {
			test.log(Status.FAIL, "Failed to UnSelect .");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("")));
			log.error("Error in UnCheckAll:",e);
		}
	}

	// Added on 04192018
	public void verifyIsCheckboxSelected(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Verify is CHeckBox Selected for a " + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				if (e1.isSelected()) {
					test.log(Status.PASS, elementname + " is selected");
					
				} else {

					test.log(Status.FAIL, elementname + " is not selected ");
				}
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to select on " + elementname);
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in VerifyIsCheckboxSelected:",e);
		}
	}

	public void verifyIsCheckboxUnSelected(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Verify is CHeckBox Selected for a " + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				if (e1.isSelected()) {
					test.log(Status.FAIL, elementname + " is selected ");
				} else {
					test.log(Status.PASS, elementname + " is not selected");
				}
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to select on " + elementname);
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in VerifyIsCheckboxUnSelected:",e);
		}
	}
	
	public void verifyCheckboxSelected(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Verify is CheckBox Selected for a " + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			
				if (e1.isDisplayed()!=false) {
					test.log(Status.PASS, elementname + " is selected");
					
				} else {

					test.log(Status.FAIL, elementname + " is not selected ");
				}
			
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to select on " + elementname);
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in VerifyIsCheckboxSelected:",e);
		}
	}

	
	public void verifyCheckboxUnSelected(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Verify is CheckBox Selected for a " + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			
				if (e1.isSelected()!=true) {
					test.log(Status.PASS, elementname + " is not selected");
					
				} else {
					test.log(Status.FAIL, elementname + " is selected ");
				}
			
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to select on " + elementname);
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in VerifyIsCheckboxUnSelected:",e);
		}
	}

	public void verifyElementVisible(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Verify is Element Visible_  " + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				test.log(Status.PASS, elementname + " is Visible");
			} else {
				test.log(Status.FAIL, elementname + " is not Visible ");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed as Element is  " + elementname);
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in VerifyElementVisible:",e);
		}
	}

	public void verifyElementNotVisible(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Verify is Element is not Visible_  " + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				test.log(Status.FAIL, elementname + " is Visible ");
			} else {
				test.log(Status.PASS, elementname + " is  not Visible");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed as Element is  " + elementname);
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in VerifyElementNotVisible:",e);
		}
	}

	public void pageShouldContainsText(String data) throws Exception {
		try {
			test.log(Status.INFO, "Verify Page contains_  " + data);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			// wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			if (driver.getPageSource().contains(data)) {
				test.log(Status.PASS, "Page contains the data " + data);
			} else {
				test.log(Status.FAIL, "Page does not contains the data " + data);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Page does not contains the data " + data);
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(data)));
			log.error("Error in PageShouldContainsText:",e);
		}
	}

	public void pageShouldContainsImage(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Verify Page contains_Image  " + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			WebElement ImageFile = driver.findElement(by);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					ImageFile);
			if (!ImagePresent) {
				test.log(Status.PASS, "Page contains the Image " + elementname);
			} else {
				test.log(Status.FAIL, "Page does not contains the Image " + elementname);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Page does not contains the Image " + elementname);
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in PageShouldContainsImage:",e);
		}
	}

	public void howerMouse(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, elementname + "  Hower mouse");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {

				Actions actions = new Actions(driver);
				actions.moveToElement(e1).build().perform();

				test.log(Status.PASS, "Successfully Mouseover on" + elementname);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to mouseover on element");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in HowerMouse:",e);
		}
	}

	public void menuSelectionHowerMouse(By by, String elementname, String data) throws Exception {
		try {
			test.log(Status.INFO, "Menu Select " + elementname + " By Hower mouse");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				WebElement element = driver.findElement(By.linkText(data));
				WebElement el = driver.findElement(by);
				Actions actions = new Actions(driver);
				actions.moveToElement(element).perform();
				actions.moveToElement(el).click();

				test.log(Status.PASS, " Menu selected  Successfully.");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to select .");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in MenuSelection_HowerMouse:",e);
		}
	}

	// Robotclass for sendkeys
	public void keyBoardEvents(String data) throws Exception {
		try {
			test.log(Status.INFO, "Press teh KeyBoardb Key : " + data + " .");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			Robot r = new Robot();
			if (data.equalsIgnoreCase("Enter")) {
				r.keyPress(KeyEvent.VK_ENTER);
			} else if ((data.equalsIgnoreCase("Tab"))) {
				r.keyPress(KeyEvent.VK_TAB);
			}
			test.log(Status.PASS, " Key pressed Successfully.");
		}catch (Exception e) {
			test.log(Status.FAIL, "Failed to Click  the Keyboard.");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(data)));
			log.error("Error in KeyBoard_Events:",e);
		}
	}

//	public void VerifyTextinImage(By by, String elementname,String data) throws Exception {
//		try {
//			test.log(Status.INFO, "Verify image contains text  " + elementname);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
//			//WebElement ImageFile = driver.findElement(by);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//	        String imageUrl=driver.findElement(by).getAttribute("src");
// 			System.out.println("Image source path : \n"+ imageUrl);
//
// 			URL url = new URL(imageUrl);
//			 Image image = ImageIO.read(url);
// 			String s = new Ocr().recognizeCharacters((RenderedImage) image);
//			if(s.contains(data))
//			{
//				test.log(Status.PASS, "Successfully verified the text in image " +elementname );
//			}
//			else
//			{
//				test.log(Status.FAIL, "unable to verify the text in image " +elementname );
//			}
//		
//		
//		} catch (Exception e) {
//			// TODO: handle exception
//			test.log(Status.FAIL, "unable to verify the text in image " +elementname );
//			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
//			e.printStackTrace();
//		}
//	}

	//Verify Header Count
	public void headerCountShouldBe(By by, String elementname, int headercount) throws IOException {
		try {
			test.log(Status.INFO, "Headers");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			List<WebElement> allHeadersOfTable = driver.findElements(by);
			int totalHeaders = allHeadersOfTable.size();
			assertTrue(totalHeaders == headercount);
			test.log(Status.PASS, headercount + " is same");
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to get header count ");
			log.error("Error in KeyBoard_Events:",e);
		}
	}

	//Verify Table Existence
	public void verifyTableExistence(By by, String elementname) throws IOException {
		try {
			test.log(Status.INFO, "Headers");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				WebElement webtable1 = driver.findElement(by);
				List<WebElement> rows = webtable1.findElements(By.tagName("tr"));
				//int totalrows = rows.size();
				List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));
				//int totalcolumns = columns.size();
			}
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to find table ");
			log.error("Error in VerifyTableExistence:",e);
		}

	}

	public void uploadFile(String filename) throws AWTException {
		StringSelection ss = new StringSelection(filename);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void clearElementText(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Clear " + elementname + "field");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				//Actions actions = new Actions(driver);
				//actions.moveToElement(e1).click().build().perform();
				e1.clear();
				e1.sendKeys(" ");
				test.log(Status.PASS, " Cleared" + elementname + " field Successfully.");
			}
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to clear " + elementname + " field.");
			log.error("Error in clearElementText:",e);
		}
	}

	public void verifyLinkExistence(By by, String elementname) throws IOException {
		try {
			test.log(Status.INFO, "Verify Link" + elementname);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				test.log(Status.PASS, "Link " + elementname + "exists");
			}
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Link  " + elementname + "doesnot exists");
			log.error("Error in VerifyLinkExistence:",e);
		}
	}

	//Verify Table Should contain
	public void tableShouldContain(By by, String elementname, String data) throws IOException {
		try {
			test.log(Status.INFO, "Headers");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				WebElement webtable1 = driver.findElement(by);
				List<WebElement> rows = webtable1.findElements(By.tagName("tr"));
				int totalrows = rows.size();
				List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));
				int totalcolumns = columns.size();
				List<String> value = new ArrayList<String>();
				for (int j = 0; j < totalcolumns; j++) {
					value.add(columns.get(j).getText());
				}
				if (value.contains(data)) {
					test.log(Status.PASS, data + "found in table ");
				}
			}
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to find  " + data + "in tale");
			log.error("Error in TableShouldContain:",e);
		}

	}

	//Click link in webtable
	// Pass the xpath of table and then search all links inside table and click link
	public void clickLinkinWebTable1(By by, String elementname, String link) throws IOException {
		try {
			test.log(Status.INFO, "links");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				WebElement webtable1 = driver.findElement(by);
				List<WebElement> links = webtable1.findElements(By.tagName("a"));
				int totallinks = links.size();

				List<String> value = new ArrayList<String>();
				for (int j = 0; j < totallinks; j++) {

					value.add(links.get(j).getText());
				}
				if (value.contains(link)) {
					test.log(Status.PASS, link + "clicked successfully ");

				}
			}
		} catch (Exception e) {
			test.log(Status.FAIL, link + "Link not found in table");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			log.error("Error in TableShouldContain:",e);
		}

	}

	//TableShouldNotContain
	public void tableShouldNotContain(By by, String elementname, String data) throws IOException {
		try {
			test.log(Status.INFO, "webtable should not contain data");
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				WebElement webtable1 = driver.findElement(by);
				List<WebElement> rows = webtable1.findElements(By.tagName("tr"));
				int totalrows = rows.size();
				List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));
				int totalcolumns = columns.size();
				List<String> value = new ArrayList<String>();
				for (int j = 0; j < totalcolumns; j++) {

					value.add(columns.get(j).getText());
				}
				if (value.contains(data)) {
					test.log(Status.PASS, data + "found in table ");
				}
			}
		} catch (Exception e) {
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to find  " + data + "in tale");
			log.error("Error in TableShouldNotContain:",e);
		}

	}

	public void fnSwitchToCurrentTab () throws Exception
	
	{
		try
		{
//			 java.util.Set<String> handles = driver.getWindowHandles();
//		        
//		        String firstWinHandle = driver.getWindowHandle(); handles.remove(firstWinHandle);
//		        
//		        String winHandle=handles.iterator().next();
//		        
//		        if (winHandle!=firstWinHandle){
//		        
//		        //To retrieve the handle of second window, extracting the handle which does not match to first window handle
//		        
//		        String secondWinHandle = winHandle; //Storing handle of second window handle
//		        
//		       //Switch control to new window
//		        
//		        driver.switchTo().window(secondWinHandle);
			
			String parent=driver.getWindowHandle();
			Set<String>s1=driver.getWindowHandles();
			Iterator<String> I1= s1.iterator();
			while(I1.hasNext())
			{
			  String child_window=I1.next();
			  if(!parent.equals(child_window))
			  {
			    driver.switchTo().window(child_window);
			    System.out.println(driver.switchTo().window(child_window).getTitle());
			    driver.close();
			  }
					        }
		}
		catch (Exception e) {
			// TODO: handle exception
			test.log(Status.INFO, "Failed to Pass control");
			log.error("Error in switchDefault:", e);
			}
		
		
	    
	 
	}
	
	
	public void clickUsingJs(By by, String elementname) throws Exception 
    {
          try 
          {

                 WebElement e1 = driver.findElement(by);;
                 
                 JavascriptExecutor executor = (JavascriptExecutor)driver;
                 executor.executeScript("arguments[0].click();", e1);
                 
          } 
          catch (Exception e) 
          {
                 // TODO: handle exception/
                                e.printStackTrace();
          }
    }

	
	
}
