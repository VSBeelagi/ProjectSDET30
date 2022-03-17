 package com.crm.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all generic methods related to WebDriverAction
 * @author Vijayalaxmi
 *
 */
public class WebDriverUtility {
	
	/**
	 * THis method will maximize the window
	 * @param driver
	 * 
	 */
	public void maximizeWindow(WebDriver driver)
	
	{
		driver.manage().window().maximize();
	}

	
	/**
	 * This method will wait for 20 seconds for the page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	/**
	 * This method will wait for 10 seconds for an element to be clickable
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * This method will wait for 20 seconds for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * THis method will select data from dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	
	/**
	 * This method will select data from dropdown using visible text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	/**
	 * This method will select data drom dropdown using value
	 * @param value
	 * @param element
	 */
	public void select(String value, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	
	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param Element
	 */
	public void mousehover(WebDriver driver, WebElement Element)
	{
		Actions Act = new Actions(driver);
		Act.moveToElement(Element).perform();
	}
	
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param target
	 */
	
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement target)
	{
		Actions Act = new Actions(driver);
		Act.dragAndDrop(src, target).perform();
	}
	
	
	/**
	 * This method will double click on element
	 * @param driver
	 * @param 
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions Act = new Actions(driver);
		Act.doubleClick(element);
	}
	
	
	/**
	 * THis method will perform double click on webPage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions Act = new Actions(driver);
		Act.doubleClick().perform();
	}
	
	
	/**
	 * THis method will perform right click on WebPage
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions Act = new Actions(driver);
		Act.contextClick().perform();
	}
	
	
	/**
	 * This method will right click on element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions Act = new Actions(driver);
		Act.contextClick(element).perform();
	}
	
	
	/**
	 * This method will press enter key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions Act = new Actions(driver);
		Act.sendKeys(Keys.ENTER).perform();
	}
	
	
	/**
	 * THis method will press enter key
	 * @throws Throwable
	 */
	public void enterKey() throws Throwable
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	
	/**
	 * This method is to release the key
	 * @throws Throwable
	 */
	public void enterRelease() throws Throwable
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	/**
	 * This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	/**
	 * This method will switch the frame based on name or ID
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	
	/**
	 * This method will switch the frame based on address of the element
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	/**
	 * This method will accept alert popup
	 * @param driver
	 */

	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will cancel alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * Thos method will switch between windows
	 * @param driver
	 * @param partialWinTitle
	 */
	
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//step1: use getWindowHandles to capture all window ids
		Set<String> windows = driver.getWindowHandles();
		
		//step2: iterate thru the windows
		Iterator<String> it = windows.iterator();
		
		//step3: check whether there is next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String winId = it.next();
			
			//step5: switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//step6: check whether the current window is expected
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
		
	
	/**
	 * This method will take screenshot and store it in folder called as Screenshot
	 * @param driver
	 * @param screenShotName
	 * @throws Throwable
	 */
		public String getScreenShot(WebDriver driver, String screenShotName) throws Throwable
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = ".\\screenshot\\"+screenShotName+".png";
			File dst = new File(path);
			FileUtils.copyFile(src, dst);
			
			return dst.getAbsolutePath();
		}
		
		/**
		 * This method will perform random scroll
		 * @param driver
		 */
		public void scrollAction(WebDriver driver)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)","");
		}
		
		/**
		 * THis method will scroll untill the specified element is found
		 * @param driver
		 * @param element
		 */
		public void scrollAction(WebDriver driver, WebElement element)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			int y = element.getLocation().getY();
			js.executeScript("window.scrollBy(0,"+y+")", element);
			//js.executeScript("argument[0].scrollIntoView()",element);
					
		}
	}









