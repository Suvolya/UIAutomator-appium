package ru.netology.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.*;
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
            MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
            el1.isDisplayed();
            el1.click();
            el1.sendKeys("111");
            MobileElement el2 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
            el2.isDisplayed();
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
            el3.isDisplayed();
            el3.click();
            el3.sendKeys("   ");
            MobileElement el4 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
            el4.isDisplayed();
            el4.click();
            MobileElement el5 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/textToBeChanged");
            el5.isDisplayed();

            Assertions.assertEquals(el5, "111");
        }

        @AfterEach
        public void tearDown() {
            driver.quit();
        }
    }

}
