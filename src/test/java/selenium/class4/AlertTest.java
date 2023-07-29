package selenium.class4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class AlertTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //alert
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(1500);
        driver.switchTo().alert().accept();
        Thread.sleep(1500);

        //confirmButton
        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(1500);
        driver.switchTo().alert().dismiss();
        Thread.sleep(1500);

        //confirmButton
        driver.findElement(By.id("promtButton")).click();
        Thread.sleep(1500);

        Alert alert = driver.switchTo().alert();
        Thread.sleep(1500);
        alert.sendKeys("Class 4 Welcome");
        Thread.sleep(1500);
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(1500);

        driver.quit();
    }
}
