package StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginDef {

	static WebDriver driver;

	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions ops = new ChromeOptions();

		// ops.addArguments("headless");

		driver = new ChromeDriver();

		driver.get("https://ui.freecrm.com/");

		driver.manage().window().maximize();

		String currentUrl = driver.getCurrentUrl();

		System.out.println("The current url is :" + currentUrl);

	}

//	@When("user enter username and password")
//	public void user_enter_username_and_password() {
//		
//		WebElement ele=driver.findElement(By.xpath("//*[@name='email']"));
//		ele.sendKeys("naveenwell@gmail.com");
//		System.out.println(">>>>>" +ele.getAttribute("value"));
//		WebElement ele1=driver.findElement(By.xpath("//input[@placeholder='Password']"));
//		ele1.sendKeys("Wait@123");
//		String ss=ele1.getAttribute("value");
//		byte[] encodedString=Base64.encodeBase64(ss.getBytes());
//		System.out.println("encode is:" +new String(encodedString));
//
//	}

//	@When("user enter {string} and {string}")
//	public void user_enter_and(String username, String password) throws InterruptedException {
//
//		driver.findElement(By.xpath("//*[@name='email']")).sendKeys(username);
//
//		Thread.sleep(3000);
//
//		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
//		Thread.sleep(3000);
//
//	}

	@When("user enter username and password")
	public void user_enter_username_and_password(DataTable credential) throws Throwable {

		List<List<String>> ltr = credential.asLists(String.class);

		System.out.println(">>>>" + ltr.size());

//	//for (List<String> list : ltr) {
////		
////		String username=list.get(0);
////		
////		String password=list.get(1);
//		
//		driver.findElement(By.xpath("//*[@name='email']")).sendKeys(username);
//		
//		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
//		
//	}

		for (int i = 0; i < ltr.size(); i++) {

			driver.findElement(By.xpath("//*[@name='email']")).sendKeys(ltr.get(i).get(0));

			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ltr.get(i).get(1));

		}

	}

	@When("user click on login button")
	public void user_click_on_login_button() {

		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();

	}

	@Then("user view a home page")
	public void user_view_a_home_page() {

		String actual = driver.getTitle();

	}

}
