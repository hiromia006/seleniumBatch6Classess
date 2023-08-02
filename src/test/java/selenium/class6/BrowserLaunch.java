package selenium.class6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BrowserLaunch {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
         driver = new FirefoxDriver();

//        driver.get("https://demoqa.com/droppable");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
        Thread.sleep(1000);
    }
}
