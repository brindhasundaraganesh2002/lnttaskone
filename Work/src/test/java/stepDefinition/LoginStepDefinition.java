package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginStepDefinition {
	public	static WebDriver driver;
	
	@Given ("User is on login page")
	public void user_is_on_login_page() {
		 System.setProperty("webdriver.chrome.driver","C:/driver/chromedriver-win64/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
	}	
//	@When("User enters valid username and password")
	@When("User enters valid {string} and {string}")
//	public void  credantials() {
	public void user_enters_valid_and(String string, String string2) {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	@And("Clicks on Login Button")
	public void click_on_login_button() {
		driver.findElement(By.id("login-button")).click();
	}
	@Then("User in navigated to Home page")
	public void navigation() {
		Assert.assertTrue("User is navigated to Home page",driver.findElements(By.xpath("//div[@class='app_logo']")).size()>0);
	}
	@And("Close the browser")
	public void close_the_browser() {
		driver.close();
	}
	
	@When("i click add to cart button" )
	public void cart_button() {
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")).click();
	}
	@Then("its add to cart")
	public void add_cart() {
	System.out.println("add to cart");
	}
	 @After
	    public void confirmation_message() {
	        System.out.println("Test completed successfully.");
	    }
}
