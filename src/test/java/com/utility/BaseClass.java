package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	public String getProjectPath() {
		return System.getProperty("user.dir");

	}

	public void visibilityOfElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\config\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}

	public void browserLaunch(String browserType) {
		switch (browserType) {
		case "CHROME":
			driver = new ChromeDriver();

			break;
		case "IE":
			driver = new InternetExplorerDriver();

			break;
		case "EDGE":
			driver = new EdgeDriver();

			break;
		case "FIREFOX":
			driver = new FirefoxDriver();

			break;

		default:
			break;
		}
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public void loadURL(String url) {

		driver.get(url);
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public WebElement locateElementUsingId(String idValue) {

		WebElement findElement = driver.findElement(By.id(idValue));

		return findElement;

	}

	public void elementSendKeys(WebElement element, String data) {
		visibilityOfElement(element);
		element.sendKeys(data);

	}

	public void selectOptionByText(WebElement element, String text) {
		visibilityOfElement(element);
		Select select = new Select(element);
		select.selectByValue(text);

	}

	public void elementSendKeysEnter(WebElement element, String data) {
		visibilityOfElement(element);
		element.sendKeys(data, Keys.ENTER);

	}

	public String elementGetText(WebElement element) {
		visibilityOfElement(element);
		String text = element.getText();
		return text;
	}

	public static WebElement locateElementUsingName(String nameValue) {
		WebElement findElement = driver.findElement(By.name(nameValue));

		return findElement;

	}

	public void elementClick(WebElement element) {
		visibilityOfElement(element);
		element.click();

	}

	public void mouseOverAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void switchToChildWindow() {
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String eachWindow : windowHandles) {
			if (!windowHandle.equals(eachWindow)) {
				driver.switchTo().window(eachWindow);
			}
		}
	}

	public void sleep() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close() {

		driver.close();
	}

	private static void quit() {

		driver.quit();
	}

	public static void refresh() {

		driver.navigate().refresh();
	}

	/*
	 * public String excelRead(String filePath, String sheetName, int rowIndex, int
	 * cellIndex) throws IOException {
	 * 
	 * File file = new File(filePath);
	 * 
	 * FileInputStream input = new FileInputStream(file);
	 * 
	 * Workbook book = new XSSFWorkbook(input);
	 * 
	 * Sheet sheet = book.getSheet(sheetName);
	 * 
	 * Row row = sheet.getRow(rowIndex);
	 * 
	 * Cell cell = row.getCell(cellIndex);
	 * 
	 * int cellType = cell.getCellType();
	 * 
	 * String value = null;
	 * 
	 * if (cellType == 1) {
	 * 
	 * value = cell.getStringCellValue();
	 * 
	 * System.out.println(value);
	 * 
	 * } else {
	 * 
	 * if (DateUtil.isCellDateFormatted(cell)) {
	 * 
	 * Date d = cell.getDateCellValue();
	 * 
	 * SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
	 * 
	 * value = simple.format(d);
	 * 
	 * System.out.println(value);
	 * 
	 * } else {
	 * 
	 * double d = cell.getNumericCellValue();
	 * 
	 * long l = (long) d;
	 * 
	 * value = String.valueOf(l);
	 * 
	 * System.out.println(value);
	 * 
	 * }
	 * 
	 * } return value;
	 * 
	 * }
	 */

}
