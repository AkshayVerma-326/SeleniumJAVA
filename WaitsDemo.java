package TestingDemos;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitsDemo {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Akshay Verma\\Drivers\\chromedriver_win32\\chromedriver.exe");
        //Running Browser in headless mode(in background)
        ChromeOptions options=new ChromeOptions();
        options.setHeadless(false); //set true to run in headless
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();

        //PageLoadTimeOut:
        WebDriver.Timeouts time=driver.manage().timeouts();
        time.pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("http://google.com");

        //ScriptLoadTimeOut:
        WebDriver.Timeouts time2=driver.manage().timeouts();
        time2.scriptTimeout(Duration.ofSeconds(20));

        //Implicitly Wait:

        WebDriver.Timeouts time3=driver.manage().timeouts();
        time3.implicitlyWait(Duration.ofSeconds(20));

        //WebDriverWait - Explicit wait
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("")));

        //Fluent wait: [Wait is the interface and FluentWait,WebDriverWait are the implementation classes]
        Wait<WebDriver> wait1=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class);

        WebElement element=wait1.until(new Function<WebDriver,WebElement>()
        {
            public  WebElement apply(WebDriver ldriver)
            {
                WebElement element=ldriver.findElement(By.xpath("//p[@id='demo']"));

                if(element.getText().equalsIgnoreCase("***Any TExt you want to wait to get displayed***"))
                {
                    System.out.println("Text found "+element.getText());

                    return element;
                }
                else
                {
                    System.out.println("Text Not found Still Searching "+element.getText());
                    return null;
                }

            }

        });
        System.out.println("Done-"+element.isDisplayed());

    }
}
