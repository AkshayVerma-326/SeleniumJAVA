package TestingDemos;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Akshay Verma\\Drivers\\chromedriver_win32\\chromedriver.exe");
        //Running Browser in headless mode(in background)
        ChromeOptions options=new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://google.com");

        //TakesScreenshot
        TakesScreenshot scr=(TakesScreenshot) driver;
        File f1=scr.getScreenshotAs(OutputType.FILE);
        File file=new File("./Screenshots/MyScreenshot.png");

        try {
            FileHandler.copy(f1,file);
        } catch (IOException e) {
            System.out.println("Could not copy file"+e.getMessage());
        }

        Thread.sleep(10000);
        driver.close();
    }
}