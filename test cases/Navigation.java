import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Navigation extends Base {
    @Test(priority = 1)
    public void navigationTest() throws InterruptedException {
        ch.findElement(By.id("react-burger-menu-btn")).click();
        System.out.println("Navigation menu opens successfully");
        Thread.sleep(2000);
    }
}
