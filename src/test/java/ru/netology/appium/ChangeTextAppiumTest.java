package ru.netology.appium;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChangeTextAppiumTest {

        private AndroidDriver driver;

        @BeforeEach
        public void setUp() throws MalformedURLException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("appium:deviceName", "some name");
            desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
            desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
            desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
            desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
            desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
            desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
            desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

            URL remoteUrl = new URL("http://127.0.0.1:4723");

            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        }

        @Test
        public void sampleTest() {
            WebElement el1 = (WebElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
            el1.isDisplayed();
            el1.click();
            el1.sendKeys("111");
            WebElement el2 = (WebElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange"));
            el2.isDisplayed();
            el2.click();
            WebElement el3 = (WebElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
            el3.isDisplayed();
            el3.click();
            el3.sendKeys("   ");
            WebElement el4 = (WebElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange"));
            el4.isDisplayed();
            el4.click();
            WebElement el5 = (WebElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));
            el5.isDisplayed();

            Assertions.assertEquals(el5.getText(), "111");
        }

        @AfterEach
        public void tearDown() {
            driver.quit();
        }
    }


