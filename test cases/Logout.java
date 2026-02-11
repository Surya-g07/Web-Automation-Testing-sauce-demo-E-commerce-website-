import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Logout extends Base{

        @Test(priority=1)
        public void test()throws InterruptedException{
            System.out.println("Test: Ensure the logout button is working properly");
            ch.findElement(By.id("react-burger-menu-btn")).click();
            Thread.sleep(1500);
            ch.findElement(By.id("logout_sidebar_link")).click();
            System.out.println("Test case passed: Logged out");
        }
}
