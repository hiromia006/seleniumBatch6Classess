package selenium.class6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        Actions actions = new Actions(driver);
//        WebElement webElement = driver.findElement(By.id("droppableExample-tab-simple"));
//        actions.clickAndHold(webElement)
//                .perform();
//        Thread.sleep(3000);
//
//        actions.contextClick(webElement)
//                .perform();
//        Thread.sleep(3000);
//
//        actions.doubleClick(webElement)
//                .perform();
//        Thread.sleep(3000);

        driver.navigate().to("https://demoqa.com/menu");


        driver.findElement(By.linkText("Main Item 2")).click();
        Thread.sleep(3000);

        actions.moveToElement(driver.findElement(By.linkText("SUB SUB LIST »")))
                .click()
                .perform();
        Thread.sleep(3000);

        actions.moveToElement(driver.findElement(By.linkText("Sub Sub Item 2")))
                .click()
                .perform();
        Thread.sleep(3000);

        driver.quit();

    }
}
