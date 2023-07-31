package selenium.class5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class IframeTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println(driver.findElement(By.cssSelector("div.main-header")).getText());

        driver.switchTo().frame("frame1");
        System.out.println("Iframe value : " + driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().defaultContent();

        Thread.sleep(1500);
        driver.switchTo().frame("frame2");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().defaultContent();

        System.out.println(driver.findElement(By.id("framesWrapper")).getText());
        driver.quit();

    }
}
