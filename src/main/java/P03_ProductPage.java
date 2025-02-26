import com.epam.reportportal.annotations.Step;
import com.google.common.base.Verify;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_ProductPage {
   //variable
    SHAFT.GUI.WebDriver driver;
    //contractor
    public P03_ProductPage(SHAFT.GUI.WebDriver driver )
    {this.driver=driver;}
    //locators
    By productsCard = By.xpath("//div[@class=\"productinfo text-center\"]");
    By continueBtn = By.xpath("//button[@data-dismiss=\"modal\"]");
    By viewCartBtn = By.xpath("(//a[@href=\"/view_cart\"])[1]");

    //methods
    @Step("Add Products with price less than 1000")
    public P03_ProductPage addProducts(){
    List<WebElement> products = driver.getDriver().findElements(productsCard);
        try {
            for (int i = 0; i < products.size() ; i++) {
             int productPrice = Integer.parseInt(driver.getDriver().findElement
                             (By.xpath("(//div[@class=\"productinfo text-center\"]/h2)[" +(i+1) + "]"))
                     .getText().replaceAll("[^0-9]",""));
             System.out.println("Price of Product " + (i+1));
             if (productPrice<1000){
              driver.element().click(By.xpath("(//div[@class=\"productinfo text-center\"])[" +(i+1)+ "]/a"))
                      .click(continueBtn);
              System.out.println(" Added product with price " + productPrice + " To the cart " );
             }
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
           return this;
    }
    @Step("Verify view cart products ")
    public  void productsVerifications(){
    driver.element().scrollToElement(viewCartBtn).click(viewCartBtn)
          .and().browser().capturePageSnapshot();
    }

}
