import com.epam.reportportal.annotations.Step;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P01_LoginPage {
   //variable
    SHAFT.GUI.WebDriver driver;
    //contractor
    public P01_LoginPage(SHAFT.GUI.WebDriver driver )
    {this.driver=driver;}
    //locators
    By emailInput = By.xpath("//input[@data-qa=\"login-email\"]");
    By passwordInput = By.xpath("//input[@data-qa=\"login-password\"]");
    By loginBtn = By.xpath("//button[@data-qa=\"login-button\"]");

    //methods
    @Step("Login with valid email & password ")
    public P02_HomePage loginSteps(String userEmail, String password){
        driver.element().type(emailInput,userEmail).
                and().type(passwordInput,password).
                and().click(loginBtn);
        return new P02_HomePage(driver);
    }

}
