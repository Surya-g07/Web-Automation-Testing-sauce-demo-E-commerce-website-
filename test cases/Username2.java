import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Username2{
        WebDriver ch = new ChromeDriver();
        @Test
        public void test() throws InterruptedException{
            ch.get("https://www.saucedemo.com/");
            String oldurl = ch.getCurrentUrl();
            ch.findElement(By.id("user-name")).sendKeys("problem_user");
            Thread.sleep(1000);
            ch.findElement(By.id("password")).sendKeys("secret_sauce");
            Thread.sleep(1000);
            ch.findElement(By.id("login-button")).click();

            Assert.assertNotEquals(oldurl, ch.getCurrentUrl(), "Test Failed: Login fails with valid creds");
            System.out.println("Test passed : Login successful");

        }
}
