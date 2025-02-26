import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class addProduct {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testJson;
    SHAFT.TestData.EXCEL testExcel;

    @Test(description = "Navigate to Products & Add items with price less than 1000 ")
    public void addProductsToCart() throws InterruptedException {
       // new P01_LoginPage(driver).loginSteps(testJson.getTestData("userEmail"),testJson.getTestData("password") );
        new P01_LoginPage(driver).loginSteps(testExcel.getCellData("userEmail"), testJson.getTestData("password"))
                .navigateToProducts()
                .addProducts()
                .productsVerifications();
        Thread.sleep(3000);
    }

    @BeforeClass
    public void  setUp (){
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://www.automationexercise.com/login");
        testJson =new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData()+ "testData.json");
        testExcel =new SHAFT.TestData.EXCEL(SHAFT.Properties.paths.testData()+ "testData.xlsx");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
