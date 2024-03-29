package com.generic;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperFunctions extends LoadableComponent<WrapperFunctions>{

	private TestBase objTestBase;
	
	public WrapperFunctions(TestBase testBase) {

		this.objTestBase=testBase;

	}
	
	
	public void waitForElementPresence(By locator) throws NotFoundException{
		
		WebDriverWait getWebDriverWait=new WebDriverWait(objTestBase.getDriver(),Integer.parseInt(objTestBase.getObjConfig().getProperty("midwait")));
		getWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	public void waitForElementVisibilityLocated(By locator) throws NotFoundException{
		
		WebDriverWait getWebDriverWait= new WebDriverWait(objTestBase.getDriver(),Integer.parseInt(objTestBase.getObjConfig().getProperty("midwait")));
		getWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public void waitForElementClickable(By locator) throws NotFoundException {
		
		WebDriverWait getWebDriverWait= new WebDriverWait(objTestBase.getDriver(), Integer.parseInt(objTestBase.getObjConfig().getProperty("midwait")));
		getWebDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
	
	}
	
	public boolean waitFor(int timeUnitInSecond){
		
		try {
			
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitInSecond, TimeUnit.SECONDS));
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public boolean click(By locator){
		
		try {
			
			this.waitForElementClickable(locator);
			WebElement element=objTestBase.getDriver().findElement(locator);
			element.click();
			return true;
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setText(By locator,String fieldValue){
		try {
			
			this.waitForElementPresence(locator);
			this.waitForElementVisibilityLocated(locator);
			WebElement element=objTestBase.getDriver().findElement(locator);
			element.clear();
			element.sendKeys(fieldValue);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	
	public String getText(By locator){
		try {
			
			this.waitForElementPresence(locator);
			this.waitForElementVisibilityLocated(locator);
			WebElement element=objTestBase.getDriver().findElement(locator);
			return element.getText();
						
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	
	public boolean checkElementDisplayed(By locator){
		
		try {
			
			this.waitForElementPresence(locator);
			return objTestBase.getDriver().findElement(locator).isDisplayed();
		} catch (Exception e) {
			
			//e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean checkElementNOTDisplayed(By locator){
		
		try {
			
			this.waitForElementPresence(locator);
			return !(objTestBase.getDriver().findElement(locator).isDisplayed());
		} catch (Exception e) {
			
			//e.printStackTrace();
			return true;
		}
		
	}
	
	public boolean selectDropdownValue(By locator,String drpOption){
		
		try {
			
			this.checkElementDisplayed(locator);
			WebElement element = objTestBase.getDriver().findElement(locator);
			Select select=new Select(element);
			select.selectByVisibleText(drpOption);
			return true;
			
		} catch (Exception e) {
			
			//e.printStackTrace();
			return false;
		
		}
	}
	
	public boolean switchToWindowUsingTitle(String strWindowTitle){
		
		try {
			
			String strMainWindowHandle=objTestBase.getDriver().getWindowHandle();
			Set<String> openWindow=objTestBase.getDriver().getWindowHandles();
			
			
			if(!openWindow.isEmpty()){
				
				for (String windows : openWindow) {
					
					String strWindow=objTestBase.getDriver().switchTo().window(windows).getTitle();
					
					if(strWindowTitle.equals(strWindow))
						
						return true;
					else
						objTestBase.getDriver().switchTo().window(strMainWindowHandle);
				}
			}
			return false;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	
	public boolean mouseHover(By locator) {
		try {
			waitForElementPresence(locator);
			WebElement webElement = objTestBase.getDriver().findElement(locator);
			Actions actionBuilder = new Actions(objTestBase.getDriver());
			actionBuilder.moveToElement(webElement).build().perform();
			return true;
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	
	public boolean scrollToView(By locator) {
		try {
			waitForElementPresence(locator);
			WebElement webElement = objTestBase.getDriver().findElement(locator);
			((JavascriptExecutor) objTestBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
			return true;
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	public boolean scrollToViewDown(By locator) {
		try {
			waitForElementPresence(locator);
			WebElement webElement = objTestBase.getDriver().findElement(locator);
			((JavascriptExecutor) objTestBase.getDriver()).executeScript("arguments[0].scrollIntoView(false);", webElement);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	
	
	
	
	

	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

}
