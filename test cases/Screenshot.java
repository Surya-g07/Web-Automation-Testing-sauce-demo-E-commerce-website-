import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class Screenshot {
    public static void capture(WebDriver ch, String testName) throws InterruptedException {
        File src = ((TakesScreenshot) ch).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + testName + ".png");
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
