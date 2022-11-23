package TestPackage;








import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import java.time.Duration;

//import newtest.WebDriverWait;

//import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AutomationPractice {

	
	WebDriver driver;
	public WebDriverWait wait;
	
	
	@BeforeMethod
public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\KS_Computers\\Desktop\\QA SELENIUM JAVA KURS\\eclipse\\chromedriver.exe");
	driver=new ChromeDriver(); 
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//driver.get("https://www.saucedemo.com/"); 
	}
	
	@AfterMethod
    public void finish(){
        driver.quit();
	}
   @Test 
   public void testcase1 ()  {
    driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.name("password")).sendKeys("secret_sauce"); 
    driver.findElement(By.className("submit-button")).click();
    
    WebElement header=driver.findElement(By.className("title"));
    String Expectedheader="PRODUCTS";
    Assert.assertEquals(Expectedheader, header.getText());


    WebElement shoppingcart=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
    //System.out.println("Shopping cart return value " + shoppingcart.isDisplayed());
    Assert.assertEquals(true, shoppingcart.isDisplayed());


     WebElement burgermenu=driver.findElement(By.id("react-burger-menu-btn"));
     String Expectedmenu="Open Menu";
     Assert.assertEquals(Expectedmenu, burgermenu.getText());

     WebElement socialnetwork1=driver.findElement(By.xpath("//a[normalize-space()='Twitter']"));
    Assert.assertEquals(true, socialnetwork1.isDisplayed() );

    WebElement socialnetwork2=driver.findElement(By.xpath("//a[normalize-space()='Facebook']"));
    Assert.assertEquals(true, socialnetwork2.isDisplayed());

    WebElement socialnetwork3=driver.findElement(By.xpath("//a[normalize-space()='LinkedIn']"));
    Assert.assertEquals(true, socialnetwork3.isDisplayed());


    driver.findElement(By.id("react-burger-menu-btn")).click();


   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10)); 
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
   WebElement logout = driver.findElement(By.id("logout_sidebar_link"));

    String Expectedlog="LOGOUT";
    Assert.assertEquals(Expectedlog, logout.getText());

    
}
  
@Test
public void testcase2 ()  {  
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.name("password")).sendKeys("secret_sauce"); 
    driver.findElement(By.className("submit-button")).click();
	
	//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10)); 
	//   wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("inventory_item_name"))).click();
	   driver.findElement(By.cssSelector("a[id='item_4_title_link'] div[class='inventory_item_name']")).click();
	   
	WebElement title=driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']"));
	String Expectedtitle = "Sauce Labs Backpack";
	Assert.assertEquals(Expectedtitle, title.getText());
	//System.out.println("Title is displayed");

	WebElement description=driver.findElement(By.xpath("//div[@class='inventory_details_desc large_size']"));
	String Expectedtext = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
	Assert.assertEquals(Expectedtext,  description.getText());
	//System.out.println("Description is displayed");

	WebElement price=driver.findElement(By.className("inventory_details_price"));
	String Expectedprice="$29.99";
	Assert.assertEquals(Expectedprice, price.getText());
	//System.out.println("Price is displayed");

	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	driver.findElement(By.name("back-to-products")).click();
	driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
	driver.findElement(By.className("shopping_cart_badge")).click();
	driver.findElement(By.name("checkout")).click();
	driver.findElement(By.id("first-name")).sendKeys("Alma");
	driver.findElement(By.id("last-name")).sendKeys("Drina");
	driver.findElement(By.id("postal-code")).sendKeys("71000");
	driver.findElement(By.name("continue")).click();
	driver.findElement(By.id("finish")).click();

	WebElement message=driver.findElement(By.className("complete-header"));
	String Expectedmessage="THANK YOU FOR YOUR ORDER";
	Assert.assertEquals(Expectedmessage, message.getText());
	//System.out.println("THANK YOU FOR YOUR ORDER is displayed");

	driver.findElement(By.id("react-burger-menu-btn")).click();
	driver.findElement(By.id("logout_sidebar_link")).click();
  
}
}
	