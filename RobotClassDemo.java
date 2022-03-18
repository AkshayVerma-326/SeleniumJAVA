package TestingDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RobotClassDemo {
    public static void main(String[] args) throws AWTException, IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Akshay Verma\\Drivers\\chromedriver_win32\\chromedriver.exe");
        Robot robo=new Robot();
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rec=new Rectangle(dim);
        BufferedImage image=robo.createScreenCapture(rec);
        ImageIO.write(image,"png",new File("C:\\Users\\Akshay Verma\\IdeaProjects\\PracticeProject\\Screenshots\\Myscreenshot.png"));
        WebDriver driver= new ChromeDriver();
        driver.get("https://wwww.facebook.com");
        robo.keyPress(KeyEvent.VK_ENTER);
        robo.keyRelease(KeyEvent.VK_ENTER);

        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_P);

        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_P);






    }
}
