package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium4 {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //  capabilities.setCapability("platformName", "Android");


        //  capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android"); //Seleniumdan geliyor
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //Appiumdan geliyor
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\IdeaProjects\\demo\\MobileTesting\\src\\Apps\\gestureTool.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");// KOnsola adbs shell enter yapıp "dumpsys window | grep -E "mCurrentFocus" enter"
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        //Eğer appi  izinler atlayarak ana sayfada açılmasını istiyorsak aşağıdaki komutu kullanırız
       capabilities.setCapability("noReset", true);

        AndroidDriver<MobileElement>
                driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        if (driver.isDeviceLocked()){
            driver.unlockDevice();
        }

        System.out.println("App has been installed");



        MobileElement homeScreenTitle = driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana sayda acildi");



        MobileElement addGestureButtond = driver.findElementById("com.davemac327.gesture.tool:id/addButton");
        addGestureButtond.click();
        System.out.println("Add Gesture buttonuna basildi");


        Thread.sleep(3000);
        MobileElement textEntry = driver.findElementByClassName("android.widget.EditText");
        textEntry.sendKeys("TechPro");
        System.out.println("Text kutusuna metin girildi");
        //Session kapat
      //
        //  driver.closeApp();
    }
}