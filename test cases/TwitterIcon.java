import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TwitterIcon extends Base{
        @Test(priority=1)
        public void icon()throws InterruptedException{
            System.out.println("Test case: Ensures the twitter icon is working properly or not");
            String oldurl = ch.getCurrentUrl();
            System.out.println("Home Page url : " + oldurl);
            Thread.sleep(2000);
            ch.findElement(By.className("social_twitter")).click();
            Thread.sleep(2000);

            for (String win : ch.getWindowHandles()) {
                ch.switchTo().window(win);
            }
            Thread.sleep(2000);
            String twitterurl = ch.getCurrentUrl();
            Assert.assertNotEquals(oldurl,twitterurl, "Test fails: Tab not switched");
            System.out.println("Test case passed");
        }
}
