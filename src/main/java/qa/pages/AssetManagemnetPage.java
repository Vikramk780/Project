package qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssetManagemnetPage {

	private WebDriver driver;
	Waithelper waithelper;

	private By createbtn = By.xpath("(//p[contains(text(),\"Add\")])[1]");

	private By devicename = By.xpath("//input[@id='device_list_name']");
	private By description = By.xpath("//input[@id='description']");
	private By devicetype = By.xpath("//input[@id='device_type']");
	private By alkatel = By.xpath("//li[normalize-space()='Alcatel']");
	private By choosebtn = By.xpath("//label[@for='item']");
	private By savebtn = By.xpath("//button[@type='submit']");
	private By searchbar = By.xpath("//button[@title='Search']");
	private By searchbartextfield = By.xpath("//input[@placeholder=\"Search\"]");
	private By select = By.xpath("//td[3]");
	private By cross = By
			.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]");

	private By action = By.xpath("//div[@aria-label='Table Toolbar']//div[4]");

	public AssetManagemnetPage(WebDriver driver) {
		this.driver = driver;
		waithelper = new Waithelper(driver);
	}

	public void createAsset() throws InterruptedException, AWTException {
		Robot rr = new Robot();
		waithelper.forThisElementWait(createbtn,20).click();

		String randomeBTUname = RandomStringUtils.random(4, "ab_cd");
		String randomeBTUname1 = RandomStringUtils.random(4, "qw_e");
		randomeBTUname = "test_device".concat(randomeBTUname);
		randomeBTUname = randomeBTUname.concat(randomeBTUname1);
		driver.findElement(devicename).sendKeys(randomeBTUname);
		waithelper.forThisElementWait(description, 20).sendKeys("New Description");
		waithelper.forThisElementWait(devicetype, 20).click();
		waithelper.forThisElementWait(alkatel, 20).click();

		waithelper.forThisElementWait(choosebtn, 20).click();
		Thread.sleep(3000);
		StringSelection filepath = new StringSelection("C:\\Users\\Deva\\Downloads\\sample.csv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		Thread.sleep(2000);
		rr.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		rr.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		rr.keyRelease(KeyEvent.VK_V);
		rr.keyRelease(KeyEvent.VK_CONTROL);

		rr.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		rr.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		waithelper.forThisElementWait(savebtn, 20).click();
		Thread.sleep(3000);

		

	}

}
