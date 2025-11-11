package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Ifran//Projects//Selenium_UI_Automation//Selenium_UI_Automation//src//test//resources//Features",
        glue = "stepDefinations",
        tags = "EcommerceRegister"
)
public class TestRunner {

}
