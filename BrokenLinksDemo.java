package TestingDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinksDemo {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Akshay Verma\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com");
        List<WebElement> allLinks=driver.findElements(By.tagName("a"));

        for(WebElement ele:allLinks){
            String href=ele.getAttribute("href");
             boolean status = verifyLinks(href);
        }
    }

    public static boolean verifyLinks(String appUrl){
        int code=0;
        try {

            URL url=new URL(appUrl);

                HttpURLConnection httpconnection= (HttpURLConnection) url.openConnection();
                httpconnection.connect();
                code= httpconnection.getResponseCode();
            System.out.println(code);



        } catch (MalformedURLException e) {

        }
        catch (IOException e) {

        }
        if (code>399) {
            return false;
        }
        else{
            return true;

        }
    }
}
