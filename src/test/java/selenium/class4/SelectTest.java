package selenium.class4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SelectTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
        select.selectByIndex(3);
        Thread.sleep(1500);

        select.selectByValue("7");
        Thread.sleep(1500);

        select.selectByVisibleText("Red");
        Thread.sleep(1500);

        for (WebElement webElement : select.getOptions()) {
            System.out.println(webElement.getText());
        }

        System.out.println("======================================================");
        Select multipleSelect = new Select(driver.findElement(By.id("cars")));
        multipleSelect.selectByIndex(1);
        Thread.sleep(1500);
        multipleSelect.selectByIndex(2);
        Thread.sleep(3000);

        driver.quit();
    }
}
