package StepDefinitions;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterEcommerce {
    SharedDriver shared;

    public void setup(SharedDriver shared){
        this.shared = shared;

    }


    @When("I open nopcommerce homepage and select new user")
    public void i_open_nopcommerce_homepage_and_select_new_user() {
        shared.driver.get("https://demo.nopcommerce.com/");
        shared.driver.findElement(By.xpath("/html/body/div[6]/header/div[1]/div[2]/div[1]/ul/li[1]/a")).click();

    }

    @When("I enter the valid details to register and click on register")
    public void i_enter_the_valid_details_to_register_and_click_on_register() {
        shared.driver.findElement(By.id("gender-male")).click();
        shared.driver.findElement(By.id("FirstName")).sendKeys("Shahrukh");
        shared.driver.findElement(By.id("LastName")).sendKeys("Khan");
        shared.driver.findElement(By.id("Email")).sendKeys("srk@gmail.com");
        shared.driver.findElement(By.id("Company")).sendKeys("RedChillies");
        shared.driver.findElement(By.id("Password")).sendKeys("123456");
        shared.driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
        shared.driver.findElement(By.id("Email")).sendKeys("srk@gmail.com");
        shared.driver.findElement(By.id("register-button")).click();

    }

    @Then("I should be able to register successfully")
    public void i_should_be_able_to_register_successfully() {
        System.out.println(shared.driver.getTitle());
    }
}
