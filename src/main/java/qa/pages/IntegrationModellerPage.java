package qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IntegrationModellerPage {
	private WebDriver driver;
	Waithelper waithelper;

	private By createbtn = By
			.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]");
	private By name = By.xpath("(//input[@id='name'])[2]");

	private By typeDrope = By.xpath("(//input[@id='type'])[2]");

	private By itsmvalue = By.xpath("//li[@id='type-option-9']");
	private By selecttypeDrope = By.xpath("(//input[@type='checkbox'])[27]");
	private By supportVersion = By.xpath("(//input[@id='free-chip-input'])[5]");
	private By variableDefination = By.xpath("(//input[@id='free-chip-input'])[6]");
	private By servicenow_instance = By.xpath("(//input[@type=\"text\"])[14]");
	private By username_ = By.xpath("(//input[@type=\"text\"])[15]");

	private By password_ = By.xpath("(//input[@type=\"text\"])[16]");

	private By imageupload = By.xpath("(//*[local-name()='svg' and @class='MuiSvgIcon-root'])[46]");

	private By uploadbtn = By.xpath("/html[1]/body[1]/div[5]/div[3]/div[2]/div[1]/form[1]/div[1]/div[2]/div[4]/button[1]/span[1]/div[1]");

	private By categorydrop = By.xpath("(//input[@id='free-chip-input'])[7]"); // WebElement.sendKeys(Keys.DOWN,
																				// Keys.RETURN);
	private By servicedesk = By.xpath("//li[contains(text(),'ServiceDesk')]");
	private By curlfield = By.xpath("(//textarea[@id='curlOperation'])[2]");
	private By testBTN = By.xpath("(//button[@type=\"submit\"])[2]");
	private By nextbtn = By.xpath("/html[1]/body[1]/div[5]/div[3]/div[2]/div[1]/form[1]/div[4]/button[2]/span[1]");
	private By textarea = By
			.xpath("(//textarea[@placeholder='Write a few words about the integration and what it helps achieve'])[1]");
	private By textarea2 = By
			.xpath("/html[1]/body[1]/div[3]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/textarea[1]");
	private By capebilities = By.xpath("(//textarea[@name=\"capabilities\"])[1]");
	private By certification = By.xpath("(//input[@name='certificationLevel'])[5]");
	private By savebtnn = By.xpath("(//button[@type=\"submit\"])[2]");

	public IntegrationModellerPage(WebDriver driver) {

		this.driver = driver;
		waithelper = new Waithelper(driver);
		
	}

	public void CreateIntegrationThroughmodeller() throws InterruptedException, AWTException {
		Robot rr = new Robot();

		waithelper.forThisElementWait(createbtn, 20).click();
		Thread.sleep(2000);
		
		////test//////
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement webElement = driver.findElement(By.xpath("(//label[contains(text(),\"Select file \")])[1]"));
		jse.executeScript("arguments[0].click();", webElement);

		Thread.sleep(3000);
		StringSelection filepath = new StringSelection("C:\\Users\\kvikram\\Downloads\\SNOW.jfif");
//		StringSelection filepath = new StringSelection("./SNOW.jfif");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		Thread.sleep(1000);
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
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[5]/div[3]/div[2]/div[1]/form[1]/div[1]/div[2]/div[4]/button[1]/span[1]/div[1]"))); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		
		
		
		
		
		///test//////
		
		
		
//		waithelper.forThisElementWait(imageupload, 20).sendKeys("./SNOW.jfif");
//		waithelper.forThisElementWait(imageupload, 20).click();
//
//		String filename = "./SNOW.jfif";
//		File file = new File(filename);
//		String path = file.getAbsolutePath();
//		// give the URL to upload
//
//		waithelper.forThisElementWait(imageupload, 20).click();

		String randomeBTUname = RandomStringUtils.random(4, "abca_d");
		String randomeBTUname1 = "testAutomation".concat(randomeBTUname + "tem_st");
//		driver.findElement(name).click();
		driver.findElement(name).sendKeys(randomeBTUname1);
		waithelper.forThisElementWait(typeDrope, 20).click();
		Thread.sleep(3000);
		driver.findElement(itsmvalue).click();

		Thread.sleep(2000);
		Robot r = new Robot();
		
		Actions act = new Actions(driver);

		driver.findElement(supportVersion).sendKeys("1.1");
		act.moveToElement(waithelper.forThisElementWait(supportVersion, 20)).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		
		
		driver.findElement(variableDefination).sendKeys("servicenow_instance");
		
		act.moveToElement(waithelper.forThisElementWait(variableDefination, 20)).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);

		waithelper.forThisElementWait(variableDefination, 20).sendKeys("username");
		act.moveToElement(waithelper.forThisElementWait(variableDefination, 20)).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		
		waithelper.forThisElementWait(variableDefination, 20).sendKeys("password");
		act.moveToElement(waithelper.forThisElementWait(variableDefination, 20)).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		
		waithelper.forThisElementWait(categorydrop, 20).click();
		waithelper.forThisElementWait(servicedesk, 20).click();
		
		Thread.sleep(2000);

		driver.findElement(curlfield).sendKeys(
				"curl -XPOST -H \"Content-type: application/json\" -d '{\"description\":\"Test Description\"}' 'https://$servicenow_instance/api/now/table/incident' -u $username:'$password'");

		driver.findElement(servicenow_instance).sendKeys("dev59080.service-now.com");
		driver.findElement(username_).sendKeys("admin");
		driver.findElement(password_).sendKeys("eh8+IZ%zZiU8");

		Thread.sleep(1000);

		

//		waithelper.forThisElementWait(uploadbtn,30).click();
		Thread.sleep(3000);

		driver.findElement(testBTN).click();
		Thread.sleep(4000);
		waithelper.forThisElementWait(nextbtn,25).click();
		Thread.sleep(3000);

		Thread.sleep(4000);

		driver.findElement(By.xpath(
				"(//textarea[@placeholder='Write a few words about the integration and what it helps achieve'])[2]"))
				.sendKeys("Open Ticket ,Close Ticket");
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"(//textarea[@placeholder='Write a few words about the capabilities and potential tasks that can be achieved by this integration - example: Open a ticker, update a ticket, assign ticket to a queue, etc.'])[2]"))
				.sendKeys("This Integration Is having Capability to open ticket and close ticket");
		Thread.sleep(2000);

		driver.findElement(savebtnn).click();
		Thread.sleep(3000);

		Thread.sleep(3000);
//		StringSelection filepath = new StringSelection("C:\\Users\\kvikram\\Downloads\\SNOW.jfif");
	}
}

		
		
