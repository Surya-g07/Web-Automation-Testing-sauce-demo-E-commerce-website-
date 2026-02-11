import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WrongPassword{
    WebDriver ch = new ChromeDriver();

    @Test
    public void testWrongPassword() throws InterruptedException{
        ch.get("https://www.saucedemo.com/");
        ch.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        ch.findElement(By.id("password")).sendKeys("abcdefgh");
        Thread.sleep(2000);
        ch.findElement(By.id("login-button")).click();

        System.out.println("Test case: Login with wrong password");

        String url = ch.getCurrentUrl();

        Assert.assertFalse(
                url.contains("inventory.html"),
                "Login succeeded with wrong password"
        );

        System.out.println("Login blocked for wrong password");
    }
}
