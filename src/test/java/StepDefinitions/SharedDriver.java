package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SharedDriver {
    WebDriver driver;
    public SharedDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Ifran\\Tools\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void quit(){
        driver.quit();
    }
}
