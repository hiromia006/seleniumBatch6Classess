package selenium.class5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CoockiesTest {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://parabank.parasoft.com/parabank/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().addCookie(new Cookie("Tahia", "orine"));
        System.out.println("Tahia : " + driver.manage().getCookieNamed("Tahia").getValue());

        for (Cookie cookie : driver.manage().getCookies()) {
            System.out.println(cookie.getValue());
        }

        System.out.println("===================================================");
        driver.manage().deleteCookieNamed("Tahia");

        for (Cookie cookie : driver.manage().getCookies()) {
            System.out.println(cookie.getValue());
        }

        driver.manage().deleteAllCookies();

        System.out.println("Cookies : " + driver.manage().getCookies().size());

        driver.quit();
    }
}
