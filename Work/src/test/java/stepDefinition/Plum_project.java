package stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Plum_project {
	public	static WebDriver driver;
	private WebDriverWait wait;
	 private String username;
	   private String password;
	   
	
	@Before
    public void setUp() {
		 System.setProperty("webdriver.chrome.driver","C:/driver/chromedriver-win64/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		 driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
}
	    @Given("I am on the Plum Goodness website")
	   	 public void navigateToPlumGoodnessWebsite() {
	        driver.get("https://plumgoodness.com/");
	}       
	 @When("I highlight the logo")
	 
	        public void highlightLogo() {
	            WebElement logo = driver.findElement(By.xpath("//*[@id=\"shopify-section-header-parallax\"]/header/div[2]/div/div[1]/div[2]/h1/a"));
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].setAttribute('style', 'background: pink; border: 2px solid skyblue;');", logo);
	        }

	        @And("I print logo CSS properties")
	        public void printLogoCssProperties() {
	            WebElement logo = driver.findElement(By.xpath("//*[@id=\"shopify-section-header-parallax\"]/header/div[2]/div/div[1]/div[2]/h1/a"));
	            System.out.println("Font Size: " + logo.getCssValue("font-size"));
	            System.out.println("Font Style: " + logo.getCssValue("font-style"));
	            System.out.println("Color: " + logo.getCssValue("color"));
	        }
	        
	        @Then("I should see the header content")
	        public void prinHeaderElements() {
	        	WebElement HeaderElement=driver.findElement(By.xpath("//*[@id=\"shopify-section-header-parallax\"]/header/div[2]/div/div[1]/div[2]/nav"));
	        	if(HeaderElement.isDisplayed()) {
	        		System.out.println("Header list:" + HeaderElement.getText());
	        	}else {
	        		System.out.println("Header is not available");
	        	}
	        }

	           @When ("I navigate to the login page")
	           public void navigate_login_page() {
	        	   driver.findElement(By.id("Capa_1")).click(); 
	           }
	           @When("I enter test username and password from Excel")
	   	    public void UsernameAndPasswordFromExcel() {
	   	        String excelFilePath = "src/test/resources/ExcelData/login.xlsx";
	   	        int sheetIndex = 0; 

	   	        try (FileInputStream fis = new FileInputStream(excelFilePath);
	   	             Workbook workbook = new XSSFWorkbook(fis)) {
	   	        	Sheet sheet = workbook.getSheetAt(sheetIndex);
	   	        
	   	  Row row = sheet.getRow(1);
	   	           
	   	           username = row.getCell(0).getStringCellValue();
	   	            password = row.getCell(1).getStringCellValue();
	   	        


	   	        } catch (IOException e) {
	   	            e.printStackTrace();
	   	        }
	   	    }

	   	    @And("I click the test login button")
	   	    public void LoginButton() {
	   	    	
	   	        driver.findElement(By.id("customer_email")).sendKeys(username);
	   	        driver.findElement(By.id("customer_password")).sendKeys(password);
	   	        driver.findElement(By.id("notifyeventsignup")).click();
	   	   // driver.navigate().back();
	   	    }
	   	    
	   	    @Then("I should be logged into test")
	   	 public void i_should_be_logged_into_test() {
	   	      
	   	        System.out.println("Test successful");
	   	     
	   	    }
	   	 @When("I enter invalid username and password")
	   	    public void invalid_credantials() {
	   	     driver.findElement(By.id("customer_email")).sendKeys("rajeshkarthi0@gmail.com");
	   	        driver.findElement(By.id("customer_password")).sendKeys("raj");
	   	        driver.findElement(By.id("notifyeventsignup")).click();
	   	    }
	   	 @Then ("It show login fail message")
	   	 public void login_fail_message() {
	   		 System.out.println("login should failed");	
	   	 }
	        @Then("I navigate to the skincare collection")
	        public void navigateToSkincareCollection() throws InterruptedException {
	            driver.navigate().to("https://plumgoodness.com/collections/skincare");
	            System.out.println(driver.getTitle());
	              Thread.sleep(1000);
	        }
	        @Then("I navigate to the Plum Bodylovin page")
	        public void navigateToPlumBodylovinPage() throws InterruptedException {
	        	 driver.navigate().to("https://plumgoodness.com/pages/plum-bodylovin");
	              System.out.println(driver.getTitle());
	              Thread.sleep(1000);
	        }
	        @When("I should see the makeup collection page")
	        public void verifyMakeupCollectionPage() throws InterruptedException {
	        	driver.navigate().to("https://plumgoodness.com/collections/makeup");
	              System.out.println(driver.getTitle());
	              Thread.sleep(1000);
	        }
           @Then("I should see the dropdown options")
           public void verifyDropdownOptions() throws InterruptedException {
        	   WebElement dropdown=driver.findElement(By.xpath("/html/body/div[3]/main/div/div[2]/div/div/div/div[1]/div/div[1]/div/label/span/span"));
         		dropdown.click();
             Thread.sleep(4000);
           }
           @When("I search for the product {string}")
           public void searchForProduct(String productName) {
               WebElement search = driver.findElement(By.xpath("//*[@id='searchfeild']"));
               search.sendKeys(productName, Keys.ENTER);
           }
           @And("I click on the product")
           public void clickOnProduct() {
               WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
               WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div/div/div[2]/a")));
               element.click();
           }
           @Then("I am scrolling down")
           public void i_am_scrolling_down() throws InterruptedException {
               JavascriptExecutor jse = (JavascriptExecutor) driver;
               // Scroll down by a certain number of pixels or to a specific element
               jse.executeScript("window.scrollBy(0, 800);"); // Example: Scroll down by 800 pixels
               Thread.sleep(1000);
           }

           @Then("I am scrolling up")
           public void i_am_scrolling_up() {
               JavascriptExecutor jse = (JavascriptExecutor) driver;
               // Scroll down by a certain number of pixels or to a specific element
               jse.executeScript("window.scrollBy(0, -800);"); // Example: Scroll down by 800 pixels
           }
          
                 
           @And ("I add the product to the cart using JavaScript")
           public void add_to_cart() {
        	   WebElement addToCartButton = driver.findElement(By.name("add"));
               ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
           }
           @And ("I click on the cart button")
        	   public void click_cart_button() {
        	  
               WebElement cartButton = driver.findElement(By.xpath("/html/body/div[2]/div/header/div[2]/div/div[1]/div[3]/div[3]/a/img"));
               cartButton.click();
        		   
        	   }
           @And("I click on {string}")
           public void i_click_on(String buttonText) {
               // Use buttonText to locate and click the element
               WebDriverWait viewCartWait = new WebDriverWait(driver, Duration.ofSeconds(10));
               WebElement viewCartButton = viewCartWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), '" + buttonText + "')]")));
               viewCartButton.click();
           }
    
           @Then("I should be in the shopping cart page")
           public void shopping_cart() {
               WebElement checkout = driver.findElement(By.id("gokwik-btn"));
               checkout.click();
               String pageTitle = driver.getTitle();
               Assert.assertTrue("Shopping cart page title is incorrect.", pageTitle.contains("Shopping Cart"));
           }

               
           @When ("I scroll bottom")
           public void Scroll_bottom() {
        	   JavascriptExecutor js=(JavascriptExecutor)driver;
    	       js.executeScript("window.scrollBy(0,6000)");
           }
           @And("I click on the contact us")
           public void click_contact_us() {
        	   driver.findElement(By.xpath("/html/body/div[3]/div[2]/footer/div[1]/div/div/div/div[2]/div/div[3]/div/ul/li[1]/a")).click();
           }
           @And("I click on the Mail Button")
           public void click_mail_button() {
        	   driver.findElement(By.xpath("/html/body/div[3]/main/div/div/div[2]/div/div[1]/div[2]/div/p/a")).click();
           } 
           
         @Then("I am goto click the logout button")
           public void logout() {
        	   driver.findElement(By.xpath("/html/body/div[3]/main/div/div/div[2]")).click();
           }
         @After
         public void confirm_message() {
 	        System.out.println("Test completed successfully.");
 	    }
}  	   
           
           
	      


	