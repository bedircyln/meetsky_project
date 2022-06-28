package com.meetsky.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            byte var2 = -1;
            switch(browserType.hashCode()) {
                case -1361128838:
                    if (browserType.equals("chrome")) {
                        var2 = 0;
                    }
                    break;
                case -849452327:
                    if (browserType.equals("firefox")) {
                        var2 = 1;
                    }
            }

            switch(var2) {
                case 0:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case 1:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
            }
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}
