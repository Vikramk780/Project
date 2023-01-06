package qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class EventHubPage {

	private WebDriver driver;
	Waithelper waithelper;

	private By event1 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[1]");

	private By event2 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	private By actiondrop = By.xpath("//div[@aria-label='Table Toolbar']//div[3]");
	private By createBTUbtn = By.xpath("//li[normalize-space()='Create BTU']");
	private By nextbtn = By.xpath("(//span[normalize-space()='Next'])[1]");
	private By nextbtn2 = By.xpath("/html[1]/body[1]/div[4]/div[3]/div[2]/div[3]/button[2]/span[1]");

	private By autoextractnextbtn = By.xpath("(//span[normalize-space()='Next'])[2]");
	private By btuname = By.xpath("(//input[@placeholder=\"BTU_GSAS_Disk_Cache_Clear\"])[2]");
	private By description = By.xpath("(//textarea[@id=\"description\"])[2]");
	private By savenext = By.xpath("/html[1]/body[1]/div[4]/div[3]/div[2]/div[2]/form[1]/div[1]/div[2]/button[3]");
	private By name_saveandNext = By
			.xpath("/html[1]/body[1]/div[4]/div[3]/div[2]/div[2]/form[1]/div[1]/div[2]/button[3]");

	private By tag_succNextbtn = By.xpath("(//span[normalize-space()='Next'])[1]");
	private By entitynext1 = By.xpath("(//span[normalize-space()='Next'])[1]");
	private By savelastbtn = By.xpath("(//span[normalize-space()='Save'])[4]");
	private By savbtn = By.xpath("(//span[contains(text(),\"Save\")])[2]");

	public EventHubPage(WebDriver driver) {
		this.driver = driver;
		waithelper = new Waithelper(driver);
	}

	public void createBTU() throws InterruptedException, AWTException {

		Thread.sleep(4000);
		waithelper.forThisElementWait(By.xpath("(//*[local-name()='svg' and @class=\"MuiSvgIcon-root\"])[21]"),30).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@aria-label='Search']")).sendKeys("Test Description");
		Thread.sleep(4000);

		waithelper.forThisElementWait(event1, 20).click();
		Thread.sleep(2000);
		waithelper.forThisElementWait(event2, 20).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(actiondrop)).click().perform();
		Thread.sleep(2000);

		act.moveToElement(driver.findElement(createBTUbtn)).click().perform();

		Thread.sleep(2000);

		// warnning popup next btn
		act.moveToElement(driver.findElement(nextbtn)).click().perform();

		// event review next
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(nextbtn2)).click().perform();
		Thread.sleep(1000);

		String randomeBTUname = RandomStringUtils.random(4, "abca_d");
		String randomeBTUname1 = RandomStringUtils.random(4, "qwa_e");
		randomeBTUname = "testq_BTUFromAuto".concat(randomeBTUname);
		randomeBTUname = randomeBTUname.concat(randomeBTUname1);

//		waithelper.forThisElementWait(savenext).sendKeys("test");
//		driver.findElement(savenext).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);

//		waithelper.forThisElementWait(savenext).click();
		waithelper.forThisElementWait(btuname, 20).sendKeys(randomeBTUname);

		waithelper.forThisElementWait(description, 20).sendKeys(randomeBTUname);
		Thread.sleep(1000);

		Thread.sleep(1000);

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[2]/form[1]/div[1]/div[2]/button[3]/span[1]"))); 
//		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

		Thread.sleep(2000);
		// next once we name btu click saveandnext

		act.moveToElement(driver.findElement(name_saveandNext)).click().perform();
		Thread.sleep(4000);

		Thread.sleep(1000);
		// tagging successfull next btn

		act.moveToElement(driver.findElement(tag_succNextbtn)).click().perform();
		Thread.sleep(2000);
		// only display entity next btn
		act.moveToElement(driver.findElement(entitynext1)).click().perform();
		Thread.sleep(2000);

		// after userdefined entity
		Thread.sleep(4000);
		act.moveToElement(driver.findElement(autoextractnextbtn)).click().perform();

		// trainning next btn
		Thread.sleep(3000);
		act.moveToElement(driver.findElement(autoextractnextbtn)).click().perform();
		// testpage btn
		Thread.sleep(3000);
		act.moveToElement(driver.findElement(autoextractnextbtn)).click().perform();

		Thread.sleep(3000);
		act.moveToElement(driver.findElement(savbtn)).click().perform();
		Thread.sleep(3000);

	}

}
