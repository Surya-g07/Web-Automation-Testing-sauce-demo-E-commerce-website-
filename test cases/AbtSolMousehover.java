import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AbtSolMousehover extends Base {
    @Test(priority = 1)
    public void about() throws InterruptedException {
        ch.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);
        ch.findElement(By.id("about_sidebar_link")).click();
        Thread.sleep(2000);
        System.out.println("About section opened");
        ch.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void mousehover() throws InterruptedException {
        Actions a = new Actions(ch);
        WebElement solutions =
                ch.findElement(By.xpath("//span[text()='Solutions']/parent::div"));

        a.moveToElement(solutions).perform();
        Thread.sleep(2000);

        WebElement dropdown =
                ch.findElement(By.xpath("//div[contains(@class,'dropdown')]"));

        assert dropdown.isDisplayed();
        System.out.println("Solution mouse hover works");
    }
}
