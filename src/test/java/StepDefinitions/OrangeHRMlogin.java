package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class OrangeHRMlogin {
    WebDriver driver;
    @Given("I launch chrome browse")
    public void i_launch_chrome_browse() {

        System.setProperty("webdriver.chrome.driver", "C:\\Ifran\\Tools\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @When("I open Orange HRM homepage and enter the login details")
    public void i_open_orange_hrm_homepage_and_enter_the_login_details() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        WebElement userElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[1]"));
//        String fullusername = userElement.getText();
//        String username = fullusername.split(":")[1].trim();
//        System.out.println("Username: " + username);
//
//        WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[2]"));
//        String fullpassword = passwordElement.getText();
//        String password  = fullpassword.split(":")[1].trim();
//        System.out.println("Password: "+password);
        boolean logopresent = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[1]/img")).isDisplayed();
        Assert.assertEquals(true, logopresent);
        //driver.findElement(By.name("username")).sendKeys("Admin");
        //driver.findElement(By.name("password")).sendKeys("admin123");

    }
    @Then("I should be able to login successfully")
    public void i_should_be_able_to_login_successfully() {
        //driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
    }
    @Then("I will print the page title")
    public void i_will_print_the_page_title() {

    }
    @Then("I will close the browser")
    public void i_will_close_the_browser() {
        driver.close();
    }
}
