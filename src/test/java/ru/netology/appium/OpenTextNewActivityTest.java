package ru.netology.appium;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class OpenTextNewActivityTest {

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
        public void sampleTest() throws InterruptedException {
            WebElement el1 = (WebElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
            el1.isDisplayed();
            el1.click();
            el1.sendKeys("222");
            WebElement el2 = (WebElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonActivity"));
            el2.isDisplayed();
            el2.click();
            Thread.sleep(500);
            WebElement el3 = (WebElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/text"));

            Assertions.assertEquals(el3.getText(), "222");

        }

        @AfterEach
        public void tearDown() {
            driver.quit();
        }
    }

