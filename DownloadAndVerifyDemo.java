package TestingDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DownloadAndVerifyDemo {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Akshay Verma\\Drivers\\chromedriver_win32\\chromedriver.exe");
        //Running Browser in headless mode(in background)
        ChromeOptions options=new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://google.com");
        //https://chromedriver.chromium.org/capabilities   use this site

        //Downloading the screenshot to a specific directory
        ChromeOptions opt=new ChromeOptions();
        Map<String,Object> myMap=new HashMap<String,Object>();
        myMap.put("download.default_directory", "./Screenshots/");
        opt.setExperimentalOption("prefs", myMap);
        WebDriver driver2=new ChromeDriver(opt);

        //verify that the screenshot is downloaded or not
        File file=new File("./Screenshots/");
       File[] fl =file.listFiles();
        System.out.println(fl.length);

        //or we can write the above three lines as just one line:
        /*
       new File("./Screenshots/").listFiles().length
         */
        for(File filesRead:fl)
        {
            System.out.println(filesRead.exists());
            System.out.println(filesRead);
            System.out.println(filesRead.getAbsolutePath());
            System.out.println(filesRead.getName());
            System.out.println(filesRead.delete());
        }

    }
}
