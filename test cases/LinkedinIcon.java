import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LinkedinIcon extends Base{
    
        @Test(priority=1)
        public void icon() throws InterruptedException{
            System.out.println("Test case: Verify the linkedin icon in the bottom");
            String oldurl = ch.getCurrentUrl();
            System.out.println("Home Page url : " + oldurl);
            Thread.sleep(2000);
            ch.findElement(By.className("social_linkedin")).click();
            Thread.sleep(2000);

            for (String win : ch.getWindowHandles()) {
                ch.switchTo().window(win);
            }
            Thread.sleep(2000);
            String twitterurl = ch.getCurrentUrl();
            Thread.sleep(2000);
            Assert.assertNotEquals(twitterurl, oldurl, "Test failed");
            System.out.println("Test passed: Navigated to another Tab");
        }
}
 
