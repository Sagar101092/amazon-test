package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class BaseTest {

    public static WebDriver driver;
    public static String baseUrl = "";

    public void openBrowser(String baseUrl) {

        ChromeOptions options = new ChromeOptions();
          options.addArguments("--disable-notifications");
        driver = new ChromeDriver();
        // Launch url
        driver.get(baseUrl);
        // Maximise Window
        driver.manage().window().maximize();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }

    public void closeBrowser() {
        // close all windows
        driver.quit();
    }
}
