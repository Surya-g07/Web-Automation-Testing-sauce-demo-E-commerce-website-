import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AbtDevMousehover extends Base {

    @Test(priority = 1)
    public void openAboutSection() throws InterruptedException {
        ch.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);

        ch.findElement(By.id("about_sidebar_link")).click();
        Thread.sleep(3000);

        System.out.println("About section opened");
        ch.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void developerMouseHover() throws InterruptedException {
        Actions a = new Actions(ch);

        WebElement dev = ch.findElement(By.xpath("//span[text()='Developers']/parent::div"));
        a.moveToElement(dev).perform();
        Thread.sleep(2000);

        WebElement dropdown = ch.findElement(By.xpath("//div[contains(@class,'dropdown')]"));

        if (dropdown.getSize().getHeight() > 0) {
            System.out.println("Mouse hover working. Developer dropdown visible");
        } else {
            System.out.println("Mouse hover failed");
        }
    }
}
