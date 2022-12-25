package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium5 {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //Appiumdan geliyor
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\IdeaProjects\\demo\\MobileTesting\\src\\Apps\\Calculator.apk");

        //Eğer appi  izinler atlayarak ana sayfada açılmasını istiyorsak aşağıdaki komutu kullanırız
        capabilities.setCapability("noReset", true);

        AndroidDriver<MobileElement>
                driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        if (driver.isDeviceLocked()) {
            driver.unlockDevice();
        }
        //We have located all the digits in our calculator app
        MobileElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");
        MobileElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");

        //Below we have located the operational symbols
        MobileElement plus = driver.findElementByAccessibilityId("plus");
        MobileElement minus = driver.findElementByAccessibilityId("minus");
        MobileElement divide = driver.findElementByAccessibilityId("divide");
        MobileElement multiply = driver.findElementByAccessibilityId("multiply");
        MobileElement equals = driver.findElementByAccessibilityId("equals");


        //Sample 64+71
        num6.click();
        num4.click();
        plus.click();
        num7.click();
        num1.click();
        Thread.sleep(2000);

        MobileElement preResult = driver.findElementById("com.google.android.calculator:id/result_preview");
        String preResultText = preResult.getText();
        System.out.println("preResult = " + preResult);

        equals.click();

        MobileElement finalResult = driver.findElementById("com.google.android.calculator:id/result_final");
        System.out.println("FinalResult: " + finalResult);



        Assert.assertEquals(finalResult.getText(),preResultText);

        //Session kapat
        //
        //  driver.closeApp();
    }
}