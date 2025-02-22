import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P03_ProductPage {
   //variable
    SHAFT.GUI.WebDriver driver;
    //contractor
    public P03_ProductPage(SHAFT.GUI.WebDriver driver )
    {this.driver=driver;}
    //locators
    By emailInput = By.xpath("//input[@data-qa=\"login-email\"]");
    By passwordInput = By.xpath("//input[@data-qa=\"login-password\"]");
    By loginBtn = By.xpath("//input[@data-qa=\"login-button\"]");

    //methods
    public void login(String userEmail, String password){
        driver.element().type(emailInput,userEmail).
                and().type(passwordInput,password).
                and().click(loginBtn);
    }

}
