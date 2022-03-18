package TestingDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWaitDemo {

    public static void main(String[] args)
    {


        System.setProperty("webdriver.chrome.driver","C:\\Users\\Akshay Verma\\Drivers\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

        driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();

        /*
         *  Wait for webelement
         *  max 20
         *  polling 1 second
         *
         *
         */

       for(int i=0;i<20;i++)
       {
            try{
                driver.findElement(By.xpath("//*[text()='WebDriver']"));
                System.out.println("Element Found");
                break;
            }
            catch (NoSuchElementException ex)
           {
               try {
                   Thread.sleep(1000);
                   System.out.println("Finding Element");
               } catch (InterruptedException e) {
                   System.out.println("Element not found"+ex.getMessage());
               }
           }
        }
    }

}
