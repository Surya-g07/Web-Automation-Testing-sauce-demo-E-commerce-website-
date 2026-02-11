import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class User4{
        WebDriver ch = new ChromeDriver();
        @Test
        public void test() throws InterruptedException{
            ch.get("https://www.saucedemo.com/");
            System.out.println("Test case: Test with another valid username");
            String oldurl = ch.getCurrentUrl();
            ch.findElement(By.id("user-name")).sendKeys("error_user");
            Thread.sleep(2000);
            ch.findElement(By.id("password")).sendKeys("secret_sauce");
            Thread.sleep(2000);
            ch.findElement(By.id("login-button")).click();
            Assert.assertNotEquals(oldurl,ch.getCurrentUrl(), "Test Fails: Login fails with valid creds");
        }
}
