package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium6NativeChrome {


    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //Appiumdan geliyor
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\IdeaProjects\\demo\\MobileTesting\\src\\Apps\\gestureTool.apk");
//        capabilities.setCapability("noReset", true);
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        //capabilities.setCapability("appActivity", "org.chromium.chrome.browser.ChromeTabbedActivity");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println(driver.getContext()  + "<=== First context when the app opened ");
        // App in habngi türleri olduğunu görmek için getContextHandles() methodu kullanıyoruz

        Set<String>butunTurler = driver.getContextHandles();
        for (String tur:  butunTurler
             ) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")){
                driver.context(tur);
            }
        }
        System.out.println(driver.getContext() +"<==Degisimden sonraki tur");
        Thread.sleep(2000);
        driver.get("https://amazon.com");
//        MobileElement accept = driver.findElementById("com.android.chrome:id/terms_accept");
//        accept.click();
//        driver.findElementById("com.android.chrome:id/positive_button").click();


        capabilities.setCapability("noReset", true);


    }
}