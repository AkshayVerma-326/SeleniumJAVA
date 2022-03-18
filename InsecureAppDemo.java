package TestingDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InsecureAppDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Akshay Verma\\Drivers\\chromedriver_win32\\chromedriver.exe");
                ChromeOptions opt=new ChromeOptions();
                opt.setAcceptInsecureCerts(true);      //this ChromeOption is used to access an insecure app
                WebDriver driver=new ChromeDriver(opt);
                driver.manage().window().maximize();
                driver.get("https://www.cacert.org");



    }
}
