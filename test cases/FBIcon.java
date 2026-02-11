import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FBIcon extends Base {

    @Test(priority = 1)
    public void iconTest() throws InterruptedException{
        String oldUrl = ch.getCurrentUrl();

        WebElement fbIcon = wait.until(
                ExpectedConditions.elementToBeClickable(By.className("social_facebook"))
        );
        fbIcon.click();
        Thread.sleep(2000);
        for (String win : ch.getWindowHandles()) {
            ch.switchTo().window(win);
        }
        Thread.sleep(2000);
        String newUrl = ch.getCurrentUrl();

        Assert.assertNotEquals(
                newUrl,
                oldUrl,
                "Facebook icon did not navigate to a new page"
        );
        System.out.println("Test passed");
    }
}
