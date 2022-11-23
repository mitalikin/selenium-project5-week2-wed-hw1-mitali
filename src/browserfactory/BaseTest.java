package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {public static WebDriver driver;
    public  void openBrowser(String baseUrl){
        System.setProperty("WebDriver.Chrome.driver","drivers/chromedriver.exe");
        //WebDriver driver=new chrome driver();
        driver=new ChromeDriver();
        //launch the url
        driver.get(baseUrl);
        //maximise window
        driver.manage().window().maximize();
        //we give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }
    public  void closeBrowser(){
        // driver.quit();
    }
}
