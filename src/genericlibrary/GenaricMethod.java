package genericlibrary;

import java.awt.List;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.sun.xml.bind.v2.model.core.Element;

//import junit.framework.Assert;
//import net.bytebuddy.implementation.InvokeDynamic.InvocationProvider.NameProvider;

public class GenaricMethod {

			/**
		 * @Class Name: DriverMethods
		 * @Description: Having reusable driver methods
		 * @Creation Date: 18-July-2016
		 * @author: Mohita Bisaria
		 * @Modified By: Mohita Bisaria
		 * @MOdified Date: 18-July-2016
		 */


		

			public static String xFID = null;
			public static WebDriver webDriver = null;

		
		public void GenaricMethod(WebDriver webDriver)
			{
			GenaricMethod.webDriver = webDriver;
		}

			public void setxFID(String xFID)
			{
				GenaricMethod.xFID = xFID;
			}

			public String getxFID()
			{
				return GenaricMethod.xFID;
			}

			public WebDriver getWebDriver()
			{
				return GenaricMethod.webDriver;
			}

			




		                /**
			 * @Description : Wait for page load.
			 * @return boolean
			 */
			public boolean waitForPageLoad() {
				int waitTime = new Double(20).intValue();
				WebDriver driver = getDriver();
				ExpectedCondition<Boolean> pageLoad = new ExpectedCondition<Boolean>() {
					@Override
					public Boolean apply(WebDriver driver) {
						return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
					}
				};

				Wait<WebDriver> wait = new WebDriverWait(driver, waitTime);

				try {
					wait.until(pageLoad);
				} catch (Throwable pageLoadWaitError) {

					return false;

				}
				return true;
			}



			














		/**
			 * @Description : Close all browsers except the parent window
			 * @param : String id
			 */
			public void closeAllChildWindows(String id) {
				try {

					Set<String> windowHandles = getWebDriver().getWindowHandles();

					for (String s : windowHandles) {
						if (!id.equalsIgnoreCase(s)) {
							getWebDriver().switchTo().window(s);
							getWebDriver().close();
						}

					}

					getWebDriver().switchTo().window(id);

				} catch (Exception ex) {

				}

			}

			


















		/**
			 *  @Description : Accept alert.
			 */
			public void acceptAlert() {
				try {

					WebDriverWait wait = new WebDriverWait(getWebDriver(), 30);
					wait.until(ExpectedConditions.alertIsPresent());
					Alert alert = getWebDriver().switchTo().alert();
					alert.accept();

				} 
				catch (Exception e) {

				}

			}



























		/**
			 * @Description : Delete cookies.
			 *//*
			public void deleteCookies() {
				WebDriver webDriver = getWebDriver();

				if (webDriver instanceof RemoteWebDriver)
					((RemoteWebDriver) webDriver).manage().deleteAllCookies();
				else if (webDriver instanceof NameProvider && ((NativeDriverProvider) webDriver).getNativeDriver() instanceof RemoteWebDriver) {
					((RemoteWebDriver) ((NativeDriverProvider) webDriver).getNativeDriver()).manage().deleteAllCookies();
				}
			}*/
			public void switchWindow() {
				//log.info("***** In method 'switchWindow()' ");

				WebDriver webDriver = getWebDriver();
				Set<String> handles = webDriver.getWindowHandles();
				System.out.println("No. of windows is: " + handles.size());

				for (String winHan : handles) {
					System.out.println(winHan);
					System.out.println(webDriver.getTitle());
					webDriver.switchTo().window(winHan);
					System.out.println(webDriver.getPageSource());
				}
			} 

			/**
			 * @Description : navigateNextgenWithUser : Used to login NextGen with a specific user
			 * @return : void
			 * @param : String :userId
			 */
		/*	public void navigateNextgenWithUser(String userId) {
				String nextgenUrl = getApplicationUrl("NEXTGEN");

				if (!(userId.length() == 0 || userId.equalsIgnoreCase("null") || userId == null))
					nextgenUrl = nextgenUrl + "?userId=" + userId;

				getWebDriver().get(nextgenUrl);
				//log.info("Navigated to URL: " + nextgenUrl);
			}
*/
			/**
			 * @Description : Navigate NGAA with user.
			 * @param : String :userId
			 */
			/*public void navigateNGAAWithUser(String userId) {
				String nextgenUrl = getApplicationUrl("NGAA");

				if (!(userId.length() == 0 || userId.equalsIgnoreCase("null") || userId == null))
					nextgenUrl = nextgenUrl + "?userId=" + userId;

				getWebDriver().get(nextgenUrl);
				//log.info("Navigated to URL: " + nextgenUrl);
			}*/

			/**
			 * @Description :Navigate CFI with user.
			 * @param userId the user id
			 */
		/*	public void navigateCFIWithUser(String userId) {
				String nextgenUrl = getApplicationUrl("CFI");

				if (!(userId.length() == 0 || userId.equalsIgnoreCase("null") || userId == null))
					nextgenUrl = nextgenUrl + "?userId=" + userId;

				getWebDriver().get(nextgenUrl);
				maximizeWindow();
				//log.info("Navigated to URL: " + nextgenUrl);
			}
*/
			/**
			 * @Description :Navigate Support with user.
			 * @param userId the user id
			 */
		/*	public void navigateSupportWithUser(String userId) {
				String nextgenUrl = getApplicationUrl("SUPPORT");

				if (!(userId.length() == 0 || userId.equalsIgnoreCase("null") || userId == null))
					nextgenUrl = nextgenUrl + "?userId=" + userId;

				getWebDriver().get(nextgenUrl);
				//log.info("Navigated to URL: " + nextgenUrl);
			}
			*/

		/**
			 * @Description : Navigate FNOLLITE with user.
			 * @param userId the user id
			 */
	/*		public void navigateFNOLLITEWithUser(String userId) {
				String fnolLiteUrl = getApplicationUrl("FNOLLITE");

				if (!(userId.length() == 0 || userId.equalsIgnoreCase("null") || userId == null))
					fnolLiteUrl = fnolLiteUrl + "?userId=" + userId;

				getWebDriver().get(fnolLiteUrl);
				//log.info("Navigated to URL: " + fnolLiteUrl);
			*///}

			/**
			 * @Description : Navigate FNOLLITECONTROLPANEL with user.
			 * @param userId the user id
			 */
		/*	public void navigateFnolLiteControlPanel(String userId) {
				String fnolLiteCtrlPanelUrl = getApplicationUrl("FNOLLITE_CONTROL_PANEL");

				if (!(userId.length() == 0 || userId.equalsIgnoreCase("null") || userId == null))
					fnolLiteCtrlPanelUrl = fnolLiteCtrlPanelUrl + "?userId=" + userId;

				getWebDriver().get(fnolLiteCtrlPanelUrl);
				//log.info("Navigated to URL: " + fnolLiteCtrlPanelUrl);
			}*/

			/**
			 * @Description : Navigate application url.
			 * @param applicationName the application name
			 */
			/*public void navigateApplicationUrl(String applicationName) {
				String applicationUrl = getApplicationUrl(applicationName);
				getWebDriver().get(applicationUrl);
				//log.info("Navigated to URL: " + applicationUrl);
			}
*/
			





		/**
			 * @Description :Gets the application url.
			 * @param String : applicationName 
			 * @return the application url
			 */
	/*		public String getApplicationUrl(String applicationName) {
				applicationName = applicationName.toUpperCase();
				String environment = ApplicationRegistry.instance(xFID).getApplication("AUT").getUrl();
				String applicationUrl = ApplicationRegistry.instance(xFID).getApplication(environment + "_" + applicationName).getUrl();

				return applicationUrl;
			}
*/
			/**
			 * @Description : getEnvironmentName: Get the testing Environment Name
			 * @return String: envirnmentName
			 */
	/*		public String getEnvironmentName() {
				return ApplicationRegistry.instance(xFID).getApplication("AUT").getUrl();
			}
		*/	/*
			 *//**
			 * @Description :Sets the implicit time out.
			 * @param Stirng : seconds 
			 *//*
		    public void setImplicitTimeOut(int seconds) {
		        WebDriver webDriver = getWebDriver();
		        webDriver.manage().timeouts().implicitlyWait(seconds * 1000, TimeUnit.MILLISECONDS);
		    }*/

			/*   *//**
			 * @Description :Sets the page load time out.
			 * @param String :seconds 
			 *//*
		    public void setPageLoadTimeOut(int seconds) {
		        WebDriver webDriver = getWebDriver();
		        webDriver.manage().timeouts().pageLoadTimeout(seconds * 1000, TimeUnit.MILLISECONDS);
		    }
			




		  */
			/*    *//**
			 * @Description :Sets the script load time out.
			 * @param String:seconds
			 *//*
		    public void setScriptLoadTimeOut(int seconds) {
		        WebDriver webDriver = getWebDriver();
		        webDriver.manage().timeouts().setScriptTimeout(seconds * 1000, TimeUnit.MILLISECONDS);
		    }
			  */

			/**
			 * @Description : Method for switching to the child window
			 */
			public void switchToChildWindow() {
				try {
					WebDriver driver = getWebDriver();
					// Thread.sleep(1000);
					waitForPageLoad();

					String parentWinID = driver.getWindowHandle();
					Set<String> allWinIDs = driver.getWindowHandles();

					for (String win : allWinIDs) {
						if (!win.equalsIgnoreCase(parentWinID)) {
							driver.switchTo().window(win);
							break;
						}
					}
					waitForPageLoad();
				} catch (Exception e) {

				}

			}

			







		/**
			 * @Description : Switch to child window.
			 * @param String :parentWinID
			 */
			public void switchToChildWindow(String parentWinID) {
				try {
					waitForPageLoad();
					System.out.println("parent Id "+parentWinID);
					WebDriver driver = getWebDriver();
					Set<String> allWinIDs = driver.getWindowHandles();

					for (String win : allWinIDs) {
						if (!win.equalsIgnoreCase(parentWinID)) {
							driver.switchTo().window(win);
							break;
						}
					}
				} catch (Exception e) {

				}

			}

			/**
			 * @Description : Gets the current window ID.
			 * @return the current window ID
			 */
			public String getCurrentWindowID() {
				try {
					WebDriver driver = getWebDriver();
					waitForPageLoad();

					String winID = driver.getWindowHandle();
					return winID;

				} catch (Exception e) {
					return null;
				}

			}

			/**
			 * @Description : getAllWindowIDs : Get All Window IDs
			 * @return : Set<String>
			 */
			public Set<String> getAllWindowIDs() {
				try {
					WebDriver driver = getWebDriver();
					waitForPageLoad();

					return driver.getWindowHandles();

				} catch (Exception e) {
					return null;
				}

			}

			/**
			 * @Description : Window Switch Type.
			 * @return enum
			 */
			private enum WindowSwitchType {

				/** The by wintitle. */
				BY_WINTITLE,
				/** The by winurl. */
				BY_WINURL,
				/** The by frame. */
				BY_FRAME,
				/** The by parentframe. */
				BY_PARENTFRAME,
				/** The by default. */
				BY_DEFAULT,
				/** The by winclose. */
				BY_WINCLOSE,
				/** The by alert. */
				BY_ALERT,
				/** The by windowdialog */
				BY_WINDOWDIALOG_TITLE,
				/** The by frame index */
				BY_FRAME_INDEX,
				/** The by winID. */
				BY_WINID;
			}

			

		/**
			 * @Description : Switch to.
			 * @param String:switchType , switchExpValue 
			 * @return  boolean
			 */
			public boolean switchTo(String switchType, String switchExpValue) {
				try {
					switch (WindowSwitchType.valueOf(switchType)) {
					case BY_WINTITLE:
						return switchWindow(switchType, switchExpValue);
					case BY_WINURL:
						return switchWindow(switchType, switchExpValue);
					case BY_WINDOWDIALOG_TITLE:
						return switchWindowDialog(switchType, switchExpValue);
					case BY_FRAME:
						getWebDriver().switchTo().defaultContent();
						getWebDriver().switchTo().frame(switchExpValue);
						break;
					case BY_FRAME_INDEX:
						getWebDriver().switchTo().defaultContent();
						getWebDriver().switchTo().frame(Integer.parseInt(switchExpValue));
						break;
					case BY_PARENTFRAME:
						getWebDriver().switchTo().parentFrame();
						break;
					case BY_DEFAULT:
						getWebDriver().switchTo().defaultContent();
						break;
					case BY_WINCLOSE:
						getWebDriver().close();
						break;
					case BY_ALERT:
						WebDriverWait alertWait = new WebDriverWait(getWebDriver(), 5);
						alertWait.until(ExpectedConditions.alertIsPresent());
						Alert alert = getWebDriver().switchTo().alert();
						alert.accept();
						break;
					case BY_WINID:
						getWebDriver().switchTo().window(switchExpValue);
						break;
					default:
						throw new IllegalArgumentException("Parameter switchtype should be BY_WINTITLE| BY_WINURL|BY_FRAME|BY_PARENTFRAME|BY_DEFAULT|BY_ALERT");
					}

				} catch (Exception e) {
					return false;
				}

				return true;
			}

			/**
			 * @Description : Switch window.
			 * @param String : switchType ,winExpValue
			 * @return boolean
			 * @throws Exception 
			 */
			private boolean switchWindow(String switchType, String winExpValue) throws Exception {

				//log.info("***** In method 'switchWindow()' for: " + switchType + " Window Name:" + winExpValue + " *****");

				waitForPageLoad();
				TimeUnit.SECONDS.sleep(2);

				WebDriver webDriver = getWebDriver();
				boolean bSwitchWindow = false;
				String winActValue = "";
				Set<String> availableWindows = webDriver.getWindowHandles();
				if (!availableWindows.isEmpty()) {
					for (String windowId : availableWindows) {
						if (switchType.equalsIgnoreCase("BY_WINTITLE")) {
							winActValue = webDriver.switchTo().window(windowId).getTitle().trim().toLowerCase();
						} else {
							winActValue = webDriver.switchTo().window(windowId).getCurrentUrl().trim().toLowerCase();
						}

						winExpValue = winExpValue.trim().toLowerCase();
						if (winActValue.contains(winExpValue)) {
							bSwitchWindow = true;
							//log.info("Window '" + winExpValue + "' switched successfully!!");
							getWebDriver().manage().window().maximize();
							break;
						}
					}

					//log.info("***** Exit method 'switchWindow()' for: " + switchType + " Window Name:" + winExpValue + " *****");
				}

				waitForPageLoad();

				return bSwitchWindow;
			}

			/**
			 * @Description : Switch window with no title.
			 * @return boolean
			 * @throws InterruptedException
			 */
			public boolean switchWindowWithNoTitle() throws InterruptedException {

				//log.info("***** In method 'switchWindowWithNoTitle()' *****");

				waitForPageLoad();
				TimeUnit.SECONDS.sleep(2);

				WebDriver webDriver = getWebDriver();
				Set<String> availableWindows = webDriver.getWindowHandles();
				availableWindows = webDriver.getWindowHandles();
				String winTitle;
				Boolean bSwitchWindow = false;

				for (String windowId : availableWindows) {
					winTitle = webDriver.switchTo().window(windowId).getTitle().trim();
					if (winTitle.length() == 0) {
						//log.info("Window '" + winTitle + "' switched successfully!!");
						webDriver.switchTo().window(windowId);
						bSwitchWindow = true;
						break;
					}

				}

				waitForPageLoad();

				//log.info("***** Exit method 'switchWindowWithNoTitle()' *****");
				return bSwitchWindow;
			}

			/**
			 * @Description : Switch window dialog.
			 * @param String :switchType ,winExpValue
			 * @return boolean
			 */
			public boolean switchWindowDialog(String switchType, String winExpValue) {

				try {

					//log.info("***** In method 'switchWindowDialog()' for: " + switchType + " Window Name:" + winExpValue + " *****");

					waitForPageLoad();
					TimeUnit.SECONDS.sleep(2);

					WebDriver webDriver = getWebDriver();
					String currentWindowId = webDriver.getWindowHandle();

					for (String winHandle : webDriver.getWindowHandles()) {
						String actualWindowTitle = webDriver.switchTo().window(winHandle).getTitle();
						if (actualWindowTitle.contains(winExpValue) && !currentWindowId.equals(winHandle)) {
							webDriver.switchTo().window(winHandle);
							break;
						}
					}
					// Thread.sleep(1000);
					waitForPageLoad();

					//log.info("***** EXIT method 'switchWindowDialog()' for: " + switchType + " Window Name:" + winExpValue + " *****");

				} catch (Exception ex) {

					return false;
				}

				return true;
			}

			
		/**
			 * @Description :  Switch window dialog.
			 * @param String : switchType, winExpValue ,winIdToIgnore
			 * @return boolean
			 */
			public boolean switchWindowDialog(String switchType, String winExpValue, String winIdToIgnore) {

				try {

					//log.info("***** IN method 'switchWindowDialog()' for: " + switchType + " Window Name:" + winExpValue + " *****");

					waitForPageLoad();
					TimeUnit.SECONDS.sleep(2);

					WebDriver webDriver = getWebDriver();
					String currentWindowId = winIdToIgnore;

					for (String winHandle : webDriver.getWindowHandles()) {
						String actualWindowTitle = webDriver.switchTo().window(winHandle).getTitle();
						if (actualWindowTitle.contains(winExpValue) && !currentWindowId.equals(winHandle)) {
							webDriver.switchTo().window(winHandle);
							break;
						}
					}
					waitForPageLoad();

					//log.info("***** EXIT method 'switchWindowDialog()' for: " + switchType + " Window Name:" + winExpValue + " *****");

				} catch (Exception ex) {

					return false;
				}

				return true;
			}

			


		/**
			 * @Description : switchToNewWindow : Switch To New Window
			 * @param : Set<String> winIds
			 * @return : void
			 * @throws InterruptedException 
			 */
			public void switchToNewWindow(Set<String> alreadyOpenedWinIds) throws InterruptedException {

				WebDriver webDriver = getWebDriver();
				waitForPageLoad();
				TimeUnit.SECONDS.sleep(2);

				Set<String> availableWindows = webDriver.getWindowHandles();
				availableWindows = webDriver.getWindowHandles();

				for(String winId : availableWindows)
				{
					if(!alreadyOpenedWinIds.contains(winId))
					{
						waitForPageLoad();
						webDriver.switchTo().window(winId);
						break;
					}
				}
				waitForPageLoad();

			}

			/**
			 * @Description : Maximize window.
			 */
			public void maximizeWindow() {

				try {
					getWebDriver().manage().window().maximize();
				} catch (Exception e) {

				}

			}

			

		/**
			 * @Description : Gets the windows count.
			 * @return int
			 */
			public int getWindowsCount() {

				try {

					return (getWebDriver().getWindowHandles().size());
				} catch (Exception e) {
					return 0;
				}

			}

			/**
			 * @Description : Checks if is alert present.
			 * @return boolean
			 */
			public boolean isAlertPresent() {
				try {
					WebDriverWait wait = new WebDriverWait(getWebDriver(), 10);
					wait.until(ExpectedConditions.alertIsPresent());

					return true;
				} // try
				catch (Exception Ex) {
					return false;
				} 
			} 



			/**
			 *  @Description : Switch to alert.
			 */
			public void switchToAlert() {
				try {
					getWebDriver().switchTo().alert();
				} 
				catch (Exception e) {

				}

			}

			/**
			 * @Description : Checks if is selected.
			 * @param Element: elem
			 * @return boolean
			 */
		/*	public boolean isSelected(Element elem) {
				try {
					WebElement webElem = (WebElement) elem.getNative();
					return (webElem.isSelected());

				} catch (Exception e) {
					return false;
				}
			}
*/
			/**
			 * @Description : Checks if is enabled.
			 * @param Element: elem
			 * @return boolean
			 */
			/*public boolean isEnabled(Element elem) {
				try {
					WebElement webElem = (WebElement) elem;
					return (webElem.isEnabled());

				} catch (Exception e) {
					return false;
				}
			}
*/
			/**
			 * @Description : Gets the text.
			 * @param Element: element
			 * @return String
			 */
			/*public String getText(Element element) {

				WebElement we = (WebElement) element.getNative();
				String text = we.getText().trim();
				return text;

			}
*/
			/**
			 * @Description :Checks if is data present.
			 * @param String: data
			 * @return boolean
			 */
			public boolean isDataPresent(String data) {
				try {
					if (data.isEmpty() || data.length() == 0 || data == null || data.equals("null")) {
						return false;
					} else {
						return true;
					}

				} catch (Exception e) {
					return false;
				}
			}

			/**
			 * @Description : Open URL.
			 * @param String: url
			 * @return boolean
			 */
			public boolean openURL(String url) {
				try {
					//log.info("***** In method 'openURL()' for URL: " + url + " *****");

					getWebDriver().get(url);
					// Thread.sleep(500);
					waitForPageLoad();
					maximizeWindow();

					//log.info("***** Exit method 'openURL()' for URL: " + url + " *****");
				} catch (Exception ex) {
					return false;
				}

				return true;
			}

			


		/**
			 * @Description :Gets the title.
			 * @return String
			 */
			public String getTitle() {
				try {

					return (getWebDriver().getTitle());

				} catch (Exception ex) {
					return null;
				}

			}

			/**
			 * @Description : Gets the all from dropdown.
			 * @param Element : elem
			 * @return the all from dropdown
			 */
		/*	public List getAllFromDropdown(Element elem) {
				WebElement we = (WebElement) elem.getNative();
				Select dropdown = new Select(we);

				return dropdown.getOptions();
			}
*/
			/**
			 * @Description : Gets the current date.
			 * @return String
			 */
			public String getCurrentDate() {
				try {

					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Date date = new Date();
					return (dateFormat.format(date));

				} catch (Exception ex) {
					return null;
				}

			}

			/**
			 * @Description : closeBrowser : close Browser
			 * @return void
			 */
			public void closeBrowser() {
				try {
					getWebDriver().close();

				} catch (Exception ex) {

				}

			}

			/**
			 * @Description : Checks if is text displayed.
			 * @param Element: elem
			 * @return boolean
			 */
			/*public boolean isTextDisplayed(Element elem) {
				try {

					String text = getText(elem);
					if (text.isEmpty() || text.length() == 0) {
						return false;
					} else {
						return true;
					}

				} catch (Exception ex) {

					return false;
				}

			}
*/
			







		/**
			 * @Description : Gets the page source.
			 * @return String
			 */
			public String getPageSource() {
				try {

					return getWebDriver().getPageSource();

				} catch (Exception ex) {

					return null;
				}

			}

			/**
			 * @Description :Action click.
			 * @param Element: element
			 * @return boolean
			 */
		/*	public boolean actionClick(Element element) throws Exception {
				try {
					WebElement webElement = (WebElement) element.getNative();
					Actions actions = new Actions(getWebDriver());
					if(element.getValue().length() > 15 && element.getValue().length() < 20)
						actions.moveToElement(webElement, 30, 8).click().build().perform();

					else if(element.getValue().length() >= 20){
						actions.moveToElement(webElement, 10, 5).click().build().perform();
					}
					else
						actions.moveToElement(webElement).click().build().perform();
				} catch (Exception ex) {
					//log.error(ex);
					throw new RuntimeException(ex.fillInStackTrace());

				}
				return true;
			} 
			public boolean actionDoubleClick(Element element) throws Exception {
				try {
					WebElement webElement = (WebElement) element.getNative();
					Actions actions = new Actions(getWebDriver());
					if(element.getValue().length() > 15 && element.getValue().length() < 20)
						actions.moveToElement(webElement, 30, 8).doubleClick().build().perform();
					else if(element.getValue().length() >= 20){
						actions.moveToElement(webElement, 10, 5).doubleClick().build().perform();
					}
					//else
					actions.moveToElement(webElement).doubleClick().build().perform();
				} catch (Exception ex) {
					//log.error(ex);
					throw new RuntimeException(ex.fillInStackTrace());

				}
				return true;
			} 



*/
























			/**
			 * @Description :Action click.
			 * @param Element: element
			 * @return boolean
			 */
		/*public boolean moveToElementAndClick(Element element) throws Exception {
				try {
					WebElement webElement = (WebElement) element.getNative();
					Actions actions = new Actions(getWebDriver());
					actions.moveToElement(webElement).click().build().perform();
				} catch (Exception ex) {
					//log.error(ex);
					throw new RuntimeException(ex.fillInStackTrace());

				}
				return true;
			}*/
 

			/**
			 * @Description : JS click.
			 * @param Element:element
			 * @return boolean
			 */
			/*public boolean JSClick(Element element) {
				try {
					// WebElement webElement = (WebElement) element.getNative();

					WebElement webElement = getWebDriver().findElement(By.xpath("//input[@id='ctl00_MainContentHolder_ucOfferScript_chkScriptRead']"));
					JavascriptExecutor jsexecutor = (JavascriptExecutor) getWebDriver();

					jsexecutor.executeScript("arguments[0].click();", webElement);

				} catch (Exception ex) {
					//log.error(ex);
					return false;
				}
				return true;
			}

*/			

		/**
			 * @Description : Action press key.
			 * @param key : key
			 * @return boolean
			 */
			public boolean actionPressKey(Keys key) {
				try {
					Actions actions = new Actions(getWebDriver());
					actions.sendKeys(key).perform();
					// actions.keyDown(key).keyDown(key).build().perform();
					// actions.click(webElement).build().perform();
				} catch (Exception ex) {
					//log.error(ex);
					return false;
				}
				return true;
			}

			/**
			 * @Description :Gets the selected option.
			 * @param Element : elem
			 * @return String
			 */
			/*public String getSelectedOption(Element elem) {
				try {
					WebElement webElement = (WebElement) elem.getNative();
					Select sel = new Select(webElement);
					String text = sel.getFirstSelectedOption().getText();
					return text;

				} catch (Exception ex) {
					//log.error(ex);
					return null;
				}

			}
*/







			/**
			 * @Description : No ofwindows.
			 * @return int
			 */
			public int noOfwindows() {

				WebDriver webDriver = getWebDriver();

				Set<String> listValues = null;

				listValues = webDriver.getWindowHandles();
				return listValues.size();

			}






























			/**
			 *  @Description :Close all windows.
			 */
			public void closeAllWindows() {
				try {

					getWebDriver().quit();

				} catch (Exception ex) {

				}

			}

			/**
			 * @Description :Gets the count.
			 * @param String : str
			 * @return int
			 */
			public int getCount(String str) {

				String subString = "";
				int iend = str.indexOf("{");
				if (iend != -1) {
					subString = str.substring(iend + 1, str.length() - 1);
				}
				return getWebDriver().findElements(By.xpath(subString)).size();
			}


			/**
			 * @Description :Gets the all elements.
			 * @param Element : elem
			 * @return Elements[]
			 */
			// to close the current browser
		/*	public Element[] getAllElements(Element elem) {
				try {

					return (elem.getAll());

				} catch (Exception ex) {

					return null;
				}

			}
*/
			/**
			 * @Description : Cancel alert.
			 */
			public void cancelAlert() {
				try {
					WebDriverWait wait = new WebDriverWait(getWebDriver(), 30);
					wait.until(ExpectedConditions.alertIsPresent());
					Alert alert = getWebDriver().switchTo().alert();
					alert.dismiss();
				} // try
				catch (Exception e) {

				}

			}

			/**
			 * @Description :Action mouse over.
			 * @param Element :element
			 * @return boolean
			 */
			/*public boolean actionMouseOver(Element element) {
				//log.debug("Begin of  DriverMethod.actionMouseOver()");
				try {
					WebElement webElement = (WebElement) element.getNative();
					Actions actions = new Actions(getWebDriver());
					actions.moveToElement(webElement).perform();
					//log.debug("End of  DriverMethod.actionMouseOver()");
				} catch (Exception ex) {
					//log.error(ex.getStackTrace());
					return false;
				}
				return true;

			}*/

			/**
			 * @Description :Split values.
			 * @param String :strValues , delimiter
			 * @return the string[]
			 */
			public String[] splitValues(String strValues, String delimiter) {
				String values[] = strValues.split(delimiter);

				String formattedArray[] = new String[values.length];

				for (int i = 0; i < values.length; i++) {
					formattedArray[i] = values[i].trim();
				}

				return formattedArray;

			}

			/**
			 * @Description :Toggle check box.
			 * @param Element : element
			 * @param String : action
			 * @return boolean
			 */
			/*public boolean toggleCheckBox(Element element, String action) {
				try {
					//log.info("Method 'toggleCheckBox' IN");

					element.waitFor(5, TimeUnit.SECONDS, WAIT_FOR.CLICKABLE, "");

					if ((action.equalsIgnoreCase("Check") && !isSelected(element)) || (action.equalsIgnoreCase("Uncheck") && isSelected(element))) {
						element.click();
					}

					element.click();

					//log.info("Method 'toggleCheckBox' OUT");

				} catch (Exception ex) {

					return false;
				}

				return true;
			}
*/
			/**
			 * @Description :Select multiple values from dropdown.
			 * @param Element : element
			 * @param String [] : subStrings
			 * @return boolean
			 */
		/*	public boolean selectMultipleValuesFromDropdown(Element element, String[] subStrings) {
				//log.debug("Begin of  DriverMethod.actionMouseOver()");
				try {
					String text;
					Select sel = new Select((WebElement) element.getNative());
					List<WebElement> options = sel.getOptions();
					Actions act = new Actions(getWebDriver());
					//sel.deselectAll();
					act.keyDown(Keys.CONTROL).build().perform();
					for (String str : subStrings) {
						for (WebElement opt : options) {
							text = opt.getText().trim();
							if (text.equalsIgnoreCase(str)) {
								opt.click();
								break;
							}
						}
					}
					act.keyUp(Keys.CONTROL).build().perform();

				} catch (Exception ex) {
					//log.error(ex.getStackTrace());
					return false;
				}
				return true;

			}

*/			/**
			 * @Description :Click quick launch.
			 * @param int x , y
			 * @return boolean
			 */
			public boolean clickQuickLaunch(int x, int y) {

				try {
					//log.info("Method 'clickQuickLaunch' starts here");
					// There is  a mouse event which take place in this method. Hence need of hard wait. WaitForPageLoad will not suffice the need as the page would be loaded.
					Thread.sleep(200);
					// while (System.currentTimeMillis() < System.currentTimeMillis() +
					// (2 * 1000)) {}

					Robot r = new Robot();
					r.mouseMove(x, y);
					// There is  a mouse event which take place in this method. Hence need of hard wait. WaitForPageLoad will not suffice the need as the page would be loaded.
					Thread.sleep(1000);
					// while (System.currentTimeMillis() < System.currentTimeMillis() +
					// (1 * 1000)) {}

					r.mousePress(InputEvent.BUTTON1_MASK);
					r.mouseRelease(InputEvent.BUTTON1_MASK);
					// There is  a mouse event which take place in this method. Hence need of hard wait. WaitForPageLoad will not suffice the need as the page would be loaded.
					Thread.sleep(2000);
					// while (System.currentTimeMillis() < System.currentTimeMillis() +
					// (2 * 1000)) {}

					//log.info("Method 'clickQuickLaunch' ends here");

				} catch (Exception ex) {

					return false;
				}

				return true;
			}


			/**
			 * @Description :Click scroll bar
			 * @param int x , y
			 * @return boolean
			 */
			public boolean clickScrollbar(int x, int y) {

				try {
					//log.info("Method 'clickQuickLaunch' starts here");
					// There is  a mouse event which take place in this method. Hence need of hard wait. WaitForPageLoad will not suffice the need as the page would be loaded.
					Thread.sleep(200);
					// while (System.currentTimeMillis() < System.currentTimeMillis() +
					// (2 * 1000)) {}

					Robot r = new Robot();
					r.mouseMove(x, y);
					// There is  a mouse event which take place in this method. Hence need of hard wait. WaitForPageLoad will not suffice the need as the page would be loaded.
					Thread.sleep(1000);
					// while (System.currentTimeMillis() < System.currentTimeMillis() +
					// (1 * 1000)) {}

					r.mousePress(InputEvent.BUTTON1_MASK);
					r.mouseRelease(InputEvent.BUTTON1_MASK);
					// There is  a mouse event which take place in this method. Hence need of hard wait. WaitForPageLoad will not suffice the need as the page would be loaded.
					Thread.sleep(2000);
					// while (System.currentTimeMillis() < System.currentTimeMillis() +
					// (2 * 1000)) {}

					//log.info("Method 'clickQuickLaunch' ends here");

				} catch (Exception ex) {

					return false;
				}

				return true;
			}

			/**
			 * @Description : Close Word Document 
			 * @return boolean
			 */
			public boolean closeWordDocument() {

				try {
					Thread.sleep(15000);
					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_ALT);
					r.keyPress(KeyEvent.VK_F4);
					r.keyRelease(KeyEvent.VK_ALT);
					r.keyRelease(KeyEvent.VK_F4);
					Thread.sleep(3000);

				} catch (Exception ex) {

					return false;
				}

				return true;
			}



			/**
			 * @Description :Gets the todays date.
			 * @return String
			 */
			public String getTodaysDate() {

				String todayAsString = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
				return todayAsString;
			}

			/**
			 * @Description :Wait for alert.
			 * @return boolean
			 */
			public boolean WaitForAlert() {

				try {
					//log.info("Method 'clickQuickLaunch' starts here");
					WebDriver driver = getWebDriver();
					WebDriverWait wait = new WebDriverWait(driver, 50);
					wait.until(ExpectedConditions.alertIsPresent());
				} catch (Exception ex) {

					return false;
				}

				return true;
			}

			/*   *//**
			 * @Description :Wait for window to load.
			 * @param int : WaitTime
			 * @return boolean
			 *//*
		    public boolean WaitForWindowToLoad(int WaitTime) {

		        try {
		            //log.info("Method 'clickQuickLaunch' starts here");
		            WebDriver driver = getWebDriver();
		            driver.manage().timeouts().pageLoadTimeout(WaitTime, TimeUnit.SECONDS);
		        } catch (Exception ex) {

		            return false;
		        }

		        return true;
		    }
			  */
			/**
			 * @Description : Wait for frameto switch by index.
			 * @param int : Index
			 * @return boolean
			 */
			public boolean WaitForFrametoSwitchByIndex(int Index) {

				try {
					//log.info("Method 'clickQuickLaunch' starts here");
					WebDriver driver = getWebDriver();
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Index));
				} catch (Exception ex) {

					return false;
				}

				return true;
			}

			/**
			 * @Description : Wait for frameto switch by name.
			 * @param String : frameName
			 * @return boolean
			 */
			public boolean WaitForFrametoSwitchByName(String frameName) {

				try {
					//log.info("Method 'clickQuickLaunch' starts here");
					WebDriver driver = getWebDriver();
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
				} catch (Exception ex) {

					return false;
				}

				return true;
			}

			/**
			 * @Description :Press enter.
			 * @return boolean
			 */
			public boolean pressEnter() {
				try {
					//log.info("Method 'clickQuickLaunch' starts here");
					WebDriver driver = getWebDriver();
					Actions act = new Actions(driver);
					act.keyDown(Keys.ENTER);
					act.keyUp(Keys.ENTER);
				} catch (Exception ex) {

					return false;
				}

				return true;
			}
			/*
			 *//**
			 * @Description : Page load timer.
			 *//*
		    public void pageLoadTimer() {

		        try {
		            getWebDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		        } catch (Exception ex) {

		        }
		    }*/

			/**
			 * @Description : Dismiss alert.
			 */
			public void dismissAlert() {
				try {
					isAlertPresent();
					Alert currentAlert = getWebDriver().switchTo().alert();
					currentAlert.dismiss();
				} // try
				catch (Exception e) {

				}

			}

			/**
			 * @Description :Checks if is image present.
			 * @param Element : imgElem
			 * @return boolean
			 */
		/*	public boolean isImagePresent(Element imgElem) {
				try {
					//log.info("Method 'isImagePresent' starts here");

					WebElement we = (WebElement) imgElem.getNative();
					String src = we.getAttribute("src");

					if (!src.equalsIgnoreCase("null") && src.length() > 1) {
						return true;
					} else {
						return false;
					}

				} catch (Exception ex) {

					return false;
				}

			}
*/
			/**
			 * @Description : Gets the connection.
			 * @return Connection
			 */
			/*public Connection getConnection() {

				Connection connection = null;

				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					connection = DriverManager.getConnection("jdbc:oracle:thin:@ldap://oid:389/ngsot101,cn=OracleContext,dc=allstate,dc=com", "NGTESTI7USR", "NGTESTI7USR");

				} catch (ClassNotFoundException | SQLException e) {
					return null;

				}
				return connection;
			}

*/			/**
			 * @Description : Checks if is window closed after operation.
			 * @param int :expectedNoOfWindowsAfterCloser
			 * @throws InterruptedException
			 */
			public void IsWindowClosedAfterOperation(int expectedNoOfWindowsAfterCloser) throws InterruptedException {
				int b = 0;
				while (b <= 6) {
					int a = getWindowsCount();
					if (a == expectedNoOfWindowsAfterCloser) {
						break;
					}
					waitForPageLoad();

					b++;

				}
			}

			/**
			 * @Description :Gets the driver.
			 * @return Webdriver
			 */
			public WebDriver getDriver() {

				return getWebDriver();

			}

			/*    *//**
			 * @Description : Wait fluently for drop down.
			 * @param Element : elem
			 * @param int : timeout
			 * @return boolean
			 *//*
		    public boolean waitFluentlyForDropDown(Element elem, int timeout) {
		        if (waitForPageLoad())
		            return true;
		        else
		            return false;
		    }*/

			/*   *//**
			 * @Description :Wait fluently for button.
			 * @param Element : elem
			 * @param int :timeout
			 * @return boolean
			 * @throws InterruptedException the interrupted exception
			 *//*
		    public boolean waitFluentlyForButton(Element elem, int timeout) throws InterruptedException {
		        if (waitForPageLoad())
		            return true;
		        else
		            return false;

		    }*/

			/**
			 * @Description :Wait explicit.
			 * @param Element : elem
			 * @param int : timeout
			 * @return WebElement
			 */
			/*private WebElement waitExplicit(Element elem, int timeout) {
				WebDriver driver = getWebDriver();
				WebElement webelem = null;
				WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
				webelem = (WebElement) elem.getNative();
				final Select dropdown = new Select(webelem);
				webDriverWait.until(new Function<WebDriver, Boolean>() {

					@Override
					public Boolean apply(WebDriver d) {
						return (!dropdown.getOptions().isEmpty());
					}
				});
				return webelem;
			}*/

			/**
			 * @Description : Gets the all from dropdown.
			 * @param Element : elem
			 * @param int : timeout
			 * @return List<WebElement>
			 */
			/*public List<WebElement> getAllFromDropdown(Element elem, int timeout) {
				WebElement we = waitExplicit(elem, timeout);
				Select dropdown = new Select(we);
				return dropdown.getOptions();
			}

*/			/*
			 * public WebElement waitExplicitvisibility(Element elem, int timeout) {
			 * WebDriver driver = getWebDriver(); WebElement webelem = null;
			 * WebDriverWait webDriverWait = new WebDriverWait(driver, timeout); webelem
			 * = (WebElement) elem.getNative();
			 * webDriverWait.until(ExpectedConditions.visibilityOf(webelem)); return
			 * webelem; }
			 */

			/*
			 * public void waitForPleaseWait() { WebDriver driver = getWebDriver(); new
			 * WebDriverWait(driver,
			 * 30).until(ExpectedConditions.visibilityOfElementLocated
			 * (By.xpath("//span[@id='PleaseWaitMessage']"))); new WebDriverWait(driver,
			 * 30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
			 * "//span[@id='PleaseWaitMessage']")));
			 * 
			 * }
			 */

			/*    *//**
			 * @Description : Wait and click.
			 * @param Element : elem
			 * @throws Exception 
			 *//*
		    public void waitAndClick(Element elem) throws Exception {
		        if (waitForPageLoad()) {
		            elem.click();
		        }

		    }*/

			/*   *//**
			 * @Description : Wait and set value.
			 * @param Element : elem
			 * @param String :value
			 * @throws Exception
			 *//*
		    public void waitAndSetValue(Element elem, String value) throws Exception {
		        if (waitForPageLoad()) {
		            elem.setValue(value);
		        }

		    }*/
			/*
			 *//**
			 * @Description : Wait for an element to be visible.
			 * @param Element : elem
			 * @throws Exception
			 *//*
		    public void waitForAnElementToBeVisible(Element elem) throws Exception {

		        waitForPageLoad();

		    }*/

			/**
			 * @Description : Checks if is element present.
			 * @param Element : elem
			 * @return boolean
			 */
	/*		public boolean isElementPresent(Element elem) {
				try {

					elem.isPresent();


				} catch (Exception ex) {
					return false;
				}
				return true;
			}*/

			/**
			 * @Description : Checks if is element Visible.
			 * @param Element : elem
			 * @return boolean
			 */
			/*public boolean isElementVisible(Element elem) {
				try {

					return elem.isVisible();

				} catch (Exception ex) {
					return false;
				}
			}
*/
			/**
			 * @Description : Close all browsers.
			 * @param : String id
			 */
			public void closeAllBrowsers(String id) {
				try {

					Set<String> windowHandles = getWebDriver().getWindowHandles();

					for (String s : windowHandles) {
						if (!id.equalsIgnoreCase(s)) {
							getWebDriver().switchTo().window(s);
							getWebDriver().close();
						}

					}

					getWebDriver().switchTo().window(id);

				} catch (Exception ex) {

				}

			}

			public void switchToNewWindow(int windowNumber) {
				Set < String > s = getWebDriver().getWindowHandles();   
				Iterator < String > ite = s.iterator();
				int i = 1;
				while (ite.hasNext() && i < 10) {
					String popupHandle = ite.next().toString();
					getWebDriver().switchTo().window(popupHandle);
					System.out.println("Window title is : "+getWebDriver().getTitle());
					if (i == 10) break;
					i++;
				}
			}



			/*    *//**
			 * @Description : Sets the value.
			 * @param String : str ,claimNumber
			 *//*
		    public void setValue(String str, String claimNumber) {
		        for (int i = 0; i < 10; i++) {

		            try {
		                String subString = "";
		                int iend = str.indexOf("{");
		                if (iend != -1) {
		                    subString = str.substring(iend + 1, str.length() - 1);
		                }
		                WebDriver webDriver = getWebDriver();
		                webDriver.findElement(By.xpath(subString)).sendKeys(claimNumber);
		                break;

		            } catch (Exception e) {
		                try {
		                    Thread.sleep(1000);
		                } catch (InterruptedException e1) {
		                    //log.info("Waiting for Element to appear in DOM");
		                }
		            }

		        }
		    }*/


			/**
			 * @Description : Close Window 
			 */
			public void closeAttachmentWindow() {

				try {
					// thread needed to perform following action by robot
					Thread.sleep(1500);
					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_ALT);
					r.keyPress(KeyEvent.VK_F4);
					r.keyRelease(KeyEvent.VK_ALT);
					r.keyRelease(KeyEvent.VK_F4);
					Thread.sleep(1500);

				} catch (Exception ex){ 
				} 
			}

			public void closeAttachmentWindow1() {

				try {
					Thread.sleep(1500);
					Actions action = new Actions(getWebDriver());
					action.keyDown(Keys.ALT).sendKeys(Keys.F4).keyUp(Keys.ALT);
					action.perform();
					//    action.keyUp(Keys.F4).build().perform();
					Thread.sleep(3000);
				} catch (Exception ex){ 
					System.out.println(ex);
				} 
			}


			/**
			 * @Description : JS click.
			 * @param Element:element
			 * @return boolean
			 */
		/*	public boolean JSScrollHorizontillay(Element ele) {
				try {

					JavascriptExecutor jsexecutor = (JavascriptExecutor) getWebDriver();
					//WebElement element = (WebElement) ele.getNative();
					//jsexecutor.executeScript("arguments[0].scrollIntoView(true);",element);
					jsexecutor.executeScript("scrollTo(3000,0);");


				} catch (Exception ex) {
					//log.error(ex);
					return false;
				}
				return true;
			}


			public void closeCurrentBrowser(String id) {
				try {

					Set<String> windowHandles = getWebDriver().getWindowHandles();

					for (String s : windowHandles) {
						if (id.equalsIgnoreCase(s)) {
							getWebDriver().switchTo().window(s);
							getWebDriver().close();
						}

					}

					getWebDriver().switchTo().window(id);

				} catch (Exception ex) {

				}
			}

*/

			/*
			 * @Description :used for clicking on quicklaunch.
			 * @param element - Element name, optionName - used to get data from pagedata.
			 * @return void
			 */
		/*	public void quickLaunch(Element element, String optionName) throws Exception
			{
				waitForPageLoad();

				WebElement webElement = (WebElement) element.getNative();

				PageDataManager dataManager = PageDataManager.instance(xFID);
				PageData pageData = dataManager.getPageData("QuickLaunch", optionName);

				int xoffset = Integer.parseInt(pageData.getData("xoffset"));
				int yoffset = Integer.parseInt(pageData.getData("yoffset"));

				element.click();
				TimeUnit.SECONDS.sleep(5);	
				//Used action methods for clicking on relative co-ordinates 
				Actions actions = new Actions(getWebDriver());
				actions.moveToElement(webElement, xoffset, yoffset).click().build().perform();

				TimeUnit.SECONDS.sleep(2);	
				waitForPageLoad();
			}
*/
			/*
			 * @Description : Switch to window using specific window handle.
			 */
		/*	public void switchToWindow(String parentWinID) {
				try {
					waitForPageLoad();
					TimeUnit.SECONDS.sleep(2);

					WebDriver driver = getWebDriver();
					driver.switchTo().window(parentWinID);

					waitForPageLoad();
				} catch (Exception e) {

				}

			}*/

			/**
			 * @Description : get alert text.
			 */
			public String getAlertText() {
				String alertText = null;
				try {
					Alert currentAlert = getWebDriver().switchTo().alert();
					alertText= currentAlert.getText();

				} // try
				catch (Exception e) {

				}
				return alertText;

			}


			/**
			 * @Description : JS scroll into view.
			 * @param Element:element
			 * @return boolean
			 */

		/*	public boolean scrollIntoViewClick(Element element) throws Exception {
				try {
					WebElement webElement = (WebElement) element.getNative();
					Actions actions = new Actions(getWebDriver());

					actions.moveToElement(webElement, 0, 0).click().build().perform();
				} catch (Exception ex) {
					//log.error(ex);
					throw new RuntimeException(ex.fillInStackTrace());

				}
				return true;
			}*/ 

			/**
			 * @Description : navigateDailyDatabase : Navigate Daily Database
			 * @return : void
			 */
			/*public void navigateDailyDatabase() {
				String dailyDatabaseURL = getApplicationUrl("DAILY_DATABASE");

				getWebDriver().get(dailyDatabaseURL);
				//log.info("Navigated to URL: " + dailyDatabaseURL);
			}
*/
			/**
			 * @Description : Switch window.
			 * @param String : switchType ,winExpValue
			 * @return boolean
			 */
			public boolean getWindow(String winExpValue) {

				//log.info("***** In method 'getWindow()' for: " + winExpValue + " *****");

				WebDriver webDriver = getWebDriver();
				boolean bgetWindow = false;
				String winActValue = "";
				Set<String> availableWindows = webDriver.getWindowHandles();
				if (!availableWindows.isEmpty()) 
				{
					for (String windowId : availableWindows) 
					{
						winActValue = webDriver.switchTo().window(windowId).getTitle().trim().toLowerCase();
						winExpValue = winExpValue.trim().toLowerCase();
						if (winActValue.contains(winExpValue)) {
							bgetWindow = true;
							//log.info("Window '" + winExpValue + "' switched successfully!!");
							getWebDriver().manage().window().maximize();
							break;
						}
					}

					//log.info("***** Exit method 'getWindow()' for: " + winExpValue + " *****");
				}

				return bgetWindow;
			}

			/**
			 * @Description :Select from dropdown by index.
			 * @param Element : element
			 * @param int : index
			 * 
			 */
	/*		public void selectByIndexFromDropdown(Element element, int index) {
				//log.debug("Begin of  DriverMethod.actionMouseOver()");
				try {

					Select sel = new Select((WebElement) element.getNative());
					sel.selectByIndex(index);


				} catch (Exception ex) {
					//log.error(ex.getStackTrace());

				}

			}


		*/	/**
			 * @Description : navigateTeamConnect : Used to navigate to Team Connect
			 * @return : void
			 */
			/*public void navigateTeamConnect() {
				String url = getApplicationUrl("TEAM_CONNECT_URL");
				getWebDriver().get(url);
				//log.info("Navigated to URL: " + url);
			}
*/


			/**
			 * @Description : Gets the current US timeZone date.
			 * @return String
			 */
			public String getCurrentTimeZoneDate() {
				try {

					Calendar c = Calendar.getInstance();
					c.setTimeZone(TimeZone.getTimeZone("US/Central"));
					Date date = c.getTime();
					SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String strDate = df.format(date);
					return strDate;

				} catch (Exception ex) {
					return null;
				}

			}

			/**
			 * @Description : compare Dates.
			 * @return String
			 */
		/*	public boolean compareDates(String expectedDate, String actualDate) {

				boolean status = false;
				try {
					SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					Date expected = df.parse(expectedDate);
					Date actual = df.parse(actualDate);

					Assert.assertEquals(expected,actual);
					status= true;

				} catch (Exception ex) {
					System.out.println(ex);
					return status;
				}

				return status;
			*///}




			/**
			 * @Description :Action click.
			 * @param Element: element
			 * @return boolean
			 */
		/*	public void setData(Element element,String data) throws Exception {
				try {
					WebElement webElement = (WebElement) element.getNative();
					webElement.sendKeys(data);

				} catch (Exception ex) {
					//log.error(ex);f
					throw new RuntimeException(ex.fillInStackTrace());

				}
			} 
*/

			/**
			 * @Description : get Future Hrs.
			 * @return String
			 */
			/*public String getFutureHrs(int futureHrs) {

				try {

					Calendar c = Calendar.getInstance();
					c.setTimeZone(TimeZone.getTimeZone("US/Central"));
					int hour = c.get(Calendar.HOUR_OF_DAY);
					int updatedTime = 0;

					if(hour < 10){
						updatedTime = hour+futureHrs;
						return "0"+updatedTime;


					}else 
						return ""+hour;

				} catch (Exception ex) {
					return null;
				}

			}
*/



			/**
			 * @Description :Press enter.
			 * @return boolean
			 */
		/*	public boolean pressF12(WebElement element) {
				try {
					//log.info("Method 'pressF12' starts here");
					Actions actions = new Actions(getWebDriver());

					actions.moveToElement(element).click().build().perform();
					actions.sendKeys(Keys.F12);
					actions.perform();			


				} catch (Exception ex) {

					return false;
				}

				return true;
			}
*/
			/**
			 * @Description :Press Tab
			 * @return boolean
			 */
			/*public boolean pressTab() {
				try {
					//log.info("Method 'pressTab' starts here");
					Actions actions = new Actions(getWebDriver());

					actions.sendKeys(Keys.TAB);
					actions.build().perform();			


				} catch (Exception ex) {

					return false;
				}

				return true;
			}*/
			/**
			 * @Description :Press Tab
			 * @return boolean
			 */
			/*public boolean uploadAttachments(String filePath) {
				try {
					//log.info("Method 'pressTab' starts here");
					TimeUnit.SECONDS.sleep(16);	
					StringSelection stringSelection = new StringSelection(filePath);
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
					System.out.println(stringSelection.toString());
					Robot r = new Robot();

					r.keyPress(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					System.out.println("DONE");

				} catch (Exception ex) {

					return false;
				}

				return true;
			}

*/

			/**
			 * @Description : Scroll  the page down
			 * @return boolean
			 */
			public boolean scrollPageDown(int height) {
				try {
					//log.info("Method 'scrollPageDown' starts here");

					WebDriver driver = getWebDriver();
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					String arg = "window.scrollBy(0,"+height+")";
					jse.executeScript(arg, "");

				} catch (Exception ex) {

					return false;
				}

				return true;
			}


			/**
			 * @Description : navigateEncompass : Used to login Encompass
			 * @return : void
			 */
			/*public void navigateERL() {
				try {
					String encompassUrl = getApplicationUrl("ERL_URL");
					getWebDriver().get(encompassUrl);
					//log.info("Navigated to URL: " + encompassUrl);
				} catch (Exception ex) {
					//log.error(ex.getStackTrace());
				}
			}*/
			/**
			 * @Description : navigateEncompass : Used to login Encompass
			 * @return : void
			 */
		/*	public void navigateEncompass() {
				try {
					String encompassUrl = getApplicationUrl("ENCOMPASS_URL");
					getWebDriver().get(encompassUrl);
					//log.info("Navigated to URL: " + encompassUrl);
				} catch (Exception ex) {
					//log.error(ex.getStackTrace());
				}

			}
*/

			/** @Description : navigateToXactAnalysis : Used to login XactAnalysis 
			 *  @return : void
			 * @param : String :userId
			 */
		/*	public void navigateToXactAnalysis() {
				try {
					String xactAnalysis = getApplicationUrl("XACT_ANALYSIS");
					getWebDriver().get(xactAnalysis);
					//log.info("Navigated to URL: " + xactAnalysis);
				} catch (Exception ex) {
					//log.error(ex.getStackTrace());
				}

			}
		*/	/**
			 * @Description : getCurrentURL : get current URL
			 * @return : void
			 * @param : String :userId
			 */
			public String getCurrentURL() {
				String url ="";
				try {
					url = getWebDriver().getCurrentUrl();


					//log.info("Current URL: " + url);
				} catch (Exception ex) {
					//log.error(ex.getStackTrace());
				}
				return url;

			}


			/**
			 * @Description : navigateToURL : navigate to given URL
			 * @return : void
			 * @param : String :userId
			 */
			public void navigateToURL(String url) {
				try {

					getWebDriver().get(url);
					//log.info("Navigated to URL: " + url);
				} catch (Exception ex) {
					//log.error(ex.getStackTrace());
				}

			}
			/*
			 * @Description :used for clicking on quicklaunch.
			 * @param element - Element name, optionName - used to get data from pagedata.
			 * @return void
			 */

		/*	public void selectQuickLaunchOption(Element element, String optionName) throws Exception
			{
				waitForPageLoad();

				WebElement webElement = (WebElement) element.getNative();

				PageDataManager dataManager = PageDataManager.instance(xFID);
				PageData pageData = dataManager.getPageData("QuickLaunch", optionName);

				int xoffset = Integer.parseInt(pageData.getData("xoffset"));
				int yoffset = Integer.parseInt(pageData.getData("yoffset"));


				TimeUnit.SECONDS.sleep(5); 
				//Used action methods for clicking on relative co-ordinates 
				Actions actions = new Actions(getWebDriver());
				actions.moveToElement(webElement, xoffset, yoffset).click().build().perform();

				waitForPageLoad();
			}
*/
			/**
			 * @Description :Press Down Key
			 * @return boolean
			 */
			public boolean pressDownKey() {
				try {
					//log.info("Method 'presDown' starts here");
					Actions actions = new Actions(getWebDriver());
					actions.sendKeys(Keys.DOWN);
					actions.build().perform();			
				} catch (Exception ex) {
					return false;
				}
				return true;
			}

			/**
			 * @Description : Gets the value.
			 * @param Element: element
			 * @return String
			 */
			/*public String getValue(Element element) {

				WebElement we = (WebElement) element.getNative();
				String text = we.getAttribute("value").trim();
				return text;

			}
*/
			/**
			 * @Description : Gets the random number of 7 digit.
			 * @param Element: element
			 * @return String
			 */
			public String getRandomNumber() {

				Random rnd = new Random(); 
				int n = 1000000 + rnd.nextInt(9000000);
				String newNumber = Integer.toString(n);
				return newNumber;

			}

			/**
			 * @Description : navigateEncompass : Used to login Encompass
			 * @return : void
			 */
			/*public void navigateEncompassERL() {
				try {
					String encompassUrl = getApplicationUrl("ENCOMPASS_ERL_URL");
					getWebDriver().get(encompassUrl);
					//log.info("Navigated to URL: " + encompassUrl);
				} catch (Exception ex) {
					//log.error(ex.getStackTrace());
				}

			}
*/
			/**
			 * @Description : Gets the current year.
			 * @return String
			 */
			public String getCurrentYear(){
				try {

					Calendar now = Calendar.getInstance();   
					int year = now.get(Calendar.YEAR);  
					return (Integer.toString(year));

				} catch (Exception ex) {
					return null;
				}

			}

			/**
			 * @Description : Gets the future date.
			 * @return String
			 */
			public String getFutureDate(int noOfDays) {
				try {

					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

					Calendar now = Calendar.getInstance();
					now.add(Calendar.DATE, noOfDays);
					Date date = now.getTime(); 
					return (dateFormat.format(date));

				} catch (Exception ex) {
					return null;
				}

			}

			/*
			 * @Description : This method is used to get the value of any specific field from the Test Data.xml file
			 * @param : recordType -the pageName, fieldName - test data variable name
			 */

			/*public String getData(String recordType,String fieldName){

				PageDataManager dataManager = PageDataManager.instance(xFID);

				PageData pageData = dataManager.getPageData(recordType);

				return pageData.getData(fieldName).trim();

			}
*/
			/*
			 * @Description : This method is used to get the value of any specific field from the Test Data.xml file
			 * @param : recordType -the pageName, fieldName - test data variable name
			 */

		/*	public String getData(String recordId, String recordType,String fieldName){

				PageDataManager dataManager = PageDataManager.instance(xFID);

				PageData pageData = dataManager.getPageData(recordType, recordId);

				return pageData.getData(fieldName).trim();

			}
*/
			/**
			 * @Description : Action press key.
			 * @param key : key
			 * @return boolean
			 */
			public boolean pressMultipleKeys() {
				try {

					Actions keyAction = new Actions(getWebDriver()); 
					keyAction.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("s").keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).perform();

					TimeUnit.SECONDS.sleep(3);

				} catch (Exception ex) {
					//log.error(ex);
					return false;
				}
				return true;
			}

		//}



	

//}

/*public int getExcelNumberData(String sheetName , int rowNum , int columnNum) throws InvalidFormatException, IOException{

	//String path="C:\\Users\\SANTOSH CHAVAN\\Desktop\\TestData.xlsx";
	String path="C:\\Users\\SANTOSH CHAVAN\\Desktop\\Book1.xlsx";
	
	  
    // get the test from excel
FileInputStream fis = new FileInputStream(path);
         Workbook wb = WorkbookFactory.create(fis);

         Sheet sh = wb.getSheet(sheetName);
         Row row = sh.getRow(rowNum);


         int data = (int) row.getCell(columnNum).getNumericCellValue();
         
         //String data = row.getCell(columnNum).getStringCellValue();
return data;




}	

*/}
