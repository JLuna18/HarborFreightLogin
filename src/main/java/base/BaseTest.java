package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Constants;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Objects;

public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser","headless"})
    public void beforeMethod(String browser, @Optional String headless, Method testMethod) {
        // chooses browser to use
        setupDriver(browser,headless);
        // maximize driver window
        driver.manage().window().maximize();
        // go to your starting url
        driver.get(Constants.url);
        // set wait times
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void afterMethod() {
        // closes driver after test case is ran
        driver.quit();
    }

    public void setupDriver(@NotNull String browser, @Optional String headless) {
        // checks if driver should be set to chrome
        if (browser.equalsIgnoreCase("chrome")) {
            // run headless or with ui
            if(Objects.equals(headless, "true")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                driver = new ChromeDriver(options);
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            // firefox
        } else if (browser.equalsIgnoreCase("firefox")) {
            if(Objects.equals(headless, "true")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless=new");
                driver = new FirefoxDriver(options);
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            // edge
        } else if (browser.equalsIgnoreCase("edge")) {
            if(Objects.equals(headless, "true")) {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=new");
                driver = new EdgeDriver(options);
            } else {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
    }

}
