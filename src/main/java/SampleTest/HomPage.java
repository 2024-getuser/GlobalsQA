package SampleTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomPage {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();		
		driver.get("https://www.globalsqa.com");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.err.println("Home Page Title : " +  title);
		
		WebElement ele = driver.findElement(By.xpath("//a[@class='no_border'][contains(text(),'Tester’s Hub')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(ele, 10, 20).build().perform();
		
		By by_Sample_Page_Test = By.xpath("//span[normalize-space()='Sample Page Test']");		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(by_Sample_Page_Test));
		WebElement ele_Sample_Page_Test = driver.findElement(by_Sample_Page_Test);
		ele_Sample_Page_Test.click();
	
		
		// ====== Sample test page logic ==========		
		
		//driver.get("https://www.globalsqa.com/samplepagetest/");
		 
		   
		   WebElement ele_profilePic = driver.findElement(By.xpath("//span[@class='wpcf7-form-control-wrap file-553']//input[1]"));
		   ele_profilePic.sendKeys("C:\\Users\\HP\\Desktop\\adiyogi.png");  //Uploading the file using sendKeys
		  
		   
		   driver.findElement(By.id("g2599-name")).sendKeys("Testname");
		   driver.findElement(By.id("g2599-email")).sendKeys("Testname@gmail.com");
		   driver.findElement(By.id("g2599-website")).sendKeys("https:\\Testname.com");
		   
		   
		   Select experience = new Select(driver.findElement(By.id("g2599-experienceinyears")));
		   experience.selectByValue("5-7");
		   driver.findElement(By.xpath("//input[@value='Functional Testing']")).click();  
		   
		   Wait<WebDriver> wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));			   
		   wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@value='Automation Testing']"))));
		   driver.findElement(By.xpath("//input[@value='Automation Testing']")).click();
		   driver.findElement(By.xpath("//input[@value='Manual Testing']")).click();
		   
		   wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("g2599-education"))));
		   driver.findElement(By.xpath("//input[@value='Post Graduate']")).click();
		   
		   driver.findElement(By.xpath("//button[normalize-space(text())='Alert Box : Click Here']")).click();
		   wait1.until(ExpectedConditions.alertIsPresent());

	       Alert alert = driver.switchTo().alert();
	       //Store the alert text in a variable and verify it
	       String text = alert.getText();
	       if(text.equals("Do you really fill rest of the form?")) {
	    	   System.out.println(text);
	    	   alert.accept();
	    	   String strtext = alert.getText();
	    	   System.out.println(strtext);
	    	   alert.accept();
	    	  //Good Luck. Go for it
	       }
	       
	       driver.findElement(By.id("contact-form-comment-g2599-comment")).sendKeys("Happy to Automate");
	       driver.findElement(By.xpath("//button[normalize-space(text())='Submit']")).click();

	}

}
