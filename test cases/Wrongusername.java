import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wrongusername{
    WebDriver ch = new ChromeDriver();

    @Test
    public void invalidUsernameTest() throws InterruptedException{
        ch.get("https://www.saucedemo.com/");
        System.out.println("Test case: Login with invalid username");

        ch.findElement(By.id("user-name")).sendKeys("surya");
        Thread.sleep(1000);
        ch.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        ch.findElement(By.id("login-button")).click();

        String url = ch.getCurrentUrl();

        Assert.assertFalse(
                url.contains("inventory.html"),
                "Fails: Login succeeded with invalid username"
        );

        System.out.println("Test passed: Login blocked for invalid username");
    }
}
