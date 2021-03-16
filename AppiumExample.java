package android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumExample {
  WebDriver driver;
  WebDriverWait wait;
  String AppURL = "https://www.browserstack.com/";

  @BeforeTest
  public void setup() throws MalformedURLException {
    // Create an object for Desired Capabilities
    DesiredCapabilities capabilities = new DesiredCapabilities();


    // // Name of mobile web browser to automate.
    // capabilities.setCapability("browsername", "chrome");
    // // device name
    // capabilities.setCapability("name", "Pixel 4 API 24");
    // // Which mobile OS platform to use - iOS, Android, or FirefoxOS
    // capabilities.setCapability("platformName", "Android");
    // // Java package of the Android app you want to run
    // capabilities.setCapability("appPackage", "com.android.chrome");
    // // Activity name for the Android activity you want to launch from package
    // capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
    // // Initialize the driver object with the URL to Appium Server passing the capabilities.
    // Server
    // // Url may vary

    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 24");
    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
    // if chrome is installed, but not default one - use MobileBrowserType.CHROME


    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    wait = new WebDriverWait(driver, 5);
  }

  @Test
  public void testSearchAppium() {
    driver.get(AppURL);
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    driver.get("http://google.es");
    // String homePageTitle = titleElement.getText();
    // Assert.assertEquals(homePageTitle, "Most Reliable App & Cross Browser Testing Platform |
    // Browserstack");
    // WebElement LinkElement = driver.findElement(By.xpath("//body[@class='page-template-default
    // page page-id-593 page-parent live persistent-header wpb-js-composer js-comp-ver-6.0.5
    // vc_responsive']")).click();
    // wait.until(ExpectedConditions.presenceOfElementLocated(byPageTitle));
    // String searchPageTitle = driver.findElement(byPageTitle).getText();
    // Assert.assertEquals(searchPageTitle, "Search");
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}
