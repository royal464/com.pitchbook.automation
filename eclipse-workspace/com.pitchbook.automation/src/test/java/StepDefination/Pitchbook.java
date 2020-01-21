package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Pitchbook 
{
	
	WebDriver driver;
	
	//Scenario Outline: Pitchbook signin with valid credentials
	@Given("Open chrome with Pitchbook URL")
	public void Open_chrome_with_Pitchbook_URL() throws Exception  {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aslit\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://retail-qa-app.advantagesolutions.net/pitchbook");
		Thread.sleep(3000);
		
	}
	@When("^User enters valid (.*) and (.*)$")
	public void User_enters_valid_username_and_password(String username, String password) throws Exception{
		Thread.sleep(3000);
		driver.findElement(By.id("okta-signin-username")).sendKeys(username);
		driver.findElement(By.id("okta-signin-password")).sendKeys(password);
		Thread.sleep(3000);
		
	}
	@And("User clicks on the Signin button")
	public void User_clicks_on_the_Signin_button() throws Exception{
		driver.findElement(By.id("okta-signin-submit")).click();
		Thread.sleep(1000);
	}
	@Then("User should be able to signin successfully")
	public void User_should_be_able_to_signin_successfully() throws Exception{
		Thread.sleep(9000);
		driver.findElement(By.xpath("/html/body/app-root/app-header/div/div[3]/div/i[1]")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[1]")).click();
		Thread.sleep(9000);
	}
	@Given("^user click on edit mode toggle switch from top menu$")
	public void user_click_on_edit_mode_toggle_switch_from_top_menu() throws Exception{
		Thread.sleep(9000);
		driver.findElement(By.className("offtoggle")).click();
	}
	
	@Then ("^system should display pitchbook editor enable edit mode popup$")
	public void system_should_display_pitchbook_editor_enable_edit_mode_popup() throws Exception{
		driver.findElement(By.xpath("//*[contains(text(),'Pitchbook Editor is now running in edit mode')]")).click();
		Thread.sleep(9000);
		
	}
    @And ("^Click on Why BlockBuster tab and Mouse over on any one of the Cards$")
    public void Mouse_over_on_any_one_of_the_Cards_and_Click_Edit_icon() throws Exception{
    	Thread.sleep(9000);
    	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
          WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Why BlockBuster')]"));
    	   JavascriptExecutor jse = ((JavascriptExecutor)driver);
    	  jse.executeScript("arguments[0].click();",element );
    	Thread.sleep(9000);
    	driver.findElement(By.xpath("//div[@id=\"maintop\"]/div[2]")).click();
    	Thread.sleep(3000);
    	Actions actions = new Actions(driver);
    	WebElement target=driver.findElement(By.xpath("//*[@id=\"testSpan1\"]"));
    	actions.moveToElement(target).perform();
    	driver.findElement(By.xpath("//*[@id=\"toolbar\"]/div[2]")).click();
    	
    	
    }
    @And ("^Click on Edit icon and Enter any desired text in place of already existing text$")
    public void Enter_any_desired_text_in_place_of_already_existing_text() throws Exception{
    	driver.findElement(By.xpath("//*[@id=\"testSpan1\"]")).sendKeys("Edited test small");
    	
    }
    @Then ("^System displayed the changed text$")
    public void System_displayed_the_changed_text() throws Exception{
    	String Expectedtext="Edited test small";
    	WebElement actualtext=driver.findElement(By.xpath("//*[@id=\"testSpan1\"]/text()"));
    	String gettingtext=actualtext.getText();
    	if(Expectedtext==gettingtext) {
    		System.out.println("Test Edited succcessfully");
    	}
    }

}
 