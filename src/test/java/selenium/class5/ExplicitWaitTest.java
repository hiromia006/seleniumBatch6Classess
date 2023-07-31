package selenium.class5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));

        By locator=By.className("main-header");
        wait.until(ExpectedConditions.titleIs("ddada"));
        System.out.println(driver.findElement(locator).getText());

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
