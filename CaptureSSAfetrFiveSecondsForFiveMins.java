package TestingDemos;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CaptureSSAfetrFiveSecondsForFiveMins {

    public void saveScreenshot(String fileName) throws AWTException, IOException {
        Robot robo=new Robot();
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rec=new Rectangle(dim);
        BufferedImage image=robo.createScreenCapture(rec);
        ImageIO.write(image,"png",new File(fileName));

    }
    public static void main(String[] args) throws AWTException, IOException {
        CaptureSSAfetrFiveSecondsForFiveMins sv=new CaptureSSAfetrFiveSecondsForFiveMins();
        int count=1;
        final long NANOSEC_PER_SEC = 1000l*1000*1000;

        long startTime = System.nanoTime();
        while((System.nanoTime()-startTime)< 5*60*NANOSEC_PER_SEC) {
            sv.saveScreenshot("C:\\Users\\Akshay Verma\\IdeaProjects\\PracticeProject\\Screenshots\\Myscreenshot_"+count+".png");
count++;
try{
    Thread.sleep(5000);
}
catch(Exception e)
{

}
        }
    }
}
