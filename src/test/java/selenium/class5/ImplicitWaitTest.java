package selenium.class5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ImplicitWaitTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println(driver.findElement(By.className("main-header")).getText());

        String mainWindow = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://demoqa.com/sample");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        Thread.sleep(1500);
        driver.close();

        Thread.sleep(1500);
        driver.switchTo().window(mainWindow);
        System.out.println(driver.findElement(By.className("main-header")).getText());

        driver.quit();

    }
}
